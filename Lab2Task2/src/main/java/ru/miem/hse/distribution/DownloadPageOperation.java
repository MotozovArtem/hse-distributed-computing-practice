package ru.miem.hse.distribution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.miem.hse.distribution.util.HttpMethod;

public class DownloadPageOperation implements Runnable {

	private static final String USER_AGENT = "Mozilla/5.0";

	private Logger log;

	private URL targetUrl;

	private HttpMethod method;

	public DownloadPageOperation(URL targetUrl, HttpMethod method) {
		this.targetUrl = targetUrl;
		this.method = method;
		log = LoggerFactory.getLogger(String.format("DownloadPageOperation: [%s]", targetUrl.getHost()));
	}

	public DownloadPageOperation(String targetUrl, HttpMethod method) throws MalformedURLException {
		this(new URL(targetUrl), method);
	}

	public DownloadPageOperation(URL targetUrl) {
		this(targetUrl, HttpMethod.GET);
	}

	public DownloadPageOperation(String targetUrl) throws MalformedURLException {
		this(new URL(targetUrl), HttpMethod.GET);
	}

	@Override
	public void run() {
		try {
			HttpURLConnection con = (HttpURLConnection)targetUrl.openConnection();
			con.setRequestMethod(method.name());
			con.setRequestProperty("User-Agent", USER_AGENT);
			log.info("Send {} request to {}", method, targetUrl);
			int responseCode = con.getResponseCode();
			log.info("{} Response Code :: {}", method, responseCode);

			if (responseCode == HttpURLConnection.HTTP_OK) {
				StringBuilder response = new StringBuilder();
				try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
					String inputLine;
					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);
						response.append("\n");
					}
				}
				log.info("<<< Response <<<\n {}", response);
			} else {
				log.warn("Response code not 200 (OK)");
			}
		} catch (IOException e) {
			log.error("Error while downloading page", e);
		}
	}
}
