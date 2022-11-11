package br.com.gisa.customers.v1.associeates;

import static org.mockito.Mockito.*;
import static org.hamcrest.core.Is.is;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import br.com.gisa.customers.v1.Application;
import br.com.gisa.customers.v1.associates.dto.post.AssociateDTO;
import br.com.gisa.customers.v1.associates.dto.post.PostAssociateDTO;
import br.com.gisa.customers.v1.associates.service.AssociateService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
@ActiveProfiles("test") // Like this
class AssociateControllerTest {

	@MockBean
	private AssociateService associateService;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void getAssociateControllerByUuidWhenReturns200() throws Exception {

		AssociateDTO dto = HelperTest.returnGetAssociateDTO();
		when(associateService.findByUuid("370efbec-72e2-4490-ac84-9c3bae67bed5"))
				.thenReturn(dto);

		mockMvc.perform(get("/v1/associetes/370efbec-72e2-4490-ac84-9c3bae67bed5")
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
						.andDo(print())
						.andExpect(status().isOk());

	}


	@Test
	void postAssociateControllerByUuidReturns201() throws Exception {
		AssociateDTO dto = HelperTest.returnGetAssociateDTO();
		PostAssociateDTO postAssociateDTO = HelperTest.returnPostAssociateDTO();

		when(associateService.post(any(postAssociateDTO.getClass()))).thenReturn(HelperTest.returnGetAssociateDTO());

		mockMvc.perform(post("/v1/associetes")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(dto)))
						.andDo(print())
						.andExpect(status().isCreated())
						.andExpect(jsonPath("registration", is(postAssociateDTO.getRegistration())));
		;
	}


}
