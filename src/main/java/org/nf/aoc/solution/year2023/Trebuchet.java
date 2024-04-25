package org.nf.aoc.solution.year2023;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.nf.aoc.solution.Solution;
import org.nf.aoc.util.FileUtils;

public class Trebuchet extends Solution<Integer> {

    public static void main(String[] args) {
        final List<String> list = FileUtils.readFile("/input/day1.txt");
        var name = "41vhnrz44";
//        var name = "fourhzgxqtxggfpprrmtfqsdhc2fdxnjdgx64oneight";

        var trebuchet = new Trebuchet();

        final int solve = trebuchet.solve(list.stream());
//        var solve = solve2(name);
        System.out.println(solve);
    }

    private final Map<String, String> digitMap = Map.of(
        "one", "o1e",
        "two", "t2o",
        "three", "t3e",
        "four", "f4r",
        "five", "f5e",
        "six", "s6x",
        "seven", "s7n",
        "eight", "e8t",
        "nine", "n9e"
    );

    public Integer solve(Stream<String> inputStream) {
        return inputStream
            .map(this::replaceWrittenDigits)
            .map(this::getAllDigits)
            .filter(s -> !s.isEmpty())
            .map(this::getFirstAndLastDigit)
            .mapToInt(Integer::parseInt)
            .sum();
    }

    private String replaceWrittenDigits(String input) {
        for (Map.Entry<String, String> entry : digitMap.entrySet()) {
            input = input.replaceAll(entry.getKey(), entry.getValue());
        }
        return input;
    }

    private String getAllDigits(String input) {
        return input.replaceAll("[a-z]", "");
    }

    private String getFirstAndLastDigit(String input) {
        return input.charAt(0) + "" + input.charAt(input.length() - 1);
    }
}
