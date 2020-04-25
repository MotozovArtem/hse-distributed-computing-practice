package ru.hse.miem.distributed.operations;

import ru.hse.miem.distributed.App;

public class HelloWorldOperation implements Runnable {

	@Override
	public void run() {
		Thread currentThread = Thread.currentThread();
		String threadName = currentThread.getName();
		for (int i = 0; i < 10; i++) {
			System.out.println("Hello world from thread: " + threadName + "!!! i=" + i);
			System.out.println("Thread priority: " + App.getPrettyPriority(currentThread.getPriority()));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ignored) { }
		}
	}

}