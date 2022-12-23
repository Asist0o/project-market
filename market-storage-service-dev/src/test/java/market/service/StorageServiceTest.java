package market.service;


import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import market.FilesStorageServiceApplication;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {FilesStorageServiceApplication.class})
class StorageServiceTest {

    @Autowired
    StorageService service;

    @Value("${application.bucket.name}")
    private String bucketName;

    private static MultipartFile multipartFile, multipartFile1;

    @Autowired
    AmazonS3 s3Client;

    @BeforeAll
    public static void prepareTestData() throws IOException {
        multipartFile = new MockMultipartFile("storage-service-test", "s torage-service-test.txt", "txt",
                new FileInputStream("src/test/resources/storage-service-test.txt"));
        multipartFile1 = null;
    }

    @Test
    void uploadFile() {
        try {
            service.uploadFile(multipartFile);

        } catch (AmazonServiceException ase) {
            System.out.println("Caught an AmazonServiceException, which " +
                    "means your request made it " +
                    "to Amazon S3, but was rejected with an error response" +
                    " for some reason.");
            System.out.println("Error Message:    " + ase.getMessage());
            System.out.println("HTTP Status Code: " + ase.getStatusCode());
            System.out.println("AWS Error Code:   " + ase.getErrorCode());
            System.out.println("Error Type:       " + ase.getErrorType());
            System.out.println("Request ID:       " + ase.getRequestId());
        }


    }

    @Test
    void testExpectedNullPointerExceptionWhenFileIsNull() throws NullPointerException {

        Throwable exception = assertThrows(NullPointerException.class, () -> {
            service.uploadFile(multipartFile1);
        });
        assertEquals("Cannot invoke \"org.springframework.web.multipart.MultipartFile.getOriginalFilename()\" because \"multipartFile\" is null",
                exception.getMessage());
    }

    @Test
    void downloadFile() {

        try {
            ObjectListing objectListing = s3Client.listObjects(bucketName);
            List<S3ObjectSummary> files = objectListing.getObjectSummaries();
            S3ObjectSummary s3Object = files.get(files.size()-1);
            service.downloadFile(s3Object.getKey());
        } catch (AmazonServiceException ase) {
            System.out.println("Caught an AmazonServiceException, which " +
                    "means your request made it " +
                    "to Amazon S3, but was rejected with an error response" +
                    " for some reason.");
            System.out.println("Error Message:    " + ase.getMessage());
            System.out.println("HTTP Status Code: " + ase.getStatusCode());
            System.out.println("AWS Error Code:   " + ase.getErrorCode());
            System.out.println("Error Type:       " + ase.getErrorType());
            System.out.println("Request ID:       " + ase.getRequestId());
        }

    }

    //  @Disabled
    @Test
    void deleteFile() {
        try {
            ObjectListing objectListing = s3Client.listObjects(bucketName);
            List<S3ObjectSummary> files = objectListing.getObjectSummaries();
            S3ObjectSummary s3Object = files.get(files.size() - 1);
            service.deleteFile(s3Object.getKey());
        } catch (AmazonServiceException ase) {
            System.out.println("Caught an AmazonServiceException, which " +
                    "means your request made it " +
                    "to Amazon S3, but was rejected with an error response" +
                    " for some reason.");
            System.out.println("Error Message:    " + ase.getMessage());
            System.out.println("HTTP Status Code: " + ase.getStatusCode());
            System.out.println("AWS Error Code:   " + ase.getErrorCode());
            System.out.println("Error Type:       " + ase.getErrorType());
            System.out.println("Request ID:       " + ase.getRequestId());
        }

    }

}