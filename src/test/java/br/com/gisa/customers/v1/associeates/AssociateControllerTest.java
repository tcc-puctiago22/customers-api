package br.com.gisa.customers.v1.associeates;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import br.com.gisa.customers.v1.associates.dto.post.AssociateDTO;
import br.com.gisa.customers.v1.associates.repository.IAssociateRepository;
import br.com.gisa.customers.v1.associates.service.AssociateService;
import br.com.gisa.customers.v1.associates.web.AssociateController;
import br.com.gisa.customers.v1.commons.helper.Helper;
import br.com.gisa.customers.v1.dto.CustomerDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

@ExtendWith(SpringExtension.class)
@Import(AssociateController.class)
@WebMvcTest(controllers = AssociateController.class)
@ContextConfiguration(classes = {IAssociateRepository.class, Helper.class, ModelMapper.class})
class AssociateControllerTest {

	@MockBean
	private AssociateService associateService;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void whenValidInput_thenReturns200() throws Exception {
		AssociateDTO dto = new AssociateDTO();
		dto.setAccountUuid("3d351808-5a59-4b60-96f9-c48986512070");
		dto.setCustomer(new CustomerDTO());
		dto.setCreatedDate(LocalDateTime.now());
		dto.setRegistration("SISA-123123123");
		dto.setPlanUuid("f0234842-a335-4c5e-9808-587e4c7eb6a4");
		dto.setUser("system");
		mockMvc.perform(get("/v1/associetes/370efbec-72e2-4490-ac84-9c3bae67bed5")
						.contentType("application/json")
						.content(objectMapper.writeValueAsString(dto)))
						.andExpect(status().isOk());
	}

}
