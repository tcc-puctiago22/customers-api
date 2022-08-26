package br.com.gisa.customers.v1.providers.web;

import br.com.gisa.customers.v1.commons.exceptions.ExceptionCodes;
import br.com.gisa.customers.v1.commons.exceptions.ResponseCodeException;
import br.com.gisa.customers.v1.commons.paginate.PaginationResponse;
import br.com.gisa.customers.v1.providers.dto.ProviderDTO;
import br.com.gisa.customers.v1.providers.dto.ProviderRequest;
import br.com.gisa.customers.v1.providers.service.ProvidersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api/v1/providers")
public class ProvidersController {

    @Autowired
    private ProvidersService providersService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PaginationResponse<ProviderDTO> getOffer(@RequestAttribute String applicationUuid,
                                                    @Valid ProviderRequest request) {
        log.info("GET api/v1/providers:: {}", request);

        Page<ProviderDTO> response = providersService.findAll(request);
        return new PaginationResponse<>(response);
    }




}
