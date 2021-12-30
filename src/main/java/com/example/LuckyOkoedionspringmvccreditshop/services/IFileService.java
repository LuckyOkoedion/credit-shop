package com.example.LuckyOkoedionspringmvccreditshop.services;
import com.example.LuckyOkoedionspringmvccreditshop.entities.FileEntity;
import com.example.LuckyOkoedionspringmvccreditshop.pojo.FileResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface IFileService {

    FileResponse save(MultipartFile file) throws IOException;

    Optional<FileEntity> getFile(String id);

    List<FileResponse> getAllFiles();

    Stream<Path> loadAll() throws IOException;


}
