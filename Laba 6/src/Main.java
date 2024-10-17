import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Account account1 = new Account(1000);
        Account account2 = new Account(1500);

        Semaphore semaphore = new Semaphore(1);
        Client client1 = new Client("Client 1", account1, semaphore);
        Client client2 = new Client("Client 2", account2, semaphore);

        // 1. Creating threads
        Thread thread1 = new Thread(client1, "Client 1 Thread");
        Thread thread2 = new Thread(client2, "Client 2 Thread");

        // 4. Setting thread properties (priority, name)
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);

        // 2. Starting threads
        thread1.start();
        thread2.start();

        // 3. Using Thread.sleep() to simulate delays
        Thread.sleep(5000);
        thread1.interrupt(); // 2. Forced stopping of threads
        thread2.interrupt();

        thread1.join();
        thread2.join();

        System.out.println("Final balance of Client 1: " + account1.getBalance());
        System.out.println("Final balance of Client 2: " + account2.getBalance());

        // Simulate transferring funds between accounts
        Thread transferThread = new Thread(() -> {
            try {
                if (!account1.transfer(account2, 500)) {
                    System.out.println("Transfer failed.");
                }
            } catch (InterruptedException e) {
                System.out.println("Transfer thread was interrupted.");
            }
        }, "Transfer Thread");

        transferThread.start();
        transferThread.join();

        System.out.println("Final account balances:");
        System.out.println("Client 1 Account: " + account1.getBalance());
        System.out.println("Client 2 Account: " + account2.getBalance());
    }
}
