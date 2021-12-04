package lk.fileuploader.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
@Service
public interface FileService {
    String uploadImage(MultipartFile file) throws Exception;
    String uploadVideo(MultipartFile file) throws Exception;
}
