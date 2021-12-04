package com.boiling.kidduramu.web.controller;

import com.boiling.kidduramu.utils.MD5Generator;
import com.boiling.kidduramu.web.dto.FileUploadDto;
import com.boiling.kidduramu.web.dto.ProductSaveReuestDto;
import com.boiling.kidduramu.web.dto.ProductUpdateRequestDto;
import com.boiling.kidduramu.web.service.FileService;
import com.boiling.kidduramu.web.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ProductApiController {

    private final ProductService productService;
    private final FileService fileService;

    @PostMapping("/api/product/insert")
    public Long save(@RequestParam("uploadFile") MultipartFile files,
                     @RequestBody ProductSaveReuestDto productSaveRequestDto){
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

            Long fileId = fileService.fileSave(fileDto);
            productSaveRequestDto.setFileId(fileId);

        }catch (Exception e){
            log.error("error", e);
        }
        return productService.save(productSaveRequestDto);
    }

    @PutMapping("/api/product/update/{id}")
    public Long update(@PathVariable Long id, @RequestBody ProductUpdateRequestDto productUpdateRequestDto){
        return productService.update(id, productUpdateRequestDto);
    }
}
