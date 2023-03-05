package org.example.Collections.LinkedListPracticals;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class LinkedListPracticals {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Nikunj");
        list.add("abc");
        list.add("Patel");

        list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        LinkedList<String> list1 = new LinkedList<>();
        list1.push("Nikunj");
        list1.push("Patel");

        list.stream();
//        list1.push("a");

        //System.out.println(list.containsAll(list1));

        //System.out.println(list.peek());
    }
}
