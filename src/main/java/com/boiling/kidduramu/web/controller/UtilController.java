package com.boiling.kidduramu.web.controller;


import com.boiling.kidduramu.utils.MD5Generator;
import com.boiling.kidduramu.web.dto.FileUploadDto;
import com.boiling.kidduramu.web.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/util")
public class UtilController {

    private final FileService fileService;

    @PostMapping("/file/upload")
    public Long fileUpload(@RequestParam("uploadFile") MultipartFile files){
        Long fileId = 0L;
        log.warn("files : " + files.toString());
        try{
            String orgFileName = files.getOriginalFilename();
            String fileName = new MD5Generator(orgFileName).toString();
            String savePath = System.getProperty("user.dir") + "\\files";
            /* 파일이 저장되는 폴더가 없으면 폴더를 생성합니다. */
            if (!new File(savePath).exists()) {
                try{
                    new File(savePath).mkdir();
                }
                catch(Exception e){
                    e.getStackTrace();
                }
            }
            String filePath = savePath + "\\" + fileName;
            files.transferTo(new File(filePath));

            FileUploadDto fileDto = FileUploadDto.builder()
                    .origFilename(orgFileName)
                    .filename(fileName).
                    filePath(filePath).build();

            fileId = fileService.fileSave(fileDto);

        }catch (Exception e){
            log.error("error", e);
        }
        return fileId;
    }
}
