package ru.hse.miem.distributed;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {

	public static void main(String[] args) throws MalformedURLException {
		String urlStringRepr = "https://en.wikipedia.org:443/wiki/Java_(programming_language)";
		URL url = new URL(urlStringRepr);
		System.out.printf("URL: %s\n", url);
		System.out.printf("Protocol: %s\n", url.getProtocol());
		System.out.printf("File name: %s\n", url.getFile());
		System.out.printf("Host: %s\n", url.getHost());
		System.out.printf("Path: %s\n", url.getPath());
		System.out.printf("Port: %s\n", url.getPort());
	}

}
