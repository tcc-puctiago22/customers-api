package br.com.gisa.customers.v1.dto;

import lombok.*;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    private String uuid;
    @NonNull
    private String document;
    @NonNull
    private String givenName;
    @NonNull
    private String status;
    @NonNull
    private PersonTypeDTO personType;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
    private Set<EmailDTO> emails = new LinkedHashSet<>();
    private Set<PhoneDTO> phones = new LinkedHashSet<>();
    private Set<AddressDTO> addresses = new LinkedHashSet<>();
}
