package ianmorgan.github.io;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BasicStreams {

    public static void simpleFilter() {
        List<String> names = Arrays.asList("John", "Paul", "Ringo", "George");

        List<String> shortNames = names.stream()
                .filter(it -> it.length() == 4)
                .collect(Collectors.toList());

        System.out.println(shortNames.stream().collect(Collectors.joining(",")));
    }


    public static void simpleReducer() {
        List<String> names = Arrays.asList("John", "Paul", "Ringo", "George");

        int totalChars = names.stream()
                .map(it -> it.length())
                .reduce(0, (Integer a, Integer b) -> a + b);

        System.out.println("Total chars is " + totalChars);

    }

    public static void simpleReducerWithFunctions() {
        List<String> names = Arrays.asList("John", "Paul", "Ringo", "George");

        int totalChars = names.stream()
                .map(BasicStreams::length)
                .reduce(0, BasicStreams::add);

        System.out.println("Total chars is " + totalChars);
    }


    public static void reducerWithConsumer() {
        List<String> names = Arrays.asList("John", "Paul", "Ringo", "George");

        Averager averageChars = names.stream()
                .map(it -> (int)it.length())
                .collect(Averager::new, Averager::accept, Averager::combine);
        System.out.println("Total chars is " + averageChars.average());

    }

    private static Integer length(String s) {
        return s.length();
    }

    private static Integer add(Integer a, Integer b) {
        return a + b;
    }


}
