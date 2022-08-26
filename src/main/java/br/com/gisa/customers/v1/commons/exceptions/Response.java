package br.com.gisa.customers.v1.commons.exceptions;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    private Integer status;
    private String errorCode;
    private String message;

    public Response(String message) {
        this.message = message;
    }

    public Response(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

}
