package co.com.prueba.api.controller;

public class ApiResponse<T> {

    private T data;
    private int status;
    private String message;

    public ApiResponse(T data, int status, String message) {
        this.data = data;
        this.status = status;
        this.message = message;

    }

    public T getData() {
        return data;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
