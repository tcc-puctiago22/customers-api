package br.com.gisa.customers.v1.model.basic;

import br.com.gisa.customers.v1.constants.Status;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Getter
@Setter
public class BasicModel {

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updateDate;

    @CreatedDate
    @Column(name = "create_at")
    private LocalDateTime createdDate;

    @Column(name = "user", nullable = false, length = 50)
    private String user="SYSTEM";
}
