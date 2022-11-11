package br.com.gisa.customers.v1.commons.helper;

import br.com.gisa.customers.v1.associates.dto.post.AssociateDTO;
import br.com.gisa.customers.v1.associates.dto.post.PostAssociateDTO;
import br.com.gisa.customers.v1.associates.dto.post.get.GetAssociateResponse;
import br.com.gisa.customers.v1.associates.model.Associate;
import br.com.gisa.customers.v1.constants.PersonType;
import br.com.gisa.customers.v1.partners.dto.GetPartnerResponse;
import br.com.gisa.customers.v1.partners.dto.post.PartnerDTO;
import br.com.gisa.customers.v1.partners.dto.post.PostPartnerDTO;
import br.com.gisa.customers.v1.partners.dto.put.PutPatnerDTO;
import br.com.gisa.customers.v1.partners.model.Partner;
import br.com.gisa.customers.v1.providers.dto.OccupationalDTO;
import br.com.gisa.customers.v1.providers.dto.ProviderDTO;
import br.com.gisa.customers.v1.providers.dto.get.GetOccupationalResponse;
import br.com.gisa.customers.v1.providers.dto.get.GetProviderResponse;
import br.com.gisa.customers.v1.providers.dto.post.PostProviderDTO;
import br.com.gisa.customers.v1.providers.model.Occupational;
import br.com.gisa.customers.v1.providers.model.Provider;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

@Component
public class Helper {

    private static final String SISA = "SISA";

    private static final String SISA_PJ = "SISA_PJ";
    private static final String SISA_PF = "SISA_PF";
    private static final String TRACO = "-";

    @Autowired
    private ModelMapper modelMapper;


   // ************* Provider ************

    public Provider converterDTOtoProvider(PostProviderDTO request){

        Provider entity = modelMapper.map(request, Provider.class);
        entity.getCustomer().setPersonType(PersonType.PF.toString());
        entity.getCustomer().setUuid(generateUUID());
        entity.getCustomer().getAddresses().forEach(address -> address.setUuid(generateUUID()));
        entity.getCustomer().getAddresses().forEach(address -> address.setCustomer(entity.getCustomer()));
        entity.getCustomer().getEmails().forEach(email -> email.setUuid(generateUUID()));
        entity.getCustomer().getEmails().forEach(email -> email.setCustomer(entity.getCustomer()));

        entity.getCustomer().getPhones().forEach(phone -> phone.setUuid(generateUUID()));
        entity.getCustomer().getPhones().forEach(phone -> phone.setCustomer(entity.getCustomer()));

        entity.setUuid(generateUUID());
        entity.setRegistration(getRegistration(SISA));
        entity.getCustomer().setProvider(null);
        entity.setListPartners(new HashSet<>());
        entity.setListOccupational(new HashSet<>());
        entity.getCustomer().setProvider(null);

        return entity;

    }
    public ProviderDTO converterProviderToDTO(Provider request){

        return modelMapper.map(request, ProviderDTO.class);
    }

    public GetProviderResponse convertToDto(Provider request) {
        return modelMapper.map(request, GetProviderResponse.class);
    }

    public GetPartnerResponse convertToDtoGetPartnerResponse(Partner request) {
        return modelMapper.map(request, GetPartnerResponse.class);
    }



    // ************* Partner*************

    public Partner converterDTOtoPartner(PostPartnerDTO request){
        Partner entity =  modelMapper.map(request, Partner.class);

        entity.getCustomer().setUuid(generateUUID());
        entity.getCustomer().setPersonType(PersonType.PJ.toString());
        entity.getCustomer().getAddresses().forEach(address -> address.setUuid(generateUUID()));
        entity.getCustomer().getAddresses().forEach(address -> address.setCustomer(entity.getCustomer()));
        entity.getCustomer().getEmails().forEach(email -> email.setUuid(generateUUID()));
        entity.getCustomer().getEmails().forEach(email -> email.setCustomer(entity.getCustomer()));
        entity.getCustomer().getPhones().forEach(phone -> phone.setUuid(generateUUID()));
        entity.getCustomer().getPhones().forEach(phone -> phone.setCustomer(entity.getCustomer()));

        entity.setRegistration(getRegistration(SISA_PJ));
        entity.setUuid(generateUUID());

        return entity;
    }

    public PartnerDTO converterPartnerToDTO(Partner request){
        return modelMapper.map(request, PartnerDTO.class);

    }

    public Partner converterDTOtoPartnerPut(PutPatnerDTO request) {
        return modelMapper.map(request, Partner.class);
    }


        public Associate converterDTOtoAssociate(PostAssociateDTO request) {
        Associate entity =  modelMapper.map(request, Associate.class);

        entity.getCustomer().setUuid(generateUUID());
        entity.getCustomer().setPersonType(PersonType.PF.toString());
        entity.getCustomer().getAddresses().forEach(address -> address.setUuid(generateUUID()));
        entity.getCustomer().getAddresses().forEach(address -> address.setCustomer(entity.getCustomer()));
        entity.getCustomer().getEmails().forEach(email -> email.setUuid(generateUUID()));
        entity.getCustomer().getEmails().forEach(email -> email.setCustomer(entity.getCustomer()));
        entity.getCustomer().getPhones().forEach(phone -> phone.setUuid(generateUUID()));
        entity.getCustomer().getPhones().forEach(phone -> phone.setCustomer(entity.getCustomer()));

        entity.setUuid(generateUUID());
        entity.setRegistration(getRegistration(SISA_PF));
        entity.getCustomer().setAssociate(null);

        return entity;
    }

    public AssociateDTO converterAssociateToDTO(Associate entity) {
        return modelMapper.map(entity, AssociateDTO.class);

    }


    private String getRegistration(String value){
        int number = new Random().nextInt(10);
        long time = Timestamp.valueOf(LocalDateTime.now()).getTime();
        return value.concat(String.valueOf(time))
                .concat(TRACO)
                .concat(String.valueOf(number));
    }
    private String generateUUID(){
        return  UUID.randomUUID().toString();
    }

    public OccupationalDTO converterOccupationalToDTO(Occupational entity) {
        return modelMapper.map(entity, OccupationalDTO.class);

    }

    public GetOccupationalResponse converterGetOccupationalResponse(Occupational request) {
        return modelMapper.map(request, GetOccupationalResponse.class);
    }

    public GetAssociateResponse converterGetAssociatelResponse(Associate request) {
        return modelMapper.map(request, GetAssociateResponse.class);

    }
}
