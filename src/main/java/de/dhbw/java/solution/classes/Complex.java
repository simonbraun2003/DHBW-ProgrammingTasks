package de.dhbw.java.solution.classes;

/**
 * @author DHBW lecturer
 * @version 1.0
 *
 * Part of lectures on 'Programming in Java'. Baden-Wuerttemberg
 * Cooperative State University.
 *
 * (C) 2015 by J. Sidler, T. Schlachter, C. Schmitt, W. Süß
 */
public class Complex {
    private double real = 0.0;
    private double imag = 0.0;
    public Complex() {
        this(0.0, 0.0);
    }
    public Complex(double real, double imag) {
        super();
        this.real = real;
        this.imag = imag;
    }
    public double getReal() {
        return real;
    }
    public double getImag() {
        return imag;
    }
    /** Complex addition
     * @param comp the complex number to add
     * @return a new complex as result of addition */
    public Complex add(Complex comp) {
        return new Complex(this.real+comp.real, this.imag+comp.imag);
    }
    /** Complex subtraction
     * @param comp the complex number to subtract
     * @return a new complex as result of subtraction */
    public Complex sub(Complex comp) {
        return new Complex(this.real-comp.real, this.imag-comp.imag);
    }
    /** Complex multiplication
     * @param comp the complex number to multiply
     * @return a new complex as result of multiplication */
    public Complex mult(Complex comp) {
        return new Complex(this.real*comp.real-this.imag*comp.imag,
                this.real*comp.imag+this.imag*comp.real);
    }
    /** Complex division
     * @param comp the complex number to divide
     * @return a new complex as result of division */
    public Complex div(Complex comp) {
        double denom = comp.real*comp.real + comp.imag*comp.imag;
        return new Complex((this.real*comp.real+this.imag*comp.imag)/denom,
                (this.imag*comp.real-this.real*comp.imag)/denom);
    }
    /** Complex as String */
    public String toString() {
        return "Complex " + real + " " + imag + "i";
    }
    /** Magnitude of a complex number */
    public double getMagnitude() {
        return Math.sqrt(real*real+imag*imag);
    }
    /** true if magnitude if comp is bigger */
    public boolean isLess(Complex comp) {
        return (this.getMagnitude()<comp.getMagnitude());
    }
    /** Sort an array of complex numbers with bubblesort */
    public static void sortComplexArray(Complex[] comps) {
        int n = comps.length;
        for(int i=1; i<n; i++)
            for(int j=n-1; j>=i; j--)
// falls x[j-1] größer als x[j]
                if (comps[j-1].getMagnitude() >
                        comps[j].getMagnitude()) {
                    Complex tmp = comps[j-1]; // swap
                    comps[j-1]=comps[j];
                    comps[j]=tmp;
                }
    }
    public static void main(String[] argv) {
        Complex c1 = new Complex(1.0,2.0);
        Complex c2 = new Complex(2.0,1.0);
        System.out.println("C1: " + c1);
        System.out.println("C2: " + c2);
        System.out.println("C1+C2: " + c1.add(c2));
        System.out.println("C1-C2: " + c1.sub(c2));
        System.out.println("C1*C2: " + c1.mult(c2));
        System.out.println("C1/C2: " + c1.div(c2));
        System.out.println("C1<C2?: " + c1.isLess(c2));
// create an array of 10 random complex numbers
        Complex[] comps = new Complex[10];
        for(int i=0; i<comps.length; i++)
            comps[i]=new Complex(Math.random()*10,Math.random()*10);
        System.out.println("Unsortiert:");
        for(Complex c : comps)
            System.out.printf("%5.3f + %5.3fi Betrag: %5.3f\n",
                    c.getReal(),c.getImag(),c.getMagnitude());
// sort array
        sortComplexArray(comps);
        System.out.println("Sortiert:");
        for(Complex c : comps)
            System.out.printf("%5.3f + %5.3fi Betrag: %5.3f\n",
                    c.getReal(),c.getImag(),c.getMagnitude());
    }
}
