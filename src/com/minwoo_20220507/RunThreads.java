package com.minwoo_20220507;

public class RunThreads {
    public static void main(String[] args) {
        RunThreads threads = new RunThreads();
        threads.runBasic();
    }
    public void runBasic() {
        RunnableSaple runnable = new RunnableSaple();
        new Thread(runnable).start();

        ThreadSample thread = new ThreadSample();
        thread.start();
        System.out.println("RunThreads.runBasic() method is ended");
    }

}
