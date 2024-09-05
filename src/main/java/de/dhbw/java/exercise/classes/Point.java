package de.dhbw.java.exercise.classes;

public class Point {
    private double x;
    private double y;

    public Point() {
        this.x = 3;
        this.y = 3;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //Getter und Setter für Zugriff außerhalb der Klasse
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    //Methode Abstand des Punktes zum Ursprung
    public double distanceToStart() {
        return Math.sqrt(Math.pow(this.x - this.getX(), 2) + Math.pow(this.y - this.getY(), 2));
    }
    //Abstand zu anderem Punkt
    public double distanceToPoint(Point point) {
        return Math.sqrt(Math.pow(this.x - point.getX(), 2) + Math.pow(this.y - point.getY(), 2));
    }

    //Spiegelung an der x-Achse
    public void mirrorOnX(){
        this.x = -this.x;
    }
    public void mirrorOnY(){
        this.y = -this.y;
    }
    public Point mirrorOrigin(){
        return new Point(-this.x, -this.y);
    }

    //Informationen ausgeben
    public String toString() {
        return "Punkt (" + this.x + ", " + this.y + ")";
    }

    //test
    public static void main(String[] args) {
        Point pointA = new Point(4.0, 2.0);
        System.out.println("A: " + pointA);
        Point pointB = new Point(-1.0, -1.0);
        System.out.println("B: " + pointB);
        System.out.println("Abstand A-B: "
                + pointA.distanceToPoint(pointB));
        pointA = pointA.mirrorOrigin();
        System.out.println("A': " + pointA);
        System.out.println("Abstand A’-B: "
                + pointA.distanceToPoint(pointB));
    }
}
