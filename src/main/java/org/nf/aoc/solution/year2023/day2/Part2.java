package org.nf.aoc.solution.year2023.day2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;

import org.nf.aoc.meta.SolutionDescription;
import org.nf.aoc.solution.Solution;

@SolutionDescription(year = 2023, day = 2, part = 2,
    description = "--- Day 2: Cube Conundrum ---",
    link = "https://adventofcode.com/2023/day/2",
    tags = { "#string_manipulation", "#memoization" }
)
public class Part2 implements Solution<Integer> {

    @Override
    public Integer solve(final Stream<String> input) {
        return input.mapToInt(Part2::product)
            .sum();
    }

    private static int product(final String line) {
        final int headerIndex = line.indexOf(":");
        final String row = line.substring(headerIndex + 1).trim();

        final String[] sets = Arrays.stream(row.split("; "))
            .toArray(String[]::new);

        var mem = new HashMap<String, Integer>();
        for (var set : sets) {

            for (var x : set.split(", ")) {
                var valKey = x.split(" ");

                var val = Integer.parseInt(valKey[0]);
                var saved = mem.getOrDefault(valKey[1], 0);

                mem.put(valKey[1], Math.max(val, saved));
            }
        }

        return mem.getOrDefault("blue", 1) *
            mem.getOrDefault("red", 1) *
            mem.getOrDefault("green", 1);
    }
}
