package br.com.gisa.customers.v1.commons;

import br.com.gisa.customers.v1.providers.dto.ProviderDTO;
import br.com.gisa.customers.v1.providers.dto.get.GetProviderResponse;
import br.com.gisa.customers.v1.providers.dto.post.PostProviderDTO;
import br.com.gisa.customers.v1.providers.model.Provider;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@Component
public class Helper {

    private static final String SISA = "SISA";
    private static final String TRACO = "-";

    @Autowired
    private ModelMapper modelMapper;

    public String getProvideregistration(){
        Random gerador = new Random();
        int number = gerador.nextInt(10);
        long time = Timestamp.valueOf(LocalDateTime.now()).getTime();
        return SISA.concat(String.valueOf(time))
                .concat(TRACO)
                .concat(String.valueOf(number));
    }

    public GetProviderResponse convertToDto(Provider request) {
        return modelMapper.map(request, GetProviderResponse.class);
    }

    public Provider converterDTOtoProvider(PostProviderDTO request){
        Provider provider = modelMapper.map(request, Provider.class);
        provider.getCustomer().setUuid(generateUUID());
        provider.getCustomer().getAddresses().forEach(address -> address.setUuid(generateUUID()));
        provider.getCustomer().getEmails().forEach(email -> email.setUuid(generateUUID()));
        provider.getCustomer().getPhones().forEach(phone -> phone.setUuid(generateUUID()));

        provider.setUuid(generateUUID());
        return provider;

    }

    public ProviderDTO converterProviderToDTO(Provider request){
        return modelMapper.map(request, ProviderDTO.class);
    }

    public String generateUUID(){
       return  UUID.randomUUID().toString();
    }
}
