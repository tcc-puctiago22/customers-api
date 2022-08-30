package br.com.gisa.customers.v1.providers.web;

import br.com.gisa.customers.v1.commons.paginate.PaginationResponse;
import br.com.gisa.customers.v1.providers.dto.get.GetOccupationalRequest;
import br.com.gisa.customers.v1.providers.dto.get.GetOccupationalResponse;
import br.com.gisa.customers.v1.providers.dto.get.GetProviderResponse;
import br.com.gisa.customers.v1.providers.dto.post.PostProviderDTO;
import br.com.gisa.customers.v1.providers.dto.get.GetProviderRequest;
import br.com.gisa.customers.v1.providers.dto.ProviderDTO;
import br.com.gisa.customers.v1.providers.model.Occupational;
import br.com.gisa.customers.v1.providers.service.OccupationalService;
import br.com.gisa.customers.v1.providers.service.ProvidersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/providers")
public class ProvidersController {

    @Autowired
    private ProvidersService providersService;
    @Autowired
    private OccupationalService occupationalService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PaginationResponse<GetProviderResponse> getProviders(@Valid GetProviderRequest request) {
        log.info("GET api/v1/providers:: {}", request);

        Page<GetProviderResponse> response = providersService.findAll(request);
        return new PaginationResponse<>(response);
    }

    @GetMapping("/occupational")
    @ResponseStatus(HttpStatus.OK)
    public PaginationResponse<GetOccupationalResponse> getOccupational(@Valid GetOccupationalRequest request) {
        log.info("GET /v1/occupational:: {}", request);

        Page<GetOccupationalResponse> response = occupationalService.findAll(request);
        return new PaginationResponse<>(response);
    }

    @PostMapping
    public ResponseEntity<ProviderDTO> postProviders(@Valid PostProviderDTO request) {
        log.info("POST api/v1/providers:: {}", request);
        ProviderDTO response = providersService.post(request);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }


}
