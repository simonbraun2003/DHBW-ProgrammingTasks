package de.dhbw.java.solution.threads.search;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * Part of lectures on 'Programming in Java'. Baden-Wuerttemberg Cooperative
 * State University.
 *
 * (C) 2016-2019 by W. Geiger, T. Schlachter, C. Schmitt, W. Suess
 *
 * @author DHBW lecturer
 * @version 1.2
 */
public class SearchEngine {
    public static final int MAXTHREADS = 3;
    private List<PageLoader> pageLoader = new ArrayList<>();
    public void crawl(String... urls) {
        ExecutorService exec = Executors.newFixedThreadPool(MAXTHREADS);
        for (String url : urls) {
            PageLoader pl = new PageLoader(url);
            this.pageLoader.add(pl);
            exec.submit(pl);
            System.out.println("Gestartet: " + url);
        }
// Keine weiteren Threads mehr zulassen
        exec.shutdown();
        while (!pageLoader.isEmpty()) {
            for (PageLoader pl : pageLoader) {
                if (pl.pageLoaded()) {
                    System.out.println("Loaded: " + pl.url);
                    System.out.println(" Content: " +
                            pl.getPageContent().substring(0, 40));
                    this.pageLoader.remove(pl);
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {
        new SearchEngine().crawl("https://www.tagesschau.de",
                "https://www.sueddeutsche.de",
                "https://www.spiegel.de",
                "https://www.kit.edu");
    }
}
