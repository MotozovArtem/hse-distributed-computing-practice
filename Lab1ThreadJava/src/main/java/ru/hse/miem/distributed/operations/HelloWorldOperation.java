package ru.hse.miem.distributed.operations;

public class HelloWorldOperation implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			String threadName = Thread.currentThread().getName();
			System.out.println("Hello world from thread: " + threadName + "!!! i=" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ignored) {

			}
		}
	}

}