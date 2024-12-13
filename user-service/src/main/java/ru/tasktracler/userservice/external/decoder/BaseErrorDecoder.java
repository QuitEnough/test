package ru.tasktracler.userservice.external.decoder;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import ru.tasktracler.userservice.exception.BaseException;
import ru.tasktracler.userservice.external.response.ErrorResponse;

import java.io.IOException;

public class BaseErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            ErrorResponse errorResponse = objectMapper
                    .readValue(response.body().asInputStream(), ErrorResponse.class);

            return new BaseException(errorResponse.getErrorMessage(), errorResponse.getErrorCode(), response.status());
        } catch (IOException e) {
            throw new BaseException("Internal Server Error", "INTERNAL_SERVER_ERROR", 500);
        }
    }
}
