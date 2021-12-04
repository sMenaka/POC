package lk.fileuploader.controllers;

import lk.fileuploader.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/Upload")
public class FileUploaderController {

    @Autowired
    FileService fileService;
    @RequestMapping(value = "/video",method = RequestMethod.POST)
    public HttpEntity<Object> videoUpload(@RequestParam MultipartFile file){

        try {
            return ResponseEntity.status(HttpStatus.OK).body(fileService.uploadVideo(file));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }

    @RequestMapping(value = "/image",method = RequestMethod.POST)
    public HttpEntity<Object> imageUpload(@RequestParam MultipartFile file){

        try {
            return ResponseEntity.status(HttpStatus.OK).body(fileService.uploadImage(file));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
