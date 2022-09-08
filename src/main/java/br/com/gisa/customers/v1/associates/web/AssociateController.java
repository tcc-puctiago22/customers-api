package br.com.gisa.customers.v1.associates.web;

import br.com.gisa.customers.v1.associates.docs.ApiPostAssocieateDefinition;
import br.com.gisa.customers.v1.associates.dto.post.AssociateDTO;
import br.com.gisa.customers.v1.associates.dto.post.PostAssociateDTO;
import br.com.gisa.customers.v1.associates.model.Associate;
import br.com.gisa.customers.v1.associates.service.AssociateService;
import br.com.gisa.customers.v1.providers.dto.ProviderDTO;
import br.com.gisa.customers.v1.providers.dto.post.PostProviderDTO;
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
@RequestMapping("/v1/associetes")
@Tag(name = "Associetes", description = "Associados API")
public class AssociateController {

    @Autowired
    private AssociateService associateService;


    @PostMapping
    @ApiPostAssocieateDefinition
    public ResponseEntity<AssociateDTO> post(@RequestBody @Valid PostAssociateDTO request) {
        log.info("POST api/v1/associetes:: {}", request);
        AssociateDTO response = associateService.postAssociate(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<AssociateDTO> getProvider(@PathVariable("uuid") String uuid) {
        log.info("GET api/v1/associetes/{uuid}:: {}", uuid);
        AssociateDTO response = associateService.findByUuid(uuid);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
