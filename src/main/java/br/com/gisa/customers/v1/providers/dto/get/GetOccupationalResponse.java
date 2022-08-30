package br.com.gisa.customers.v1.providers.dto.get;

import br.com.gisa.customers.v1.constants.Status;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class GetOccupationalResponse {

    private String uuid;
    private String description;
    private String code;
    private Status status;
    private LocalDateTime updateDate;
    private LocalDateTime createDate;
    private String user;
}
