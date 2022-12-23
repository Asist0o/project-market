package market.controller;


import market.anatation.ResponseExceptionHandler;
import market.response.Response;
import market.service.StorageService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@ResponseExceptionHandler
@RequestMapping("/api/file")
public class StorageController {

    private final StorageService service;


    public StorageController(StorageService service) {
        this.service = service;
    }



    @PostMapping(path = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Response uploadFile(@RequestParam(value = "file") MultipartFile file) {
        service.uploadFile(file);
        return Response.success().status(200).build();
    }

    @PostMapping(path = "/uploads", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Response uploadFile(@RequestParam(value = "files") List<MultipartFile> files) {
        service.uploadFile(files);
        return Response.success().status(200).build();
    }

    @PostMapping(path = "/upload/video", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Response uploadVideo(@RequestParam(value = "videoFile") MultipartFile videoFile) {
            service.uploadFile(videoFile);
        return Response.success().status(201).build();
    }


    @GetMapping("/download/{fileName}")
    public Response downloadFile(@PathVariable String fileName) {
        byte[] data = service.downloadFile(fileName);
        return Response.success().data(data).status(200).build();
    }

    @DeleteMapping("/delete/{fileName}")
    public Response deleteFile(@PathVariable String fileName) {
        service.deleteFile(fileName);
        return Response.success().status(200).build();
    }
}
