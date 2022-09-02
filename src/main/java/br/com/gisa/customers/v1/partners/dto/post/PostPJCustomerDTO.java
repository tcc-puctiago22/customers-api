package br.com.gisa.customers.v1.partners.dto.post;

import br.com.gisa.customers.v1.commons.helper.SisaCNPJValidator;
import br.com.gisa.customers.v1.dto.PersonTypeDTO;
import br.com.gisa.customers.v1.dto.post.PostAddressDTO;
import br.com.gisa.customers.v1.dto.post.PostEmailDTO;
import br.com.gisa.customers.v1.dto.post.PostPhoneDTO;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PostPJCustomerDTO {

    @NotNull
    @SisaCNPJValidator
    private String document;
    @NotNull
    private String givenName;

    @NotEmpty
    private Set<PostEmailDTO> emails;
    @NotEmpty
    private Set<PostPhoneDTO> phones;
    @NotEmpty
    private Set<PostAddressDTO> addresses;
}
