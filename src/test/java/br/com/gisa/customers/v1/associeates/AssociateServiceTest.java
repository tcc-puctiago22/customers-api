package br.com.gisa.customers.v1.associeates;

import static org.junit.jupiter.api.Assertions.assertTrue;

import br.com.gisa.customers.v1.Application;
import br.com.gisa.customers.v1.associates.dto.post.PostAssociateDTO;
import br.com.gisa.customers.v1.associates.service.AssociateService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.doNothing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@/*ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)*/
public class AssociateServiceTest {
   /* https://www.tutorialspoint.com/spring_boot_h2/spring_boot_h2_unit_test_service.htm

    @Autowired
    private AssociateService associateService;


    @Test
    void postAssociateServiceByUuidReturns201() throws Exception {

        PostAssociateDTO postAssociateDTO = HelperTest.returnPostAssociateDTO();
        associateService.postAssociate(postAssociateDTO);
    }*/
}
