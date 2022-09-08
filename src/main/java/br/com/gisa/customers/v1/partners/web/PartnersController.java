package br.com.gisa.customers.v1.partners.web;

import br.com.gisa.customers.v1.associates.dto.post.AssociateDTO;
import br.com.gisa.customers.v1.partners.dto.post.PartnerDTO;
import br.com.gisa.customers.v1.partners.dto.post.PostPartnerDTO;
import br.com.gisa.customers.v1.partners.dto.put.PutPatnerDTO;
import br.com.gisa.customers.v1.partners.service.PartnerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/partner")
@Tag(name = "Partners", description = "Conveniados API")
public class PartnersController {

    @Autowired
    private PartnerService partnerService;

    @PostMapping
    public ResponseEntity<PartnerDTO> postPartner(@RequestBody @Valid PostPartnerDTO request) {
        log.info("POST /v1/partner:: {}", request);
        PartnerDTO response = partnerService.postPartner(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("{uuid}/providers")
    public ResponseEntity<PartnerDTO> putPartner(@PathVariable String uuid, @RequestBody @Valid PutPatnerDTO request) {
        log.info("PUT /v1/partner/uuid}/providers:: {}", request);
        request.setUuid(uuid);
        PartnerDTO response = partnerService.putPartnerProviders(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<PartnerDTO> getPartner(@PathVariable("uuid") String uuid) {
        log.info("GET api/v1/associetes/{uuid}:: {}", uuid);
        PartnerDTO response = partnerService.findByUuid(uuid);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
