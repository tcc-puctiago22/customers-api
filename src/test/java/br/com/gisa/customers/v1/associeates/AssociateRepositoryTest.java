package br.com.gisa.customers.v1.associeates;
import static org.junit.jupiter.api.Assertions.assertEquals;

import br.com.gisa.customers.v1.Application;
import br.com.gisa.customers.v1.associates.model.Associate;
import br.com.gisa.customers.v1.associates.repository.IAssociateRepository;
import org.hibernate.envers.Audited;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import javax.transaction.Transactional;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest(classes = Application.class)
public class AssociateRepositoryTest {

    @Autowired
    private IAssociateRepository iAssociateRepository;

    @Test
    public void testFindByUuid() {
        Optional<Associate> result = iAssociateRepository.findByUuid("370efbec-72e2-4490-ac84-9c3bae67bed5");
        assertEquals(result.get().getUuid(), "370efbec-72e2-4490-ac84-9c3bae67bed5");
    }

}
