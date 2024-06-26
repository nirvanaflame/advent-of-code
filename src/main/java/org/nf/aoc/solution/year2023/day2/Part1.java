package org.nf.aoc.solution.year2023.day2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;

import org.nf.aoc.meta.SolutionDescription;
import org.nf.aoc.solution.Solution;

@SolutionDescription(year = 2023, day = 2, part = 1,
    description = "--- Day 2: Cube Conundrum ---",
    link = "https://adventofcode.com/2023/day/2",
    tags = { "#string_manipulation", "#memoization" }
)
public class Part1 implements Solution<Integer> {

    @Override
    public Integer solve(final Stream<String> input) {
        return input.filter(Part1::isPossible)
            .map(row -> row.split(":")[0])
            .map(row -> row.split(" ")[1])
            .map(Integer::parseInt)
            .reduce(0, Integer::sum);
    }

    private static boolean isPossible(final String line) {
        final int headerIndex = line.indexOf(":");
        final String row = line.substring(headerIndex + 1).trim();

        final String[] sets = Arrays.stream(row.split("; "))
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
