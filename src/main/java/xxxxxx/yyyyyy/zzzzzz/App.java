package xxxxxx.yyyyyy.zzzzzz;

import org.gmr.web.multipart.GMultipartResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
public class App {

    @Bean(name = DispatcherServlet.MULTIPART_RESOLVER_BEAN_NAME)
    MultipartResolver multipartResolver(@Value("${multipart.maxFileSize:1048576}") int maxUploadSize) {
        GMultipartResolver multipartResolver = new GMultipartResolver();
        multipartResolver.setMaxUploadSize(maxUploadSize);
        return multipartResolver;
    }
}