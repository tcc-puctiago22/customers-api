package br.com.gisa.customers.v1.dto;

import br.com.gisa.customers.v1.constants.PhoneType;
import br.com.gisa.customers.v1.constants.Status;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {

    private String country;
    private Integer dd;
    private Integer phone;
    private PhoneType type;
    private Status status;
    private LocalDateTime updateDate;
    private LocalDateTime createdDate;
    private String user;
}
