package com.example.LuckyOkoedionspringmvccreditshop.services.impl;

import com.example.LuckyOkoedionspringmvccreditshop.entities.FileEntity;
import com.example.LuckyOkoedionspringmvccreditshop.repositories.FileRepository;
import com.example.LuckyOkoedionspringmvccreditshop.services.IFileCrudService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileCrudService implements IFileCrudService {
    private FileRepository fileRepository;

    public FileCrudService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public List<FileEntity> getAll() {
        return this.fileRepository.findAll();
    }

    @Override
    public FileEntity create(FileEntity theObj) {
        return this.fileRepository.save(theObj);
    }

    @Override
    public FileEntity getOneById(Long id) {
        return fileRepository.getById(id);
    }

    @Override
    public FileEntity update(FileEntity theObj) {
        return fileRepository.save(theObj);
    }

    @Override
    public void destroy(Long id) {
        fileRepository.deleteById(id);
    }
}
