package eu.nets.ms.pia.business.sync;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eu.nets.ms.pia.business.sync.SyncServiceImpl.LockOperation;
import eu.nets.ms.pia.business.sync.SyncServiceImpl.LockOperator;

public class SyncServiceTest {
	private static final int STATUS_POLL_TIMEOUT = 8000;
	private static final String TEST_TRANS_ID = "1234";
	
	private LockOperation create = new SyncServiceImpl.LockOperation(TEST_TRANS_ID, LockOperator.CREATE);
	private LockOperation tryAquire = new SyncServiceImpl.LockOperation(TEST_TRANS_ID, LockOperator.AQUIRE);
	private LockOperation release = new SyncServiceImpl.LockOperation(TEST_TRANS_ID, LockOperator.RELEASE);
	
	private boolean threadStarted = false;
	private long threadId;
	
	private List<LoggedCall> callStack = new ArrayList<>();
	
	private SyncService syncService = new SyncServiceImpl();
	
	@Before
	public void init(){
		if (!threadStarted) {
			((SyncServiceImpl)syncService).init();
			threadStarted = true;
		}
	}
	@After 
	public void tearDown(){
		callStack.clear();
	}
	
	@Test
	public void shouldBlockExecutionOfSecondThread() throws InterruptedException {
		syncService.createLock(TEST_TRANS_ID);
		logg(LockOperator.CREATE);
		
		//This second thread will attempt to aquire the lock
		(new Thread(new CallingThreadMock(tryAquire))).start();
		Thread.sleep(STATUS_POLL_TIMEOUT + 1000);
		
		//First thread release the lock
		syncService.releaseLock(TEST_TRANS_ID);
		logg(LockOperator.RELEASE);
		
		Thread.sleep(500);
		
		long lockingThread = callStack.get(0).getThreadId();
		
		assertThat(callStack.get(0).getOperator(), equalTo("CREATE"));
		assertThat(callStack.get(1).getOperator(), equalTo("RELEASE"));
		assertThat(callStack.size(), equalTo(2));
		
	}
	
	
	
	/**
	 * One thread should wait for release lock.
	 * 
	 * This simulates this scenario:
	 * * A lock is created in the thread where the transaction is registered
	 * * A cli 
	 * 
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	@Test
	public void oneThreadShouldWaitForReleaseLock() throws InterruptedException {
		
		syncService.createLock(TEST_TRANS_ID);
		logg(LockOperator.CREATE);
		
		(new Thread(new CallingThreadMock(tryAquire))).start();
		
		Thread.sleep(STATUS_POLL_TIMEOUT -1000);
		//This simulates a callback that will release a lock
		(new Thread(new CallingThreadMock(release))).start();
		
		Thread.sleep(STATUS_POLL_TIMEOUT);
		/*The thread trying to aquire the lock should not succeed*/
		assertThat(callStack.size(), equalTo(3));
		assertThat(callStack.get(0).getThreadId(), not(equalTo(callStack.get(1).getThreadId())));
		assertThat(callStack.get(2).getOperator(), equalTo("AQUIRE"));
		
		
	}
	
	/*
	 * Thread for mocking calls
	 */

	public class CallingThreadMock implements Runnable {

		LockOperation operation;

		public CallingThreadMock(LockOperation operation) {
			this.operation = operation;
		}

		public void run() {
			try {
				// Simulated response time
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (LockOperator.AQUIRE.equals(operation.getOperator())) {
				if(syncService.waitForLockAvailable(TEST_TRANS_ID, STATUS_POLL_TIMEOUT)){
					logg(LockOperator.AQUIRE);
				}
				
			}else if (LockOperator.CREATE.equals(operation.getOperator())) {
				syncService.createLock(TEST_TRANS_ID);
				logg(LockOperator.CREATE);
			}else if (LockOperator.RELEASE.equals(operation.getOperator())) {
				syncService.releaseLock(TEST_TRANS_ID);
				logg(LockOperator.RELEASE);
			}
		}
	}
	
	private void logg(LockOperator operator){
		callStack.add(new LoggedCall(operator));
	}
	
	private class LoggedCall{
		private final long threadId;
		private final String operator;
		
		public LoggedCall(LockOperator operator){
			this.threadId = Thread.currentThread().getId();
			this.operator = operator.name();
		}

		public long getThreadId() {
			return threadId;
		}
		
		public String getOperator() {
			return operator;
		}
	}
	
	

}
