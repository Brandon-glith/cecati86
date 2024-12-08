package net.javaguides.springboot.Infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;

import net.javaguides.springboot.ApplicationLayer.MegaSDK;

@Configuration
public class MegaConfig {

    @Value("${spring.mail.username}")
    private String email;

    @Value("${mega.api.password}")
    private String password;

    @Bean
    public MegaSDK mega() {
        return new MegaSDK(email, password);
    }

}
