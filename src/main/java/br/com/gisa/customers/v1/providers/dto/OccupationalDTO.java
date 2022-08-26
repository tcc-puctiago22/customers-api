package br.com.gisa.customers.v1.providers.dto;

import br.com.gisa.customers.v1.constants.Status;
import br.com.gisa.customers.v1.providers.model.Provider;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
public class OccupationalDTO {
    private String uuid;
    private String description;
    private String code;
    private Status status;
    private LocalDateTime updateDate;
    private LocalDateTime createDate;
    private String user;
}
