package org.nf.aoc.meta;

import org.nf.aoc.solution.Solution;

public class SolutionDescriptionResolver {

    public SolutionDescription resolve(Solution<?> solution) {
        var annotation = solution.getClass().getAnnotation(org.nf.aoc.meta.SolutionDescription.class);

        if (annotation == null) {
            throw new RuntimeException("Solution class missing @" + org.nf.aoc.meta.SolutionDescription.class.getName());
        }

        return new SolutionDescription(
            annotation.year(),
            annotation.day(),
            annotation.part(),
            annotation.description(),
            annotation.link(),
            annotation.tags()
        );
    }

    public record SolutionDescription(int year, int day, int part,
                               String description, String link, String[] tags) {

    }
}
