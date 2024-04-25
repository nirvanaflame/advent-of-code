package org.nf.aoc.meta;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileUtils {

    public static Stream<String> streamFile(final String fileName) {
        try {
            final URL resource = FileUtils.class.getResource(fileName);
            return Files.lines(Paths.get(resource.toURI()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
