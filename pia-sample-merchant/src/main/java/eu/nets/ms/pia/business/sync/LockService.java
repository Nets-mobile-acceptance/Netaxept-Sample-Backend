package eu.nets.ms.pia.business.sync;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockService {
	private Map<String, Lock> lockMap = new ConcurrentHashMap<>();
	
	public Lock createLock(String name){
		Lock lock = new ReentrantLock();
		lockMap.put(name, lock);
		lock.lock();
		return lock;
	}
	
	public void releaseLock(String name){
		if(lockMap.containsKey(name)){
			lockMap.get(name).unlock();
			lockMap.remove(name);
		}
	}
	public Lock getLock(String name){
		return lockMap.get(name);
	}
}
