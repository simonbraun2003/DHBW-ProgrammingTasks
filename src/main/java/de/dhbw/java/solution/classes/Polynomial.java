package de.dhbw.java.solution.classes;

/**
 * @author DHBW lecturer
 * @version 1.0
 *
 * Part of lectures on 'Programming in Java'.
 * Baden-Wuerttemberg Cooperative State University.
 *
 * (C) 2015 by J. Sidler, T. Schlachter, C. Schmitt, W. Süß
 */
public class Polynomial {
    /* polynomial 2nd degree like ax^2 + bx + c */
    double a, b, c;
    public Polynomial() {
        this(0.0, 0.0, 0.0);
    }
    public Polynomial(double a, double b, double c) {
        super();
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double f(double x) {
        return a*x*x + b*x + c;
    }
    public Polynomial sub(Polynomial p) {
        return new Polynomial(a-p.a,b-p.b,c-p.c);
    }
    public Polynomial add(Polynomial p) {
        return new Polynomial(a+p.a,b+p.b,c+p.c);
    }
    public Polynomial scale(double factor) {
        return new Polynomial(factor*a,factor*b,factor*c);
    }
    /** get zeros using the 'midnight formula'
     /* x1/2 = ( -b +/- sqrt(b*b-4*a*c) ) / 2a */
    public double[] getZeros() {
        if (a == 0) {
            if (b == 0) { // no zeros
                return new double[0];
            } else { // 1 zero
                return new double[]{-c / b};
            }
        } else if (b * b < 4 * a * c) // no zeros
            return new double[0];
        else if (b*b==4*a*c) // 1 zero
            return new double[] { -b/(2*a) };
        else // 2 zeros
            return new double[] {
                    (-b+Math.sqrt(b*b-4*a*c))/(2*a),
                    (-b-Math.sqrt(b*b-4*a*c))/(2*a)
            };
    }
    @Override
    public String toString() {
        return a+"x^2 " + (b>=0 ? "+":"") + b+"x "
                + (c>=0 ? "+":"") + c;
    }
    public static void main(String[] args) {
        Polynomial pol1 = new Polynomial(2,0,0);
        System.out.println("P1: " + pol1);
        Polynomial pol2 = new Polynomial(0,-4,1);
        System.out.println("P2: " + pol2);
        Polynomial pol3 = pol1.add(pol2);
        System.out.println("P3 = P1 + P2: " + pol3);
        pol3 = pol3.scale(2.0);
        System.out.println("P3 = 2.0 * P3: " + pol3);
        double[] zeros = pol3.getZeros();
        System.out.println("Nullstellen von P3 (" + pol3 + "): ");
        for(double zero : zeros)
            System.out.print(zero + " ");
    }
}