package br.com.gisa.customers.v1.dto.post;

import br.com.gisa.customers.v1.commons.helper.SisaCpfValidate;
import br.com.gisa.customers.v1.dto.PersonTypeDTO;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PostPFCustomerDTO {

    @NotNull
    @SisaCpfValidate
    private String document;
    @NotNull
    private String givenName;
    @NotNull
    private PersonTypeDTO personType;

    @NotEmpty
    private Set<PostEmailDTO> emails;
    @NotEmpty
    private Set<PostPhoneDTO> phones;
    @NotEmpty
    private Set<PostAddressDTO> addresses;
}
