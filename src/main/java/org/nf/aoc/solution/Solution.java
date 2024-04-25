package org.nf.aoc.solution;

import java.util.stream.Stream;

public abstract class Solution<T> {

    public abstract T solve(Stream<String> input);
}
