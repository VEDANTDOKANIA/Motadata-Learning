package org.example.Collections.StreamPracticals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamPracticals {
    public static void main(String[] args) {
        var list = Arrays.asList(10,20, 30, 40, 50, 60, 70, 80);

        list.stream()
                .filter(item -> item % 2 == 0)
                .forEach(item -> System.out.print(item+" "));

        System.out.println();

        list.stream()
                .map(item -> item + 10)
                .forEach(item -> System.out.print(item+" "));

        System.out.println();

        var list1 = Arrays.asList(1, 2);
        var list2 = Arrays.asList(3, 4);
        var list3 = Arrays.asList(5, 6);

        var allList = Arrays.asList(list1, list2, list3);

        var resultantList = allList.stream().flatMap(n -> n.stream()).collect(Collectors.toList());
        System.out.println(resultantList);

        allList.stream()
                .flatMap(item -> item.stream()
                        .filter(n -> n % 2 == 0)
                        .map(n -> n * 10))
                .forEach(item -> System.out.print(item+" "));

        System.out.println();

        list = Arrays.asList(10, 20, 30, 10, 10, 30, 20, 40);
        list.stream().distinct().forEach(item -> System.out.print(item+" "));

        long count = list.stream().count();
        System.out.println("Size: "+count);

        list.stream().distinct().limit(1).forEach(item -> System.out.print(item+" "));

        System.out.println();

        Optional<Integer> minValue = list.stream()
                .min((num1, num2) -> num1.compareTo(num2));

        Optional<Integer> maxValue = list.stream()
                .max(Integer::compareTo);

        System.out.println("Min: "+minValue+" | Max: "+maxValue);

        Optional<Integer> sum = list.stream().reduce((num1, num2) -> num1 + num2);
        System.out.println("Sum: "+sum);

        list.stream()
                .sorted()
                .forEach(item -> System.out.print(item+" "));

        System.out.println();

        list.stream()
                .sorted(Collections.reverseOrder())
                .forEach(item -> System.out.print(item+" "));

        System.out.println();

        //any match - if any one matches with given condition then return true.

        List<String> fruitsList = Arrays.asList("OneApple", "OneMango", "TwoApple", "ThreeGuavas");
        boolean res = fruitsList.stream().anyMatch(value -> {
            return value.startsWith("One");
        });

        System.out.println("anyMatch: "+res);

        //all match - if all matches with given condition then return true.

        boolean res1 = fruitsList.stream().allMatch(value -> {
            return value.startsWith("One");
        });

        System.out.println("allMatch: "+res1);

        // none match - if no one matches with given condition then return true
        boolean res2 = fruitsList.stream().noneMatch(value -> {
            return value.startsWith("Four");
        });

        System.out.println("noneMatch: "+res2);
    }
}
