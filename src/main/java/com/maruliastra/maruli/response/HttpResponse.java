package com.maruliastra.maruli.response;



import java.util.Date;

public class HttpResponse<T> {
    public HttpResponseStatus status;
    public long timestamp;
    public String message;
    public String error;
    public String errorCode;
    public Object data;

    public HttpResponse(Exception e, String errorCode) {
        this.status = HttpResponse.HttpResponseStatus.FAILED;
        this.timestamp = (new Date()).getTime();
        this.message = "";
        this.error = e.getMessage();
        this.errorCode = errorCode;
        this.data = null;
    }

    public HttpResponse() {
        this.status = HttpResponse.HttpResponseStatus.FAILED;
        this.timestamp = (new Date()).getTime();
        this.message = "";
        this.error = "Not found";
        this.data = null;
    }

    public HttpResponse(T data) {
        this.status = HttpResponse.HttpResponseStatus.SUCCESS;
        this.timestamp = (new Date()).getTime();
        this.message = "";
        this.error = "";
        this.data = data;
    }

    public HttpResponse(T data, String message) {
        this.status = HttpResponse.HttpResponseStatus.SUCCESS;
        this.timestamp = (new Date()).getTime();
        this.message = message;
        this.error = "";
        this.data = data;
    }

    public HttpResponse(HttpResponseStatus status, String message) {
        this.status = status;
        this.timestamp = (new Date()).getTime();
        this.message = message;
        this.error = "";
        this.data = null;
    }

    public HttpResponse(HttpResponseStatus status, String message, String error, String errorCode) {
        this.status = status;
        this.timestamp = (new Date()).getTime();
        this.message = message;
        this.error = error;
        this.errorCode = errorCode;
        this.data = null;
    }


    public static enum HttpResponseStatus {
        SUCCESS,
        FAILED,
        UNAUTHORIZED;

        private HttpResponseStatus() {
        }
    }
}
