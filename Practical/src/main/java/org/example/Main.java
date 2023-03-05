package org.example;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

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

    static void fun() {
        fun();
    }

    public static void main(String[] args) {

//        ArrayList<Integer> list = new ArrayList<>();
//
//        try {
//            while (true) {
//                for (int i = 0; i < 100000;i++) {
//                    list.add(i);
//                }
//                try {
//                    Thread.sleep(100);
//                } catch (Exception e) {
//                    System.out.println("Exception: "+e);
//                }
//                for (int i = 0; i < 100000;i++) {
//                    list.add(i);
//                }
//                for (int i = 0; i < 100000;i++) {
//                    list.add(i);
//                }
//                for (int i = 0; i < 100000;i++) {
//                    list.add(i);
//                }
//                for (int i = 0; i < 100000;i++) {
//                    list.add(i);
//                }for (int i = 0; i < 100000;i++) {
//                    list.add(i);
//                }
//                for (int i = 0; i < 100000;i++) {
//                    list.add(i);
//                }for (int i = 0; i < 100000;i++) {
//                    list.add(i);
//                }
//                for (int i = 0; i < 100000;i++) {
//                    list.add(i);
//                }
//            }
//        } catch (Throwable t) {
//            System.out.println(t);
//        }



//        Main m = new Main();
//        Main m1 = (Main) m.clone();



//        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));

//        try {
//            throw new OutOfMemoryError();
//        } catch (OutOfMemoryError s) {
//            System.out.println("Exception: "+s);
//        }

//        Iterator iterator = list.iterator();
//
//        while (iterator.hasNext()) {
//            Integer val = (Integer) iterator.next();
////            System.out.println(val);
//            if (val.equals(5)) {
//                System.out.println(val);
//                list.remove(5);
//            }
//        }
//
//        System.out.println(list);

        ArrayList obj1 = new ArrayList();
        ArrayList obj2 = new ArrayList();
        obj1.add("A");
        obj1.add("B");
        obj2.add("A");
        obj2.add("B");

        System.out.println(obj1.equals(obj2));
    }
}