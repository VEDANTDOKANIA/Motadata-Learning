package org.example.Collections.ArrayListPracticals;

import java.io.Serializable;
import java.util.*;
import org.example.Collections.Set.*;
import org.example.Model.CustomClass;

public class ArrayListPractical {

    public static void main(String[] args) {

        ArrayList<CustomClass> customClassArrayList1 = new ArrayList<>();
        customClassArrayList1.add(new CustomClass("Nikunj"));
        customClassArrayList1.add(new CustomClass("Patel"));

        ArrayList<CustomClass> customClassArrayList2 = new ArrayList<>();
        customClassArrayList2.add(new CustomClass("Harsh"));
        customClassArrayList2.add(new CustomClass("kumar"));

        customClassArrayList1.addAll(customClassArrayList2);

        System.out.println(customClassArrayList1);

        customClassArrayList2.get(1).name = "KKumar";

        System.out.println(customClassArrayList1);

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
        System.out.println("Element removed at index 2 is = " + list.remove(2));

        // to replace value of all element
//        list.replaceAll(item -> 10);

        // sort
        list.sort((n, i) -> {
            return n == i ? 0 : n > i ? 1 : -1;
        });

        // remove if
        list.removeIf(item -> item % 2 == 0);

        List<Integer> list2 = (List<Integer>) ((ArrayList<Integer>) list).clone();

        System.out.println(list.get(0).hashCode());
        System.out.println(list2.get(0).hashCode());

        list2.set(0, 1);
        System.out.println(list2);
        System.out.println(list);

        System.out.println(list.get(0).hashCode());
        System.out.println(list2.get(0).hashCode());


    }
}


class MyNameIsKhan {
    private final String first, last;

    MyNameIsKhan(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (!(o instanceof MyNameIsKhan))
            return false;
        MyNameIsKhan n = (MyNameIsKhan) o;
        System.out.println("we are inside equals");
        return n.first.equals(first) || n.last.equals(last);
    }

    public static void main(String[] args) {
        Set<MyNameIsKhan> s = new HashSet<MyNameIsKhan>();
        s.add(new MyNameIsKhan("Shahrukh", "Khan"));
        System.out.println(s.contains(new MyNameIsKhan("Shahrukh", "Khan")));
    }
}
