import java.util.concurrent.*;

public class Client implements Runnable {
    private final String name;
    private final Account account;
    private final Semaphore semaphore;

    public Client(String name, Account account, Semaphore semaphore) {
        this.name = name;
        this.account = account;
        this.semaphore = semaphore;
    }

    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                semaphore.acquire();
                try {
                    Thread.sleep((long) (Math.random() * 1000));
                    if (Math.random() > 0.5) {
                        account.deposit(100);
                    } else {
                        account.withdraw(50);
                    }
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " was interrupted.");
                } finally {
                    semaphore.release();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
