package ru.miem.hse.distribution.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolUtils {
	private static final ExecutorService defaultThreadPool = Executors.newFixedThreadPool(2);

	public static ExecutorService defaultThreadPool() {
		return defaultThreadPool;
	}
}
