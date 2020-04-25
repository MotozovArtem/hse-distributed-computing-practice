package ru.hse.miem.distributed;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ru.hse.miem.distributed.operations.HelloWorldOperation;

public class App {
	public static ExecutorService executor = Executors.newSingleThreadExecutor((r) -> {
		Thread t = new Thread(r,"Threads-With-MAX_PRIORITY");
		t.setPriority(Thread.MAX_PRIORITY);
		return t;
	});

	public static String getPrettyPriority(int priorityLevel) {
		if (priorityLevel > Thread.MAX_PRIORITY || priorityLevel < Thread.MIN_PRIORITY) {
			throw new IllegalArgumentException("Priority level cannot be lower " +
					"than MIN_PRIORITY or greater than MAX_PRIORITY");
		}
		if (priorityLevel == 5) {
			return "NORM_PRIORITY";
		}
		if (priorityLevel == 10) {
			return "MAX_PRIORITY";
		}
		if (priorityLevel == 1) {
			return "MIN_PRIORITY";
		}
		return Integer.toString(priorityLevel);
	}

	public static void main(String[] args) {
		Thread thread = new Thread(() -> {
			Thread currentThread = Thread.currentThread();
			String threadName = currentThread.getName();
			for (int i = 0; i < 10; i++) {
				System.out.println("Hello world from thread: " + threadName + "!!! i=" + i);
				System.out.println("Thread priority: " + getPrettyPriority(currentThread.getPriority()));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ignored) {

				}
			}
		}, "Operation[Hello]");
		thread.setPriority(1);

        /* 
        Эквивалентно записи 
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 20; i++) {
                        String threadName = Thread.currentThread().getName();
                        System.out.println("Hello world fron thread: " + threadName);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ignored) {
                            
                        }
                    }
                }
            }, "Operation[Hello]");
        */
		thread.start();

		executor.submit(new HelloWorldOperation());

		Thread currentThread = Thread.currentThread();
		String threadName = currentThread.getName();
		for (int i = 0; i < 10; i++) {
			System.out.println("Hello world from thread: " + threadName + " i=" + i);
			System.out.println("Thread priority: " + getPrettyPriority(currentThread.getPriority()));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ignored) {
			}
		}

		try {
			thread.join();
		} catch (InterruptedException e) {

		}

		executor.shutdown();
	}
}
