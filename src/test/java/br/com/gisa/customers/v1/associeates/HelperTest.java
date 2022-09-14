package br.com.gisa.customers.v1.associeates;

import br.com.gisa.customers.v1.associates.dto.post.AssociateDTO;
import br.com.gisa.customers.v1.associates.dto.post.PostAssociateDTO;
import br.com.gisa.customers.v1.constants.Status;
import br.com.gisa.customers.v1.constants.UF;
import br.com.gisa.customers.v1.dto.AddressDTO;
import br.com.gisa.customers.v1.dto.CustomerDTO;
import br.com.gisa.customers.v1.dto.EmailDTO;
import br.com.gisa.customers.v1.dto.PhoneDTO;
import br.com.gisa.customers.v1.dto.post.PostAddressDTO;
import br.com.gisa.customers.v1.dto.post.PostEmailDTO;
import br.com.gisa.customers.v1.dto.post.PostPFCustomerDTO;
import br.com.gisa.customers.v1.dto.post.PostPhoneDTO;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

public  class HelperTest {


    public static AssociateDTO returnGetAssociateDTO(){
        AssociateDTO dto = new AssociateDTO();
        dto.setAccountUuid("3d351808-5a59-4b60-96f9-c48986512070");
        dto.setCustomer(getCustomerDTO());
        dto.setCreatedDate(LocalDateTime.now());
        dto.setRegistration("SISA_PF1662508498567-6");
        dto.setPlanUuid("f0234842-a335-4c5e-9808-587e4c7eb6a4");
        dto.setUser("system");

        return dto;
    }

    private static CustomerDTO getCustomerDTO() {
        CustomerDTO customer = new CustomerDTO();
        Set<EmailDTO> emails = new LinkedHashSet<>();
        Set<PhoneDTO> phones = new LinkedHashSet<>();
        Set<AddressDTO> addresses = new LinkedHashSet<>();
        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setEmail("joaosilva03@gmail.com");
        emailDTO.setStatus(Status.ACTIVE);

        PhoneDTO phoneDTO = new PhoneDTO();
        phoneDTO.setStatus(Status.ACTIVE);
        phoneDTO.setDd(21);
        phoneDTO.setPhone(924242524);
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setPostcode("05317-020");
        addressDTO.setStreetName("Av. Manuel Bandeira");
        addressDTO.setComplement("Bloco A");
        addressDTO.setCity("São Paulo");
        addressDTO.setUf(UF.SP);
        addressDTO.setStreetNumber(123);
        addressDTO.setDistrict("Vila Leopoldina");
        addresses.add(addressDTO);

        customer.setPhones(phones);
        customer.setEmails(emails);
        customer.setAddresses(addresses);
        customer.setCreatedDate(LocalDateTime.now());
        customer.setUser("system");
        customer.setDocument("00061997048");
        customer.setGivenName("João");
        return customer;
    }

    public static PostPFCustomerDTO postPostPFCustomerDTO() {
        PostPFCustomerDTO customer = new PostPFCustomerDTO();
        Set<PostEmailDTO> emails = new LinkedHashSet<>();
        Set<PostPhoneDTO> phones = new LinkedHashSet<>();
        Set<PostAddressDTO> addresses = new LinkedHashSet<>();

        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setEmail("joaosilva03@gmail.com");
        emailDTO.setStatus(Status.ACTIVE);

        PostPhoneDTO phoneDTO = new PostPhoneDTO();
        phoneDTO.setStatus(Status.ACTIVE);
        phoneDTO.setDdd(21);
        phoneDTO.setPhoneNumber("924242524");

        PostAddressDTO addressDTO = new PostAddressDTO();
        addressDTO.setPostcode("05317-020");
        addressDTO.setStreetName("Av. Manuel Bandeira");
        addressDTO.setComplement("Bloco A");
        addressDTO.setCity("São Paulo");
        addressDTO.setUf(UF.SP);
        addressDTO.setStreetNumber(123);
        addressDTO.setDistrict("Vila Leopoldina");
        addresses.add(addressDTO);

        customer.setPhones(phones);
        customer.setEmails(emails);
        customer.setAddresses(addresses);
        customer.setDocument("42710505045");
        return customer;
    }

    public static PostAssociateDTO returnPostAssociateDTO() {
        PostAssociateDTO post = new PostAssociateDTO();
        post.setRegistration("SISA_PF1662508498567-6");
        post.setCustomer(postPostPFCustomerDTO());

        return post;
    }


}
