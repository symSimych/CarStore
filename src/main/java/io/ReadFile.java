package io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import java.util.stream.Stream;

public class ReadFile {

    private static ReadFile instance;

    private static final Logger logger = LoggerFactory.getLogger(ReadFile.class);

    private ReadFile(){
    }

    public static synchronized ReadFile getInstance() {
        if (Objects.isNull(instance)) {
            instance = new ReadFile();
        }
        return instance;
    }

    public List<String> readFileSource(URI fileName) {
        List<String> fileSource = new ArrayList<>();
        fileSource = readFile(Paths.get(fileName), fileSource);
        return fileSource;
    }

    public List<String> readFileFromResources(String fileName) {
        URI path = null;
        try {
            path = Objects.requireNonNull(
                    ReadFile.class.getClassLoader()
                            .getResource(fileName)).toURI();
        } catch (URISyntaxException e) {
            logger.error("Read file error");
        }
        List<String> fileSource = new ArrayList<>();
        assert path != null;
        fileSource = readFile(Paths.get(path).toAbsolutePath(), fileSource);
        return fileSource;
    }

    private List<String> readFile(Path filePath, List<String> fileSource) {
        try (Stream<String> stringStream = Files.lines(filePath)){
            fileSource = stringStream.toList();
        }
        catch (IOException e) {
            logger.error("Read file error");
        }
        return fileSource;
    }
}

