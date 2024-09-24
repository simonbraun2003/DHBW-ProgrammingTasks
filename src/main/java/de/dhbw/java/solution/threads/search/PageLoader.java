package de.dhbw.java.solution.threads.search;

/**
 * Part of lectures on 'Programming in Java'. Baden-Wuerttemberg
 * Cooperative State University.
 *
 * (C) 2016-2018 by W. Geiger, T. Schlachter, C. Schmitt, W. Suess
 *
 * @author DHBW lecturer
 * @version 1.1
 */
public class PageLoader implements Runnable {
    private final static String ENCODING = "UTF-8"; // e.g. "ISO-8859-1", "UTF-8"
    public String url;
    private String content;
    public PageLoader( String url ) {
        this.url = url;
        this.content = null;
    }
    /**
     * Check if page was loaded
     *
     * @return <code>true</code> if content has been loaded (is not
     * <code>null</code>), <code>false</code> otherwise
     */
    public boolean pageLoaded() {
        return this.content != null;
    }
    /**
     * Get the page content, but first test if there is any with
     * {@link #pageLoaded()}
     *
     * @return page content in a single line or <code>null</code> if page was no
     * {@link #pageLoaded() loaded}
     */
    public String getPageContent() {
        return this.content != null
                ? this.content.replaceAll( "(\\r|\\n)+", "##" ) : null;
    }
    @Override
    public void run() {
        this.content =
                ReadURLExample.getStringContentFromUrl( this.url, PageLoader.ENCODING );
    }
}
