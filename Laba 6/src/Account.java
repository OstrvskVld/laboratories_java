import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class Account {
    private double balance;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(); // 12. ReentrantReadWriteLock
    private final Lock transferLock = new ReentrantLock(); // 9. ReentrantLock
    private final Condition sufficientFunds = transferLock.newCondition(); // 15. Condition variables

    public Account(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        lock.writeLock().lock();
        try {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " deposited " + amount);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void withdraw(double amount) {
        lock.writeLock().lock();
        try {
            if (balance >= amount) {
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " withdrew " + amount);
            } else {
                System.out.println(Thread.currentThread().getName() + " insufficient funds for withdrawal.");
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    public boolean transfer(Account target, double amount) throws InterruptedException {
        if (transferLock.tryLock(1, TimeUnit.SECONDS)) { // 10. LockInterruptibly and 11. tryLock
            try {
                while (balance < amount) {
                    System.out.println(Thread.currentThread().getName() + " waiting for sufficient funds to transfer.");
                    sufficientFunds.await(); // 16. wait(), notify(), notifyAll()
                }
                withdraw(amount);
                target.deposit(amount);
                System.out.println(Thread.currentThread().getName() + " transferred " + amount + " to another account.");
                sufficientFunds.signalAll(); // Notify other threads
                return true;
            } finally {
                transferLock.unlock();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + " could not obtain lock for transfer.");
            return false;
        }
    }

    public double getBalance() {
        lock.readLock().lock();
        try {
            return balance;
        } finally {
            lock.readLock().unlock();
        }
    }
}
