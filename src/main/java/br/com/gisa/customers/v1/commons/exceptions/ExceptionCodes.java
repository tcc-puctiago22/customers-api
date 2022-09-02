package br.com.gisa.customers.v1.commons.exceptions;


import lombok.Getter;

@Getter
public enum ExceptionCodes {
    CPF_IS_INVALID(400, "CpfInvalid", "CPF é invalido."),
    OCCUPATION_NOT_FOUND(400, "OccupationalNotFound", "Profissão não encontrada."),
    PARTNER_NOT_FOUND(400, "PartnerNotFound", "Parceiro não encontrado."),
    INTERNAL_SERVER_ERROR(500, "InternalServerError", "Internal Server Error");

    private final int status;
    private final String errorCode;
    private final String message;

    ExceptionCodes(int status, String errorCode, String message) {
        this.status = status;
        this.errorCode = errorCode;
        this.message = message;
    }

}
