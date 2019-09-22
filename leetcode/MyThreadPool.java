import java.util.concurrent.*;

public class MyThreadPool {
	private LinkedBlockingQueue<Runnable> queue;
	private WorkerThread[] workers;

	public MyThreadPool(int nThreads) {
		this.workers = new WorkerThread[nThreads];
		this.queue = new LinkedBlockingQueue();

		for(int i = 0; i < workers.length; i++) {
			this.workers[i] = new WorkerThread();
			this.workers[i].start();
		}
	}

	public void execute(Runnable task) {
		synchronized(this.queue) {
			this.queue.add(task);
			this.queue.notify();
		}
	}

	private class WorkerThread extends Thread {

		public void run() {

			while(true) {

			Runnable task = null;
			synchronized(queue) {

				while(queue.isEmpty()) {
						try{
							queue.wait();

						} catch(InterruptedException exception) {
							System.out.println(exception);
						}
						
				}

				task = queue.poll();
			}

			try{
				task.run();			
			} catch(RuntimeException exception) {
				System.out.println(exception);
			}
		}
	}
	}

	private static class MyTask implements Runnable {
		int num;

		public MyTask(int num) {
			this.num = num;
		}

		public void run() {

			System.out.println("Task" + this.num + " is running");
		}
	}

	public static void main(String[] args) {
			MyTask[] tasks = new MyTask[6];
			MyThreadPool pool = new MyThreadPool(1);

			for(int i = 0; i < 6; i++) {
				tasks[i] = new MyTask(i);

				pool.execute(tasks[i]);

			}

	}
}