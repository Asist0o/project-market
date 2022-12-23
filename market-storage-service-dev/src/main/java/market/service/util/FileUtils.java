package market.service.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;

public class FileUtils {

    private static final Logger LOGGER = LogManager.getLogger(FileUtils.class);

    public static File convertMultipartToFile(MultipartFile file) {
        File convertedFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
        try (FileOutputStream fileOutputStream = new FileOutputStream(convertedFile)) {
            fileOutputStream.write(file.getBytes());
        } catch (IOException e) {
            LOGGER.error("Error converting multipartFile to file", e);
        }
        return convertedFile;
    }

    public static String generateFileName(MultipartFile multipartFile) {
        return new Date().getTime() + "-" + Objects
                .requireNonNull(multipartFile.getOriginalFilename())
                .replaceAll(" ", "_");
    }
}
