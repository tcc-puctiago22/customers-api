package br.com.gisa.customers.v1.providers.model;


import br.com.gisa.customers.v1.constants.Status;
import br.com.gisa.customers.v1.model.basic.BasicModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity(name = "occupational")
public class Occupational extends BasicModel implements Serializable {

    @Serial
    private static final long serialVersionUID = -2912692054440039507L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "uuid", nullable = false, length = 36)
    private String uuid;

    @Column(name = "description", nullable = false, length = 200)
    private String description;

    @Column(name = "code", nullable = false, length = 15)
    private String code;

    @OneToMany(mappedBy = "occupational",  orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Provider> providers;

}
