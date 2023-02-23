package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

class Parent {
    public static final int a = 10;
    public static final void method() {
        System.out.println("we are inside parent");
    }
}
class Child extends Parent {

}

interface A {
    public void method();
}

interface B {
    public int method();
}
public class Main{
    public void method(Character...a) {
        System.out.println(a.length);
    }
    public void method(char a) {
        System.out.println(a);
    }

    public static void main(String[] args)throws CloneNotSupportedException {

        Main m = new Main();
        m.method('a');

//        Main m = new Main();
//        Main m1 = (Main) m.clone();

        Child c = new Child();
        c.method();
        System.out.println(c.a);

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));

        Iterator iterator = list.iterator();

        while (iterator.hasNext()) {
            Integer val = (Integer) iterator.next();
//            System.out.println(val);
            if (val.equals(5)) {
                System.out.println(val);
                list.remove(5);
            }
        }

        System.out.println(list);
    }
}