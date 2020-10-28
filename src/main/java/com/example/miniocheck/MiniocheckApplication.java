package com.example.miniocheck;

import io.minio.MinioClient;
import io.minio.messages.Bucket;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class MiniocheckApplication {

  public static void main(String[] args) {
    SpringApplication.run(MiniocheckApplication.class, args);
  }

  @Bean
  public CommandLineRunner myRunner() {
    return args -> {
      MinioClient minioClient =
          MinioClient.builder()
              .endpoint("https://play.min.io")
              .credentials("Q3AM3UQ867SPQQA43P2F", "zuf+tfteSlswRu7BJ86wekitnifILbZam1KYY3TG")
              .build();
      minioClient.traceOn(System.out);

      List<Bucket> bucketList = minioClient.listBuckets();

      log.info("Bucket listing succeeded :)");

    };
  }
}
