package org.nf.aoc;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.nf.aoc.meta.FileUtils;
import org.nf.aoc.meta.SolutionDescriptionResolver;
import org.nf.aoc.solution.Solution;
import org.nf.aoc.solution.year2023.day2.Part2;

public class Application {

    public static void main(String[] args) {

        var resolver = new SolutionDescriptionResolver();

        var appClassLoader = Application.class.getClassLoader();
        var packageName = Solution.class.getPackageName().replaceAll("[.]", "/");
        var definedPackage = appClassLoader.getResourceAsStream(packageName);

        var packageName2 = Solution.class.getPackageName() ;
//        Arrays.stream(Package.getPackages())
//            .filter(p -> p.getName().startsWith(packageName2))
//            .map(p -> {
//                var pName = p.getName().replaceAll("[.]", "/");
//                var resourceAsStream = appClassLoader.getResourceAsStream(pName);
//                listClasses(resourceAsStream);
//                return p.getName();
//            })
//            .toList();


        var allClassesUsingClassLoader = findAllClassesUsingClassLoader(packageName2);
        var packageName1 = Part2.class.getPackageName();

        var allClassesUsingClassLoader1 = findAllClassesUsingClassLoader(packageName1);

        listClasses(definedPackage);

        for (final Class<?> aClass : Solution.class.getDeclaredClasses()) {
            Solution solution;
            try {
                solution = (Solution) aClass.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                System.out.println("Something went wrong" + Thread.currentThread().getName());
                throw new RuntimeException(e);
            }

            var solutionDescription = resolver.resolve(solution);

            var file = STR."/input/\{solutionDescription.year()}/\{solutionDescription.day()}/input.txt";
            var input = FileUtils.streamFile(file);
            var result = solution.solve(input);
            System.out.println(result);
        }
    }

    private static void listClasses(final InputStream definedPackage) {
        var bufferedReader = new BufferedReader(new InputStreamReader(definedPackage));
        var lines = bufferedReader.lines();
        var list = lines.toList();
        System.out.println(list);
    }

    public static Set<Class> findAllClassesUsingClassLoader(String packageName) {
        InputStream stream = ClassLoader.getSystemClassLoader()
            .getResourceAsStream(packageName.replaceAll("[.]", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines()
            .filter(line -> line.endsWith(".class"))
            .map(line -> getClass(line, packageName))
            .collect(Collectors.toSet());
    }

    private static Class getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "."
                + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            // handle the exception
        }
        return null;
    }
}