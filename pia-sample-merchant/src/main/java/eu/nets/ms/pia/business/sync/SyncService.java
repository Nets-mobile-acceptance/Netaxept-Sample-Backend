package eu.nets.ms.pia.business.sync;

public interface SyncService {

	boolean tryCreateLock(String lockOwner);
	void createLock(String lockOwner);
	boolean waitForLockAvailable(String lockOwner, long timeoutMillies);
	void releaseLock(String lockOwner);
	boolean lockExists(String lockOwner);
}
