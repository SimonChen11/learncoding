import java.util.concurrent.*;
 
public class ThreadPool {
    private final int nThreads;
    private final PoolWorker[] threads;
    private final LinkedBlockingQueue<Runnable> queue;
 
    public ThreadPool(int nThreads) {
        this.nThreads = nThreads;
        queue = new LinkedBlockingQueue();
        threads = new PoolWorker[nThreads];
 
        for (int i = 0; i < nThreads; i++) {
            threads[i] = new PoolWorker();
            threads[i].start();
        }
    }
 
    public void execute(Runnable task) {
        synchronized (queue) {
            queue.add(task);
            queue.notify();
        }
    }
 
    private class PoolWorker extends Thread {
        public void run() {
            Runnable task;
 
            while (true) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {

                            System.out.println("waiting" + Thread.currentThread().getName());
                            queue.wait();

                            System.out.println("wake up" + Thread.currentThread().getName());

                        } catch (InterruptedException e) {
                            System.out.println("An error occurred while queue is waiting: " + e.getMessage());
                        }
                    }
                    task = queue.poll();
                }
 
                // If we don't catch RuntimeException,
                // the pool could leak threads
                try {
                    System.out.println("Running" + Thread.currentThread().getName());
                    task.run();
                } catch (RuntimeException e) {
                    System.out.println("Thread pool is interrupted due to an issue: " + e.getMessage());
                }
            }
        }
    }

    private static class Task implements Runnable {
     
        private int num;
     
        public Task(int n) {
            num = n;
        }
     
        public void run() {
            System.out.println("Task " + num + " is running by" +  Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        ThreadPool pool = new ThreadPool(7);
 
        for (int i = 0; i < 5; i++) {
            Task task = new Task(i);
            pool.execute(task);
        }
    }
}