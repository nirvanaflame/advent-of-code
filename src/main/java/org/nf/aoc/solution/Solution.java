package org.nf.aoc.solution;

import java.util.stream.Stream;

public interface Solution<T> {

    T solve(Stream<String> input);
}
