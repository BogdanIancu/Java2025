package ro.ase.acs.main;

import ro.ase.acs.classes.SyncedThread;
import ro.ase.acs.classes.UnsyncedThread;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        UnsyncedThread t1=new UnsyncedThread();
//        t1.start();
//        UnsyncedThread t2=new UnsyncedThread();
//        t2.start();

        SyncedThread t3 = new SyncedThread();
        new Thread(t3).start();
        SyncedThread t4 = new SyncedThread();
        new Thread(t4).start();

        new Thread(() -> {
            System.out.println("Message from another thread.");
        }).start();
        System.out.println("Message from main thread");

        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        int sum = list.parallelStream().reduce((x, y) -> x + y).get();
        System.out.println(sum);

    }
}
