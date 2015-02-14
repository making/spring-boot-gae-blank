package xxxxxx.yyyyyy.zzzzzz;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import org.gmr.web.multipart.GMultipartResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
public class App {

    @Bean
    @Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
    DatastoreService datastoreService() {
        return DatastoreServiceFactory.getDatastoreService();
    }

    @Bean
    @Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
    UserService userService() {
        return UserServiceFactory.getUserService();
    }

    @Bean(name = DispatcherServlet.MULTIPART_RESOLVER_BEAN_NAME)
    MultipartResolver multipartResolver(@Value("${multipart.maxFileSize:1048576}") int maxUploadSize) {
        GMultipartResolver multipartResolver = new GMultipartResolver();
        multipartResolver.setMaxUploadSize(maxUploadSize);
        return multipartResolver;
    }
}