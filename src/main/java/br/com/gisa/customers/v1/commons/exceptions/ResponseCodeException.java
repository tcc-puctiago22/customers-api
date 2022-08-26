package br.com.gisa.customers.v1.commons.exceptions;


import lombok.Getter;

public class ResponseCodeException extends RuntimeException {

    private static final long serialVersionUID = 1958853396653067230L;

    @Getter private final transient Response response;

    public ResponseCodeException(ExceptionCodes code) {
        super(code.getMessage());
        this.response = new Response(code.getStatus(), code.getErrorCode(), code.getMessage());
    }

    public ResponseCodeException(ExceptionCodes code, Object ...params) {
        super(code.getMessage());
        this.response = new Response(code.getStatus(), code.getErrorCode(), String.format(code.getMessage(), params));
    }

    public ResponseCodeException(int code, String errorCode, String message) {
        super(message);
        this.response = new Response(code, errorCode, message);
    }

}
