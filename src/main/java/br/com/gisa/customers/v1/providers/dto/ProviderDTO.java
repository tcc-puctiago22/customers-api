package br.com.gisa.customers.v1.providers.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
public class ProviderDTO {

    private String uuid;
    private String registration;
    private OccupationalDTO occupational;
    private LocalDateTime updateDate;
    private LocalDateTime createDate;
    private String user;
}
