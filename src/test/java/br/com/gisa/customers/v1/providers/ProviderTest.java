package br.com.gisa.customers.v1.providers;

import br.com.gisa.customers.v1.partners.web.PartnersController;
import br.com.gisa.customers.v1.providers.model.Provider;
import br.com.gisa.customers.v1.providers.web.ProvidersController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProviderTest {

    @Autowired
    private ProvidersController providersController;

    @Test
    void contextLoads() {
        assertThat(providersController).isNotNull();
    }
}
