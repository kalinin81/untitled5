package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        onlyUnique();
        thirdMax();
        thirdMaxUnique();
        oldestEngineer();
        averageAgeEngineer();
        longestWord();
        frequencyWord();
        orderByLengthAndAlphabet();
        longestWord2();
    }

    private static void longestWord2() {
        List<String> e1 = List.of("ffff", "eeeeee", "mm", "qqqqqqqqqqqq");
        List<String> e2 = List.of("ff", "e", "mmm", "qqqqqqqqqqqq");
        List<String> e3 = List.of("ff", "e", "mmmmm", "qqqqqqqqqqqq");
        System.out.println(
                List.of(e1, e2, e3).stream()
                        .flatMap(strings -> strings.stream())
                        .reduce((s, s2) -> {
                            if (s.length() <= s2.length()) {
                                return s2;
                            } else {
                                return s;
                            }
                        }).get()
        );
    }

    private static void orderByLengthAndAlphabet() {
        System.out.println(
                List.of("str1000", "str10", "str100", "stp100", "str1").stream()
                        .sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()))
                        .collect(Collectors.toList())
        );
    }

    private static void frequencyWord() {
        System.out.println(
                Arrays.stream("slovo1 slovo2 slovo3 slovo2 slovo3 slovo3".split(" "))
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        );
    }

    private static void longestWord() {
        System.out.println(
                List.of("ffff", "eeeeee", "mm", "qqqqqqqqqqqq").stream()
                        .reduce((s, s2) -> {
                            if (s.length() <= s2.length()) {
                                return s2;
                            } else {
                                return s;
                            }
                        }).get()

        );
    }

    private static void averageAgeEngineer() {
        System.out.println(
                List.of(new Employee("name1", 30, Job.ENGINEER)
                                , new Employee("name2", 31, Job.ENGINEER)
                                , new Employee("name3", 32, Job.ENGINEER)
                                , new Employee("name4", 32, Job.ADMIN)
                                , new Employee("name5", 32, Job.MANAGER)
                        ).stream()
                        .filter(employee -> employee.getJob() == Job.ENGINEER)
                        .collect(Collectors.averagingDouble(Employee::getAge)));
    }

    private static void oldestEngineer() {
        System.out.println(
                List.of(new Employee("name1", 30, Job.ENGINEER)
                                , new Employee("name2", 31, Job.ENGINEER)
                                , new Employee("name3", 32, Job.ENGINEER)
                                , new Employee("name4", 32, Job.ADMIN)
                                , new Employee("name5", 32, Job.MANAGER)
                        ).stream()
                        .filter(employee -> employee.getJob() == Job.ENGINEER)
                        .max(Comparator.comparing(Employee::getAge))
                        .get().getName());
    }

    private static void thirdMaxUnique() {
        System.out.println(List.of(5, 2, 10, 9, 4, 3, 10, 1, 13).stream()
                .collect(Collectors.toSet()).stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .min(Integer::compareTo)
                .get());

    }

    private static void thirdMax() {
        System.out.println(List.of(5, 2, 10, 9, 4, 3, 10, 1, 13).stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .min(Integer::compareTo)
                .get());
    }

    private static void onlyUnique() {
        List.of(1, 1, 2, 2, 3, 3).stream().distinct();
    }
}