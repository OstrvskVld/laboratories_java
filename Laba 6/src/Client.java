import java.util.concurrent.*;

public class Client implements Runnable {
    private final String name;
    private final Account account;
    private final Semaphore semaphore; // 14. Semaphore

    public Client(String name, Account account, Semaphore semaphore) {
        this.name = name;
        this.account = account;
        this.semaphore = semaphore;
    }

    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                semaphore.acquire(); // 13. Inter-thread Communication
                try {
                    Thread.sleep((long) (Math.random() * 1000)); // 3. Simulating delays
                    if (Math.random() > 0.5) {
                        account.deposit(100);
                    } else {
                        account.withdraw(50);
                    }
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " was interrupted."); // 2. Thread interruption
                } finally {
                    semaphore.release();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
