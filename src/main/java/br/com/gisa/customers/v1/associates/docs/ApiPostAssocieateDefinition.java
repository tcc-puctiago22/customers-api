package br.com.gisa.customers.v1.associates.docs;
import br.com.gisa.customers.v1.docs.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Operation(tags = "Customers", summary = "Salva um associado",
        parameters = @Parameter(name = "Authorization", in = ParameterIn.HEADER, required = true, schema = @Schema(implementation = String.class)),
        responses = {
                @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(anyOf = {
                        AssociatePost.Response.class,
                }))),
                @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
        }
)
public @interface ApiPostAssocieateDefinition {
}
