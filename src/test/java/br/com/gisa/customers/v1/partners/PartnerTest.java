package br.com.gisa.customers.v1.partners;

import br.com.gisa.customers.v1.associates.web.AssociateController;
import br.com.gisa.customers.v1.partners.web.PartnersController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PartnerTest {
    @Autowired
    private PartnersController partnersController;

    @Test
    void contextLoads() {
        assertThat(partnersController).isNotNull();
    }
}
