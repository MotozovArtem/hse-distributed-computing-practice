package ru.miem.hse.distribution;


import java.net.MalformedURLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.miem.hse.distribution.util.HttpMethod;

public class Main {
	private static final Logger log = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) throws MalformedURLException {
		log.info("Application stated");
		log.info("Creating first download thread");
		Thread firstDownloadThread = new Thread(new DownloadPageOperation("https://en.wikipedia.org/wiki/C%2B%2B", HttpMethod.GET));

		log.info("Creating second download thread");
		Thread secondDownloadThread = new Thread(new DownloadPageOperation("https://en.wikipedia.org/wiki/Java_(programming_language)", HttpMethod.GET));

		log.info("Starting first download thread");
		firstDownloadThread.start();

		log.info("Starting second download thread");
		secondDownloadThread.start();

		try {
			log.error("Joining first download thread");
			firstDownloadThread.join();
		} catch (InterruptedException e) {
			log.error("Joining first download thread failed", e);
		}
		try {
			log.error("Joining second download thread");
			secondDownloadThread.join();
		} catch (InterruptedException e) {
			log.error("Joining second download thread failed", e);
		}
		log.info("Application stopped");
	}
}
