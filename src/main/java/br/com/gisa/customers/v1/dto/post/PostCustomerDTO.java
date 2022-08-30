package br.com.gisa.customers.v1.dto.post;

import br.com.gisa.customers.v1.dto.PersonTypeDTO;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PostCustomerDTO {

    @NotNull
    private String document;
    @NotNull
    private String givenName;
    @NotNull
    private String status;
    @NotNull
    private PersonTypeDTO personType;
    private Set<PostEmailDTO> emails = new LinkedHashSet<>();
    private Set<PostPhoneDTO> phones = new LinkedHashSet<>();
    private Set<PostAddressDTO> addresses = new LinkedHashSet<>();
}
