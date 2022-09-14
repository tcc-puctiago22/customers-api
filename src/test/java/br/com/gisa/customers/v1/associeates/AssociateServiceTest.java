package br.com.gisa.customers.v1.associeates;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import br.com.gisa.customers.v1.Application;
import br.com.gisa.customers.v1.associates.dto.post.AssociateDTO;
import br.com.gisa.customers.v1.associates.dto.post.PostAssociateDTO;
import br.com.gisa.customers.v1.associates.service.AssociateService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.doNothing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
public class AssociateServiceTest {
    //https://www.tutorialspoint.com/spring_boot_h2/spring_boot_h2_unit_test_service.htm

    @MockBean
    private AssociateService associateService;

    private String UUID="e7aa4ecd-d8ab-45a7-afb7-ae81f3131e50";

    @Test
    void getAssociateServiceByUuidAssertEquals() throws Exception {

        AssociateDTO associateDTO = HelperTest.returnGetAssociateDTO();
        given(associateService.findByUuid(UUID)).willReturn(associateDTO);
        AssociateDTO  retorno = associateService.findByUuid(UUID);
        assertEquals(retorno.getRegistration(),associateDTO.getRegistration() );

    }

    @Test
    void postAssociateServiceAsertEquals() throws Exception {

        PostAssociateDTO postAssociateDTO = HelperTest.returnPostAssociateDTO();
        AssociateDTO associateDTO = HelperTest.returnGetAssociateDTO();
        given(associateService.postAssociate(postAssociateDTO)).willReturn(associateDTO);
        AssociateDTO  retorno = associateService.postAssociate(postAssociateDTO);
        assertEquals(retorno.getRegistration(),associateDTO.getRegistration() );

    }
}
