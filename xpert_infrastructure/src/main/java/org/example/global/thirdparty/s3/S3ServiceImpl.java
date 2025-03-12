package org.example.global.thirdparty.s3;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.common.exception.general.InternalServerException;
import org.example.common.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class S3ServiceImpl implements FileService {
    private final AmazonS3Client amazonS3Client;

    @Value("${cloud.aws.bucket-name}")
    String bucketName;

    @Override
    public String uploadFile(MultipartFile file) {
        try {
            String name = UUID.randomUUID() + file.getOriginalFilename();

            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentType(file.getContentType());
            objectMetadata.setContentLength(file.getSize());

            amazonS3Client.putObject(bucketName, name, file.getInputStream(), objectMetadata);

            return amazonS3Client.getResourceUrl(bucketName, name);
        } catch (Exception e) {
            log.error("s3 파일 업로드중 에러 발생, 내용 : " + e.getLocalizedMessage());
            throw InternalServerException.EXCEPTION;
        }
    }
}
