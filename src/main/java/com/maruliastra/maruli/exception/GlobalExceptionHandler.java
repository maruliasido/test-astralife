package com.maruliastra.maruli.exception;

import com.maruliastra.maruli.exception.CustomException.BusinessException;
import com.maruliastra.maruli.response.HttpResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final String ERR_ISE = "internal.server.exception";

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public HttpResponse<Map<Object, String>> badRequestHandler(HttpServletRequest req, Exception e){
        String [] fullError = e.getMessage().split("\\|");
        String errorCode = fullError[0];
        String errorMessage = errorMsg(fullError);
        return new HttpResponse<>(HttpResponse.HttpResponseStatus.FAILED, errorMessage, errorMessage, errorCode);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public HttpResponse<Map<Object, String>> iseHandler(HttpServletRequest req, Exception e){
        e.printStackTrace();
        return new HttpResponse<>(HttpResponse.HttpResponseStatus.FAILED, "Terjadi kesalahan pada server");
    }

    private String errorMsg(String [] fullError){
        StringBuilder error = new StringBuilder();

        for (int i = 0; i < fullError.length; i++){
            if (i > 0){
                error.append(fullError[i]);
            }
        }

        return error.toString();
    }

}
