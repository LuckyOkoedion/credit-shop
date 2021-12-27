package com.example.LuckyOkoedionspringmvccreditshop.services.impl;

import com.example.LuckyOkoedionspringmvccreditshop.entities.FileEntity;
import com.example.LuckyOkoedionspringmvccreditshop.pojo.FileResponse;
import com.example.LuckyOkoedionspringmvccreditshop.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class FileService {
    
    private final Path rootLocation;

    private final FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        super();
        this.fileRepository = fileRepository;
        this.rootLocation = Paths.get(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/files/").toUriString());
    }

    public FileResponse save(MultipartFile file) throws IOException {
        FileEntity fileEntity = new FileEntity();
        fileEntity.setName(StringUtils.cleanPath(file.getOriginalFilename()));
        fileEntity.setContentType(file.getContentType());
        fileEntity.setData(file.getBytes());
        fileEntity.setSize(file.getSize());

        FileEntity result = fileRepository.save(fileEntity);
        FileResponse theResponse = this.mapToFileResponse(result);
        return theResponse;
    }

    public Optional<FileEntity> getFile(String id) {
        return fileRepository.findById(id);
    }

    public List<FileResponse> getAllFiles() {
        return fileRepository.findAll()
                .stream()
                .map(this::mapToFileResponse)
                .collect(Collectors.toList());
    }

    public Stream<Path> loadAll() throws IOException {
			return Files.walk(this.rootLocation, 1)
					.filter(path -> !path.equals(this.rootLocation))
					.map(path -> this.rootLocation.relativize(path));

	}

    private FileResponse mapToFileResponse(FileEntity fileEntity) {
        String downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/files/")
                .path(fileEntity.getId())
                .toUriString();
        FileResponse fileResponse = new FileResponse();
        fileResponse.setId(fileEntity.getId());
        fileResponse.setName(fileEntity.getName());
        fileResponse.setContentType(fileEntity.getContentType());
        fileResponse.setSize(fileEntity.getSize());
        fileResponse.setUrl(downloadURL);

        return fileResponse;
    }


}
