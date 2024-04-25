package org.nf.aoc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.nf.aoc.solution.year2023.day1.Trebuchet;

class TrebuchetTest {

    @Test
    void test1() {
        var res = new Trebuchet().solve(Stream.of("66"));
        assertEquals(res, 66);
    }

    @Test
    void test2() {
        var res = new Trebuchet().solve(Stream.of("6"));
        assertEquals(res, 66);
    }

    @Test
    void test3() {
        var res = new Trebuchet().solve(Stream.of("0"));
        assertEquals(res, 0);
    }

    @Test
    void test4() {
        var res = new Trebuchet().solve(Stream.of("six0"));
        assertEquals(res, 60);
    }

    @Test
    void test5() {
        var res = new Trebuchet().solve(Stream.of("1six"));
        assertEquals(res, 16);
    }

    @Test
    void test6() {
        var res = new Trebuchet().solve(Stream.of("1sixsix"));
        assertEquals(res, 16);
    }

    @Test
    void test7() {
        var res = new Trebuchet().solve(Stream.of("oneight"));
        assertEquals(res, 18);
    }
}