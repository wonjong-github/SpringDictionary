package me.hyunsoo.redissample;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import java.beans.Encoder;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Base64;

@SpringBootApplication
@RequiredArgsConstructor
public class RedisSampleApplication {

    private final Environment environment;

    public static void main(String[] args) throws UnsupportedEncodingException {

        var app = new SpringApplication(RedisSampleApplication.class);
        app.setWebApplicationType(WebApplicationType.SERVLET);
        app.run(args);
    }

}
