package br.com.gisa.customers.v1.providers.model;


import br.com.gisa.customers.v1.constants.OccupationalType;
import br.com.gisa.customers.v1.constants.Status;
import br.com.gisa.customers.v1.model.basic.BasicModel;
import br.com.gisa.customers.v1.partners.model.Partner;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity(name = "occupational")
public class Occupational extends BasicModel implements Serializable {

    private static final long serialVersionUID = -2912692054440039507L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "uuid", nullable = false, length = 36)
    private String uuid;

    @Column(name = "type", nullable = false, length = 36)
    @Enumerated(EnumType.STRING)
    private OccupationalType type;

    @Column(name = "description", nullable = false, length = 200)
    private String description;

    @Column(name = "code", nullable = false, length = 15)
    private String code;

    @ManyToMany(mappedBy = "listOccupational",fetch = FetchType.LAZY)
    Set<Provider> listProviders = new HashSet<>();

}
