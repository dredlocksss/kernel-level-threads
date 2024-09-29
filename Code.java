class ThreadExample extends Thread {
    private String threadName;

    public ThreadExample(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        System.out.println(threadName + " is starting.");

        try {
            // Simulate some work with sleep
            for (int i = 0; i < 5; i++) {
                System.out.println(threadName + " is working...");
                Thread.sleep(1000); // Sleep for 1 second
            }
        } catch (InterruptedException e) {
            System.out.println(threadName + " was interrupted.");
        }

        System.out.println(threadName + " is finished.");
    }

    public static void main(String[] args) {
        // Create and start threads
        ThreadExample thread1 = new ThreadExample("Thread 1");
        ThreadExample thread2 = new ThreadExample("Thread 2");
        ThreadExample thread3 = new ThreadExample("Thread 3");

        thread1.start();
        thread2.start();
        thread3.start();
        
        // Wait for threads to finish
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
        }

        System.out.println("All threads have finished.");
    }
}
