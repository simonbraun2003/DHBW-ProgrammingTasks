package de.dhbw.java.solution.threads.buffer;

import java.util.Random;
/**
 * Part of lectures on 'Programming in Java'. Baden-Wuerttemberg
 * Cooperative State University.
 *
 * (C) 2016-2018 by W. Geiger, T. Schlachter, C. Schmitt, W. Suess
 *
 * @author DHBW lecturer
 * @version 1.1
 */
public class BufferDemo {
    private static final int TESTDATASIZE = 7;
    private static final int MAXDELAY = 500;
    private static final Random RND = new Random();
    /**
     * Inner class for Producer-Thread
     */
    static class ProducerThread implements Runnable {
        private MyBuffer buffer;
        public ProducerThread( MyBuffer b ) {
            this.buffer = b;
        }
        @Override
        public void run() {
            for ( int i = 0; i < BufferDemo.TESTDATASIZE; i++ ) {
                this.buffer.put( i );
// simulate data calculation time by random waiting
                try {
                    Thread.sleep( BufferDemo.RND.nextInt( BufferDemo.MAXDELAY ) );
                } catch ( InterruptedException ex ) {
                }
            }
        }
    }
    /**
     * Inner class for Consumer-Thread
     */
    static class ConsumerThread implements Runnable {
        private MyBuffer buffer;
        public ConsumerThread( MyBuffer b ) {
            this.buffer = b;
        }
        @Override
        public void run() {
            for ( int i = 0; i < BufferDemo.TESTDATASIZE; i++ ) {
                this.buffer.get();
// Simulate data processing time by random waiting
                try {
                    Thread.sleep( BufferDemo.RND.nextInt( BufferDemo.MAXDELAY ) );
                } catch ( InterruptedException ex ) {
                }
            }
        }
    }
    public static void main( String args[] ) {
        MyBuffer buf = new MyBuffer();
// Create one producer and one consumer
        new Thread( new ProducerThread( buf ) ).start();
        new Thread( new ConsumerThread( buf ) ).start();
    }
}
