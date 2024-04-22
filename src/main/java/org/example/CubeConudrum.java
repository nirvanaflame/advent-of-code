package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;

public class CubeConudrum {

    public static void main(String[] args) {

        final Stream<String> lines = FileUtils.streamFile("/day2.txt");

        int result = lines.filter(CubeConudrum::isPossible)
            .map(row -> row.split(":")[0])
            .map(row -> row.split(" ")[1])
            .map(Integer::parseInt)
            .reduce(0, Integer::sum);

        System.out.println(result);
    }

    private static boolean isPossible(final String line) {
        final int headerIndex = line.indexOf(":");
        final String row = line.substring(headerIndex + 1).trim();
        System.out.println(row);
        final String[] sets = Arrays.stream(row.split("; "))
//            .peek(System.out::println)
            .toArray(String[]::new);

        for (var set : sets) {
            var mem = new HashMap<String, Integer>();

            for (var x : set.split(", ")) {
                var valKey = x.split(" ");
                var merge = mem.merge(valKey[1], Integer.valueOf(valKey[0]), Integer::sum);
                System.out.println("merge " + valKey[1] + " -> " + merge);
            }

            if (mem.getOrDefault("red", 0) > 12 ||
                mem.getOrDefault("green", 0) > 13 ||
                mem.getOrDefault("blue", 0) > 14
            ) {
                return false;
            }
        }

        return true;
    }

}
