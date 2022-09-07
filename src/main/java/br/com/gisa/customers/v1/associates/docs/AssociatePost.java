package br.com.gisa.customers.v1.associates.docs;

import br.com.gisa.customers.v1.constants.EmailType;
import br.com.gisa.customers.v1.constants.PhoneType;
import br.com.gisa.customers.v1.constants.Status;
import br.com.gisa.customers.v1.constants.UF;
import br.com.gisa.customers.v1.dto.*;
import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
public class AssociatePost {

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Response {
        private String registration;
        private String planUuid;
        private String accountUuid;
        private CustomerResponse customer;
        private String status;
        @Schema(example = "2022-06-01")
        private LocalDateTime updateDate;
        @Schema(example = "2022-07-01")
        private LocalDateTime createdDate;
        @Schema(example = "SYSTEM")
        private String user;

    }

    public static  class CustomerResponse{

        private String uuid;
        private String document;
        private String givenName;
        private String status;
        private PersonTypeDTO personType;
        private LocalDateTime updateDate;
        private LocalDateTime createdDate;
        private String user;
        private Set<EmailResponse> emails = new LinkedHashSet<>();
        private Set<PhoneResponse> phones = new LinkedHashSet<>();
        private Set<AddressResponse> addresses = new LinkedHashSet<>();

    }
    public static  class EmailResponse{
        private String email;
        private EmailType type;
        private Status status;
        private LocalDateTime updateDate;
        private LocalDateTime createdDate;
        private String user;
    }

    public static  class PhoneResponse{
        private String country;
        private Integer dd;
        private Integer phone;
        private PhoneType type;
        private Status status;
        private LocalDateTime updateDate;
        private LocalDateTime createdDate;
        private String user;
    }

    public static  class AddressResponse{
        private String postcode;
        private String streetName;
        private Integer streetNumber;
        private String complement;
        private String district;
        private String country;
        private UF uf;
        private String city;
    }
}
