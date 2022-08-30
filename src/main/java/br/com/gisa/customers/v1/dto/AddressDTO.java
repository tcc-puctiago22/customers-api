package br.com.gisa.customers.v1.dto;

import br.com.gisa.customers.v1.constants.UF;
import com.sun.istack.NotNull;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    @NotNull
    private String postcode;
    @NotNull
    private String streetName;
    @NotNull
    private Integer streetNumber;
    private String complement;
    @NotNull
    private String district;
    private String country;
    @NotNull
    private UF uf;
    @NotNull
    private String city;
}
