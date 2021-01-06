package com.example.awsimageupload.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.Console;
import java.io.FileReader;

@Configuration
public class AmazonConfig {

    @Bean
    public AmazonS3 s3() {
        JSONParser jsonParser = new JSONParser();
        String accessKey = "";
        String secretKey = "";
        try {
            Object obj = jsonParser.parse(new FileReader("src/main/java/com/example/awsimageupload/config/AwsCredentials.json"));

            JSONObject jsonObject = (JSONObject) obj;
            accessKey = jsonObject.get("accessKey").toString();
            secretKey = jsonObject.get("secretKey").toString();

        } catch (Exception e) {
            e.printStackTrace();

        }

        AWSCredentials awsCredentials = new BasicAWSCredentials(
                accessKey,
                secretKey
        );

        return AmazonS3ClientBuilder
                .standard()
                .withRegion("eu-central-1")
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
    }
}
