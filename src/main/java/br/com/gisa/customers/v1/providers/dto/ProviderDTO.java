package br.com.gisa.customers.v1.providers.dto;

import br.com.gisa.customers.v1.dto.CustomerDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class ProviderDTO {
    private LocalDate birthDate;
    private String uuid;
    private String registration;
    private OccupationalDTO occupational;
    private CustomerDTO customer;
    private LocalDateTime updateDate;
    private LocalDateTime createDate;
    private String user;
}
