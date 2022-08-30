package br.com.gisa.customers.v1.providers.dto.post;

import br.com.gisa.customers.v1.constants.Status;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PostOccupationalDTO {
    private String uuid;
    private String description;
    private String code;
    private Status status;
    private LocalDateTime updateDate;
    private LocalDateTime createDate;
    private String user;
}
