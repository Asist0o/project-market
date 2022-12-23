package market.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import market.service.util.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@PropertySource("classpath:aws.properties")
public class StorageService {
    private static final Logger LOGGER = LogManager.getLogger(StorageService.class);

    @Value("${application.bucket.name}")
    private String bucketName;

    private final AmazonS3 s3Client;

    public StorageService(AmazonS3 s3Client) {
        this.s3Client = s3Client;
    }

    public void uploadFile(MultipartFile file) {
        String fileName = FileUtils.generateFileName(file);
        File fileObj = FileUtils.convertMultipartToFile(file);
        s3Client.putObject(new PutObjectRequest(bucketName, fileName, fileObj));
        fileObj.delete();
        LOGGER.info("file uploaded: {} ", fileName);
    }

    public void uploadFile(List<MultipartFile> files) {
        files.forEach(file ->
        {
            String fileName = FileUtils.generateFileName(file);
            File fileObj = FileUtils.convertMultipartToFile(file);
            s3Client.putObject(
                    new PutObjectRequest(bucketName, fileName, fileObj));
            fileObj.delete();
            LOGGER.info("file uploaded: {} ", fileName);
        });
        }

    public byte[] downloadFile(String fileName) {
        try {
            S3Object s3Object = s3Client.getObject(bucketName, fileName);
            S3ObjectInputStream inputStream = s3Object.getObjectContent();
            byte[] data = IOUtils.toByteArray(inputStream);
            LOGGER.info("download file {} done ", fileName);
            return data;
        } catch (IOException e) {
            LOGGER.error("Error download file {} ", fileName, e);
        }
        return null;
    }

    public void deleteFile(String fileName) {
        try {
            s3Client.deleteObject(bucketName, fileName);
            LOGGER.info("{} removed...", fileName);
        } catch (Exception e) {
            LOGGER.error("Error removed file {} ", fileName, e);
        }
    }
}
