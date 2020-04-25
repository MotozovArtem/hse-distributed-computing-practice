package ru.hse.miem.distributed;

public class MyThread  extends Thread{

	boolean suspendFlag;

	MyThread(String threadName, ThreadGroup tgOb) {
		super(tgOb, threadName);
		System.out.println("Новый поток: " + this);
		suspendFlag = false;
		start();
	}

	@Override
	public void run() {
		try {
			for (int i = 5; i >  0; i--) {
				System.out.println(getName() + ":" + i);
				Thread.sleep(1000);
				synchronized (this) {
					while (suspendFlag)  {
						wait();
					}
				}
			}
		}catch (Exception e) {
			System.out.println("Исключение в ");
		}
		System.out.println(getName() + " завершается");
	}

	public synchronized void mySuspend() {
		suspendFlag = true;
	}

	public synchronized void myResume() {
		suspendFlag = false;
		notify();
	}
}
