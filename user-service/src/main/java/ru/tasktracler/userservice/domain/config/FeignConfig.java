package ru.tasktracler.userservice.domain.config;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.tasktracler.userservice.external.decoder.BaseErrorDecoder;

@Configuration
public class FeignConfig {

    @Bean
    ErrorDecoder errorDecoder() {
        return new BaseErrorDecoder();
    }

}
