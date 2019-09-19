package eu.nets.ms.pia.business.sync;

import java.io.Serializable;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * The Class SyncServiceImpl.
 * 
 */
@Service
public class SyncServiceImpl implements SyncService {
	private static final long LOCK_COMMAND_TMO = 100L;
	private static final Logger LOGGER = LoggerFactory.getLogger(SyncServiceImpl.class);
	private LockService lockService;
	private LockerRunnable lockerWorker;
	private SynchronousQueue<LockOperation> lockCommandQ = new SynchronousQueue<>();

	@PostConstruct
	public void init() {
		lockService = new LockService();
		startLockerThread();
	}
	
	@PreDestroy
	public void exit(){
		lockerWorker.exit();
	}

	private long startLockerThread() {
		lockerWorker = new LockerRunnable();
		Thread theThread = new Thread(lockerWorker);
		theThread.start();
		return theThread.getId();
	}

	
	/*
	 * Lock Service implementation
	 */

	@Override
	public void createLock(String lockOwner) {
		LOGGER.info(">>>createLock: {}",  lockOwner);
		LockOperation operation = new LockOperation(lockOwner, LockOperator.CREATE);
		submitLockRequest(operation);
	}

	@Override
	public boolean tryCreateLock(String lockOwner) {
		LOGGER.info(">>>tryCreateLock: {}",  lockOwner);
		Lock lock = lockService.getLock( lockOwner);
		if (lock != null) {
			return lock.tryLock();
		}
		return true;
	}

	@Override
	public boolean waitForLockAvailable(String lockOwner, long timeoutMillies) {
		LOGGER.debug(">>>waitForLockAvailable: {}",  lockOwner);
		Lock lock = lockService.getLock(lockOwner);
		if (lock != null) {
			try {
				boolean lockAquired = lock.tryLock(timeoutMillies, TimeUnit.MILLISECONDS);
				if (lockAquired) {
					lock.unlock();
					LOGGER.debug("<<<waitForLockAvailable-unlock: {}", lockOwner);
				}else{
					LOGGER.debug("<<<waitForLockAvailable tmo: {}", lockOwner);
				}
				return lockAquired;
			} catch (InterruptedException e) {
				LOGGER.error("Interrupted waiting for lock on:{}", lockOwner, e);
			}
		}
		return true;
	}

	@Override
	public void releaseLock(String lockOwner) {
		LOGGER.info(">>>releaseLock: {}", lockOwner);
		LockOperation operation = new LockOperation(lockOwner, LockOperator.RELEASE);
		submitLockRequest(operation);
		}
	
	@Override
	public boolean lockExists(String lockOwner) {
		return lockService.getLock(lockOwner) == null ? false:true;
	}
	
	private void submitLockRequest(LockOperation operation) {
		try {
			boolean success = lockCommandQ.offer(operation,	LOCK_COMMAND_TMO, TimeUnit.MILLISECONDS);
			if (success) {
				LOGGER.info("Submit {} on:{}", operation.getOperator(), operation.getOperand());
			}
		} catch (InterruptedException e) {
			LOGGER.error("Error submitting {} on:{}", operation.getOperator(), operation.getOperand(), e);
		}
	}
	
	public enum LockOperator {
		CREATE, AQUIRE, RELEASE
	}

	static class LockOperation implements Serializable {
		private static final long serialVersionUID = 1L;
		private final String operand;
		private final LockOperator operator;

		LockOperation(String operand, LockOperator operator) {
			this.operand = operand;
			this.operator = operator;
		}

		String getOperand() {
			return operand;
		}

		LockOperator getOperator() {
			return operator;
		}

	}

	/**
	 * The Class LockingThread. This thread will own the locks created by this
	 * process. It receives locking requests from other threads within the same
	 * process via lockCommandQ
	 */
	private class LockerRunnable implements Runnable {
		private boolean terminate = false;
		
		void exit(){
			terminate = true;
		}
		
		public void run() {
			
			while (!terminate) {
				LockOperation operation;
				try {
					operation = lockCommandQ.take();
					
					if (LockOperator.CREATE.equals(operation.getOperator())) {
						lockService.createLock(operation.getOperand());
					} else if (LockOperator.RELEASE.equals(operation.getOperator())) {
						//If the lock is not owned by this thread it is a no-op
						lockService.releaseLock(operation.getOperand());
					}
				} catch (InterruptedException e) {
					LOGGER.error("Locking thread encoutered an error", e);
				}
			}
		}
	}
}
