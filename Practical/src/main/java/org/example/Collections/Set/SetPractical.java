package org.example.Collections.Set;

import org.example.Model.CustomClass;

import java.util.*;


public class SetPractical {
    public static void main(String[] args) {

//        Set<CustomClass> set = new HashSet<>();
//        set.add(new CustomClass("Nikunj"));
//        set.add(new CustomClass("Nikunj"));

        Set<CustomClass> rawSet = new HashSet();
        rawSet.add(new CustomClass("Nikunj"));
        rawSet.add(new CustomClass("Patel"));
        rawSet.add(new CustomClass("Harsh"));

        Set clonedSet = (Set) ((HashSet<?>) rawSet).clone();

        Iterator<CustomClass> iterator = rawSet.iterator();

        while (iterator.hasNext()) {
            System.out.println(((CustomClass) iterator.next()).name += " a");
        }

        rawSet.forEach(item -> System.out.print(item + " , "));

        System.out.println(clonedSet);

        Set<Integer> set = new HashSet<>();

        Set<Integer> s1 = new HashSet<>();
        set.add(Integer.valueOf(10));
        set.add(Integer.valueOf(20));
        set.add(Integer.valueOf(40));
        //set.add(null);
        set.add(30);

        s1.add(Integer.valueOf(100));
        s1.add(Integer.valueOf(20));
        s1.add(Integer.valueOf(40));

        System.out.println("addAll: " + set.addAll(s1));

        System.out.println(set.contains(10));

        System.out.println(set.containsAll(s1));

//        Set<CustomClass> customClassSet1 = new HashSet<>();
//        customClassSet1.add(new CustomClass("Nikunj"));
//        customClassSet1.add(new CustomClass("Patel"));
//
//        Set<CustomClass> customClassSet2 = new HashSet<>();
//        customClassSet2.add(new CustomClass("Harsh"));
//        customClassSet2.add(new CustomClass("Kumar"));
//
//        customClassSet1.addAll(customClassSet2);
//
//        System.out.println("CustomClassSet1: "+customClassSet1);


//        System.out.println(set.retainAll(Arrays.asList((Object) null)));

//        set.removeAll(Arrays.asList((Object) null));

//        set.add(Set.of(10,20,40));
//        set.add(s1);
//        set.add(Set.of(11,20,40));
//        set.add(Set.of(10,20,40));

//        System.out.println(set);

    }
}

//class StringMutabilityWithMap {
//    static void stringLiteralMapping() {
//        String s1 = "A";
//        String s2 = "A";
//        HashMap<String, String> hashMap = new HashMap<>();
//        hashMap.put(s1, "One");
//        hashMap.put(s2, "Two");
//        s1 = "B";
//        System.out.println(hashMap);
//        hashMap.put(s1, "Three");
//        System.out.println(hashMap);
//    }
//
//    static void stringObjectMapping() {
//        String s1 = new String("A");
//        String s2 = new String("A");
//        HashMap<String, String> hashMap = new HashMap<>();
//        hashMap.put(s1, "One");
//        hashMap.put(s2, "Two");
//        s1 = new String("B");
//        System.out.println(hashMap);
//        hashMap.put(s1, "Three");
//        System.out.println(hashMap);
//    }
//
//    static void stringBufferMapping() {
//        StringBuffer s1 = new StringBuffer("A");
//        StringBuffer abc = s1;
//        StringBuffer s2 = new StringBuffer("A");
//        HashMap<StringBuffer, String> hashMap = new HashMap<>();
//        hashMap.put(s2, "Two");
//        hashMap.put(s1, "one");
//        s1 = new StringBuffer("B");
//        System.out.println(hashMap);
//        hashMap.put(s1, "Three");
//        System.out.println(hashMap);
//        System.out.println(hashMap.get(abc));
//    }
//
//    static void stringBuilderMapping() {
//        StringBuilder s1 = new StringBuilder("A");
//        StringBuilder s2 = new StringBuilder("A");
//        HashMap<StringBuilder, String> hashMap = new HashMap<>();
//        hashMap.put(s1, "One");
//        hashMap.put(s2, "Two");
//        s1 = new StringBuilder("B");
//        System.out.println(hashMap);
//        hashMap.put(s1, "Three");
//        System.out.println(hashMap);
//    }
//
//    public static void main(String[] args) {
//        //        stringLiteralMapping();
//        //        System.out.println("==========================");
//        //        stringObjectMapping();
//        //        System.out.println("==========================");
//                stringBufferMapping();
//        //        System.out.println("==========================");//
////                stringBuilderMapping();
//    }
//}
