package org.example.Collections.ArrayListPracticals;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ArrayListPractical {
    String a;
    void ArrayListPractical() {
        ArrayListPractical("a");
    }
    void ArrayListPractical(String a) {
        this.a = a;
    }
    public static void main(String[] args) {
        ArrayListPractical a = new ArrayListPractical();
        a.ArrayListPractical();
        System.out.println(a.a);
        List<Integer> list = new ArrayList<>();

        // to insert into list
        list.add(10);
        list.add(203);
        list.add(402);
        list.add(501);

        // to traverse
        // method 1
        System.out.println("Method 1");
        for (int item : list) {
            System.out.println(item);
        }

        // method 2
        System.out.println("Method 2");
        for (int index = 0; index < list.size(); index++) {
            System.out.println(list.get(index));
        }

        // method 3
        System.out.println("Method 3");
        list.forEach(item -> System.out.println(item));
        System.out.println();

        // method 4
        ListIterator<Integer> listIterator = list.listIterator();

        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

        System.out.println();

        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }

        System.out.println();

        listIterator = list.listIterator(3);
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
        // insert at position
        list.add(0, 10000);

        // to update list value
        list.set(2, 400);

        // remove at particular index
        System.out.println("Element removed at index 2 is = "+list.remove(2));

        // to replace value of all element
//        list.replaceAll(item -> 10);

        // sort
        list.sort( (n, i) -> {
            return n == i ? 0 : n > i ? 1 : -1;
        });

        // remove if
        list.removeIf(item -> item % 2 == 0);

        System.out.println(list);
    }
}
