package market.controller;

import market.service.StorageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.multipart.MultipartFile;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StorageControllerTest {

    @InjectMocks
    StorageController sut;

    @Mock
    StorageService service;

    @Mock
    MultipartFile file;

    @Test
    void uploadFile() {
        sut.uploadFile(file);
        verify(service).uploadFile(file);
    }

    @Test
    void downloadFile() {
        sut.downloadFile(file.getOriginalFilename());
        verify(service).downloadFile(file.getOriginalFilename());
    }

    @Test
    void deleteFile() {
        sut.deleteFile(file.getOriginalFilename());
        verify(service).deleteFile(file.getOriginalFilename());
    }
}