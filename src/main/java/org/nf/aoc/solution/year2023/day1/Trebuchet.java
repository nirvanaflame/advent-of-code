package org.nf.aoc.solution.year2023.day1;

import java.util.Map;
import java.util.stream.Stream;

import org.nf.aoc.meta.SolutionDescription;
import org.nf.aoc.solution.Solution;

@SolutionDescription(year = 2023, day = 1, part = 2,
    description = "--- Day 1: Trebuchet?! ---",
    link = "https://adventofcode.com/2023/day/1",
    tags = { "#string_manipulation" }
)
public class Trebuchet implements Solution<Integer> {

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

    public Integer solve(Stream<String> input) {
        return input
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
