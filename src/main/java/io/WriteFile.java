package io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class WriteFile<T> {

    private static final Logger logger = LoggerFactory.getLogger(WriteFile.class);

    public WriteFile() {
    }

    public void writeDataToFile(T object, String fileName){
        try {
            Path path = Paths.get(fileName).toAbsolutePath();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Files.write(path, gson.toJson(object).getBytes() );
//            ObjectMapper mapper = new ObjectMapper();
//            mapper.writeValue(new File(path), object);
        } catch (IOException e) {
            logger.error("Write file error");
        }
    }
}
