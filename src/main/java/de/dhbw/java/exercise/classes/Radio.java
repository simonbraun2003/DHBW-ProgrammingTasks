package de.dhbw.java.exercise.classes;

public class Radio {
    //Attribute des Objekts
    private boolean on;
    private int volume;
    private double frequency;

    //Standard Konstruktor
    public Radio() {
        this.on = true;
        this.volume = 4;
        this.frequency = 92.3;
    }

    //Überladener Konstruktor
    public Radio(boolean on, int volume, double frequency) {
        this.on = on;
        this.volume = volume;
        this.frequency = frequency;
    }

    //Methoden zum erhöhen/senken der Lautstärke
    public void incVolume() {
        if (volume + 1 <= 10){
            volume += 1;
        }
    }

    public void decVolume() {
        if (volume - 1 >= 0){
            volume -= 1;
        }
    }

    //Methoden zum Ein- und Ausschalten
    public void turnOn(){
        on = true;
    }
    public void turnOff(){
        on = false;
    }

    //Methode zum Einstellen der Frequenz
    public void setFrequency(double frequency) {
        if(frequency > 110.0 || frequency < 85.0 ){
            this.frequency = 99.9;
        }else {
            this.frequency = frequency;
        }
    }

    //Informationsausgabe
    public String toString(){
        return "Radio " + on + ": Freq=" + frequency + ", Laut=" + volume;
    }

    //Test
    public static void main(String[] args) {
        Radio radio = new Radio(false, 7, 93.5);
        System.out.println(radio);
        radio.turnOn();
        System.out.println(radio);
        radio.incVolume(); radio.incVolume();
        System.out.println(radio);
        radio.incVolume();
        radio.incVolume();
        System.out.println(radio);
        radio.decVolume();
        System.out.println(radio);
        radio.setFrequency(97.8);
        System.out.println(radio);
        radio.setFrequency(112.7);
        System.out.println(radio);
        radio.turnOff();
        System.out.println(radio);
    }
}
