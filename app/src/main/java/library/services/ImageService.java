package library.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import jakarta.annotation.PostConstruct;
import library.repositories.BookRepository;

@Service
public class ImageService {

    private String path;

    @Value("${custom.image-path}")
    private String properiesPath;
    
    private final BookRepository bookRepository;

    @PostConstruct
    private void init() throws Exception{
        if(properiesPath == null){
            throw new Exception("Не выбрана директория хранения статической информации");
        }else{
            path = properiesPath + "/img";
        }
    }

    public String saveImage(MultipartFile image, String title, String authorName) throws IOException{
        File directory = new File(path);
        if (image==null) {
            return "";
        }
        String contentType = image.getContentType();
        if(contentType == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Не верный формат файла");
        }

        String fileName = String.format("cover_%s_%s.%s", title, authorName,  contentType.split("/")[1]);
        File newIamge = new File(directory, fileName);
        newIamge.createNewFile();

        try(FileOutputStream file = new FileOutputStream(newIamge);
            InputStream sentImage = image.getInputStream()){
            while (sentImage.available()>0) {
                file.write(sentImage.read());
            }
        }

        return fileName;
    }

    public byte[] getImage(Integer id){
        byte[] image = null;
        try{
            Path path = Path.of(properiesPath + bookRepository.getImage(id));
            image = Files.readAllBytes(path);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Ошибка загрузки файла");
        }
        return image;
    }

    //Set
    public void setProperiesPath(String properiesPath) {
        this.properiesPath = properiesPath;
    }
    //Constructor
    public ImageService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
}
