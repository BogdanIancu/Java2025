package ro.ase.acs.classes;

public class SyncedThread implements Runnable {
    private static int a = 0;
    private static int b = 0;
    private static Object lock = new Object();

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (lock) {
                System.out.println("a=" + a + " b=" + b);
                a++;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                b++;
            }
        }
    }
}
