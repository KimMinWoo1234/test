package com.minwoo_20220507;

public class RunMultiThreads {
    public static void main(String[] args) {
        RunMultiThreads sample = new RunMultiThreads();
        sample.runMultiThread();
    }
    public void runMultiThread() {
        RunnableSaple []runnable = new RunnableSaple[5];
        ThreadSample []thread = new ThreadSample[5];
        for(int loop = 0; loop < 5; loop++) {
            runnable[loop] = new RunnableSaple();
            thread[loop] = new ThreadSample();

            new Thread(runnable[loop]).start();
            thread[loop].start();
        }
        System.out.println("RunMultiThreads.runMultiThread() method is ended.");
    }
}
