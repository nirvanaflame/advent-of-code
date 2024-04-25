package org.nf.aoc;

import org.nf.aoc.solution.year2023.CubeConudrum;
import org.nf.aoc.solution.year2023.Trebuchet;
import org.nf.aoc.util.FileUtils;

public class Main {

    public static void main(String[] args) {
        var trebuchet = new Trebuchet();
        var day1 = trebuchet.solve(FileUtils.streamFile("/input/day1"));

        var cubeConudrum = new CubeConudrum();
        var day2 = cubeConudrum.solve(FileUtils.streamFile("/input/day2"));

        System.out.println("Hello world!");
    }
}