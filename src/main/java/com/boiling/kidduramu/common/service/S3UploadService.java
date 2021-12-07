package com.boiling.kidduramu.common.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.Upload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@Service
public class S3UploadService {

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @Value("${cloud.aws.s3.bucket.url}")
    private String defaultUrl;

    private final AmazonS3Client amazonS3Client;

    public S3UploadService(AmazonS3Client amazonS3Client) {
        this.amazonS3Client = amazonS3Client;
    }

    public String upload(MultipartFile uploadFile) throws IOException {
        String origName = uploadFile.getOriginalFilename();
        String url;
        try {
            //확장자
            final String ext = origName.substring(origName.lastIndexOf('.'));
            //암호화
            final String saveFileName = getUuid() + ext;
            //파일객체 생성
            File file = new File(System.getProperty("user.dir") + saveFileName);
            //파일 변환
            uploadFile.transferTo(file);
            // S3 업로드
            uploadOnS3(saveFileName, file);
            url = defaultUrl + saveFileName;
            // 파일 삭제
            file.delete();
        } catch (StringIndexOutOfBoundsException e) {
            log.error("file upload error : {}", e);
            url = null;
        }
        return url;
    }

    private void uploadOnS3(final String findName, final File file){
        //AWS S3 전송 객체 생성
        final TransferManager transferManager = new TransferManager(this.amazonS3Client);
        //요청 객체 생성
        final PutObjectRequest request = new PutObjectRequest(bucket, findName, file);
        //업로드 요청
        final Upload upload = transferManager.upload(request);

        try{
            upload.waitForCompletion();
        }catch (Exception e){
            log.error("file upload error : {}", e);
        }
    }

    private static String getUuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
