package ro.ase.acs.classes;

public class SummingThread extends Thread {
    private int[] array;
    private int startIndex;
    private int endIndex;
    private long sum;

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    public SummingThread(int[] array, int startIndex, int endIndex) {
        this.array = array;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        super.run();
        for (int i = startIndex; i < endIndex; i++) {
            sum += array[i];
        }
    }
}
