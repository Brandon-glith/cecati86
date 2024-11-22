package net.javaguides.springboot.Infrastructure;

import org.springframework.context.annotation.Configuration;
import com.google.api.client.util.Value;
//import com.mega.sdk.MegaApiClient;
//import com.mega.sdk.MegaError;
//import com.mega.sdk.MegaUser;


@Configuration
public class MegaConfig {

    @Value("${spring.mail.username}")
    private String email;

    @Value("${mega.api.password}")
    private String password;

}
