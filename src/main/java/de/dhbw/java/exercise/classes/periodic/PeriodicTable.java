package de.dhbw.java.exercise.classes.periodic;

public class PeriodicTable {
    private Element[] elemente = new Element[119];

    public void addElement(Element element) {
        if(!hasElement(element.getOrdinal())){
            elemente[element.getOrdinal()] = element;
        }
    }

    public boolean hasElement(int o){
        return elemente[o] != null;
    }

    public Element getElement(int o){
        return elemente[o];
    }

    public Element[] getMetals(){
        int countMetals = 0;
        for (Element e : elemente) {
            if ( e != null && e instanceof Metal) countMetals++;
        }
        Element[] metals = new Element[countMetals];
        int pos = 0;
        for (Element e : elemente) {
            if(e != null && e instanceof Metal) metals[pos++] = e;
        }
        return metals;
    }

    public static void main(String[] args) {
        PeriodicTable pt = new PeriodicTable();
        pt.addElement(new Element("Wasserstoff", "H", 1, 'K', Element.GAS, Element.MAIN));
        pt.addElement(new Element("Helium", "He", 2, 'K', Element.GAS, Element.MAIN));
        pt.addElement(new Metal("Natrium", "Na", 11, 'M', Element.SOLID, Element.MAIN,
                false, 21E6));

        System.out.println("Elemente:");
        for(Element e : pt.elemente)
            if(e != null) System.out.println(e);

        System.out.println("Metalle:");
        for(Element e : pt.getMetals())
            System.out.println(e);
    }
}
