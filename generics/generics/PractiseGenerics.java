package generics;

import java.util.ArrayList;
import java.util.List;

public class PractiseGenerics {

    public static void main(String[] args) {
        PractiseGenerics pg = new PractiseGenerics();
        pg.go();

    }

    void go() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(0);
        addExtra(list);
        addExtraInt(list);
        addSuper(list);
        System.out.println(list.toString());
        System.out.println(list.get(2)); //hmmm - does not throw any exceptions....
    }

    // both will compile and run, produce warning!
    // if changed List to List<Integer> it would not compile
    void addExtra(List l) {
        l.add("tralalalaa");
        l.add(1);
    }

    void addExtraInt(List<Integer> l) {
        l.add(new Integer(2));
    }

    void addExtend(List<? extends Number> l) {
//        l.add(new Integer(5));
    }

    void addSuper(List<? super Integer> l) {
        l.add(new Integer(5));
    }

}
