package ru.hse.miem.distributed;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ru.hse.miem.distributed.operations.HelloWorldOperation;

public class App {
	public static ExecutorService executor = Executors.newSingleThreadExecutor();

	public static void main(String[] args) {
		Thread thread = new Thread(() -> {
			for (int i = 0; i < 20; i++) {
				String threadName = Thread.currentThread().getName();
				System.out.println("Hello world from thread: " + threadName + "!!! i=" + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ignored) {

				}
			}
		}, "Operation[Hello]");

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

//		executor.submit(new HelloWorldOperation());

		for (int i = 0; i < 20; i++) {
			String threadName = Thread.currentThread().getName();
			System.out.println("Hello world from thread: " + threadName + " i=" + i);
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
