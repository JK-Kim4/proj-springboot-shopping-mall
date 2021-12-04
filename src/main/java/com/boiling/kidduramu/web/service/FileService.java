package com.boiling.kidduramu.web.service;

import com.boiling.kidduramu.domain.products.File;
import com.boiling.kidduramu.domain.products.FileRepository;
import com.boiling.kidduramu.web.dto.FileUploadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class FileService {

    private final FileRepository fileRepository;

    @Transactional
    public Long fileSave(FileUploadDto fileUploadDto){
        return fileRepository.save(fileUploadDto.toEntity()).getId();
    }

    @Transactional
    public FileUploadDto getFile(Long id) {
        File file = fileRepository.findById(id).get();

        FileUploadDto fileDto = FileUploadDto.builder()
                .id(id)
                .origFilename(file.getOrigFilename())
                .filename(file.getFilename())
                .filePath(file.getFilePath())
                .build();
        return fileDto;
    }
}
