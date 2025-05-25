package ro.ase.acs.main;

import ro.ase.acs.classes.SummingCallable;
import ro.ase.acs.classes.SummingThread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[200_000_000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        long startTime = System.currentTimeMillis();
        long sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Single thread sum = " + sum + " computed in " +
                (endTime - startTime) + " ms");

        int numberOfThreads = 4;
        startTime = System.currentTimeMillis();
        sum = 0;
        SummingThread[] threadArray = new SummingThread[numberOfThreads];
        for (int i = 0; i < threadArray.length; i++) {
            threadArray[i] = new SummingThread(array,
                    i * (array.length / numberOfThreads),
                    (i + 1) * (array.length / numberOfThreads));
            threadArray[i].start();
        }

        for (int i = 0; i < threadArray.length; i++) {
            try {
                threadArray[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            sum += threadArray[i].getSum();
        }

        endTime = System.currentTimeMillis();
        System.out.println("Thread array sum = " + sum + " computed in " +
                (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        sum = 0;

        ExecutorService threadPool = Executors.newFixedThreadPool(numberOfThreads);
        for (int i = 0; i < numberOfThreads; i++) {
            threadArray[i].setSum(0);
            threadPool.submit(threadArray[i]);
        }

        threadPool.shutdown();

        try {
            threadPool.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < threadArray.length; i++) {
            sum += threadArray[i].getSum();
        }

        endTime = System.currentTimeMillis();
        System.out.println("Thread Pool sum = " + sum + " computed in " +
                (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        sum = 0;

        ExecutorService callablePool = Executors.newFixedThreadPool(numberOfThreads);
        List<Future<Long>> results = new ArrayList<>();

        for (int i = 0; i < numberOfThreads; i++) {
            Future<Long> result = callablePool.submit(new SummingCallable(array,
                    i * (array.length / numberOfThreads),
                    (i + 1) * (array.length / numberOfThreads)));
            results.add(result);
        }
        callablePool.shutdown();
        try {
            callablePool.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (Future<Long> f : results) {
            try {
                sum += f.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println("Callable Pool sum = " + sum + " computed in " +
                (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        sum = Arrays.stream(array).parallel().mapToLong(x -> x).sum();
        endTime = System.currentTimeMillis();
        System.out.println("Parallel stream sum = " + sum + " computed in " +
                (endTime - startTime) + " ms");
    }
}
