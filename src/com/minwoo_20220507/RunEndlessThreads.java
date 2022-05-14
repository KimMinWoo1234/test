package com.minwoo_20220507;

public class RunEndlessThreads {
    public static void main(String[] args) {
        RunEndlessThreads sample = new RunEndlessThreads();
        sample.endless();
    }
    public void endless() {
        EndelssThread thread = new EndelssThread();
        thread.start();
    }
}
