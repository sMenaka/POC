package lk.fileuploader.services.Impls;

import lk.fileuploader.services.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
@Service
public class FileServiceImpl implements FileService {
    Logger log = LoggerFactory.getLogger(FileServiceImpl.class);

    @Override
    public String uploadImage(MultipartFile file) throws IOException {

        String fullFileName = StringUtils.cleanPath(file.getOriginalFilename());
       String[] splitFileName = fullFileName.split("\\.");
       String ext = splitFileName[splitFileName.length-1];
       String fileName = splitFileName[0];

        if (ext.equals("png") || ext.equals("jpg")|| ext.equals("jpeg") || ext.equals("tif")) {
           Path dirPath =  Paths.get(System.getProperty("user.home")+"/files");
           Path filePath = Paths.get(System.getProperty("user.home")+"/files/"+fileName);
            if (Files.exists(dirPath) && Files.isDirectory(dirPath)) {
                Files.copy(file.getInputStream(),filePath, StandardCopyOption.REPLACE_EXISTING);
            }else {
                Files.createDirectory(dirPath);
                Files.copy(file.getInputStream(),filePath, StandardCopyOption.REPLACE_EXISTING);
            }
        } else {
            throw new IOException("File type not support you have to upload image file");
        }


        return "Successfully saved the file "+ fullFileName;
    }

    @Override
    public String uploadVideo(MultipartFile file) throws IOException {
        String fullFileName = StringUtils.cleanPath(file.getOriginalFilename());
        String[] splitFileName = fullFileName.split("\\.");
        String ext = splitFileName[splitFileName.length-1];
        String fileName = splitFileName[0];

        if (ext.equals("mp4") || ext.equals("wmv") || ext.equals("webm") || ext.equals("mov")) {
            Path dirPath =  Paths.get(System.getProperty("user.home")+"/files");
            Path filePath = Paths.get(System.getProperty("user.home")+"/files/"+fileName);
            if (Files.exists(dirPath) && Files.isDirectory(dirPath)) {
                Files.copy(file.getInputStream(),filePath, StandardCopyOption.REPLACE_EXISTING);
            }else {
                Files.createDirectory(dirPath);
                Files.copy(file.getInputStream(),filePath, StandardCopyOption.REPLACE_EXISTING);
            }
        } else {
            throw new IOException("File type not support you have to upload video file");
        }

        return "Successfully saved the file "+ fullFileName;
    }
}
