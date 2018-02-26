//***********************************************************************************
//  Rajat Patel
//  Lockable
//  3/30/2017
//  Contains methods for locking and unlocking objects with a security key
//***********************************************************************************

public interface Lockable 
{
	public void setKey(int newKey);
	public void lock(int attempt);
	public void unlock(int attempt);
	public boolean locked();
}
/*
Tails
Heads
Heads
Tails
Tails
Heads
Heads
Heads
Tails
Heads
Locked
Locked
Locked
Locked
Locked
Heads
Tails
Tails
Tails
Heads
Locked
Locked
Locked
Locked
Locked
Heads
Tails
Tails
Tails
Heads
Locked
Locked
Locked
Locked
Locked
Heads
Heads
Heads: 12	Tails: 10	Locked: 15
*/