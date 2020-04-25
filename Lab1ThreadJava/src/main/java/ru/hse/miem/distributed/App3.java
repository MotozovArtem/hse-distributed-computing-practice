package ru.hse.miem.distributed;

public class App3 {

	public static void main(String[] args) {
		ThreadGroup groupA = new ThreadGroup("Группа А");
		ThreadGroup groupB = new ThreadGroup("Группа Б");

		MyThread thread1 = new MyThread("Thread1", groupA);
		MyThread thread2 = new MyThread("Thread2", groupA);
		MyThread thread3 = new MyThread("Thread3", groupB);
		MyThread thread4 = new MyThread("Thread4", groupB);


		System.out.println("\nВывод из метода list();");
		groupA.list();
		groupB.list();
		System.out.println();

		Thread[] activeThreads = new Thread[groupA.activeCount()];
		groupA.enumerate(activeThreads);

		System.out.println("Останавливаю группу A");
		for (Thread thread : activeThreads) {
			((MyThread)thread).mySuspend();
		}

		try {
			System.out.println("Главный поток остановился");
			Thread.sleep(4000);
			System.out.println("Главный поток продолжил исполнение");
		} catch (InterruptedException e) {
			System.out.println("Главный поток исполнения прерван");
		}

		System.out.println("Возобновление группы А");
		for (Thread thread : activeThreads) {
			((MyThread)thread).myResume();
		}

		try {
			thread1.join();
			thread2.join();
			thread3.join();
			thread4.join();
		} catch (Exception e) {
			System.out.println("Ошибка при ожидании завершении потоков  исполнения");
		}
	}
}
