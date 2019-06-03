package com.expedia.validator.services;

import com.expedia.validator.entity.CardInfo;
import com.expedia.validator.manager.ValidationManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.glassfish.hk2.api.ValidationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/cc")
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "/validatorService",
        description = "The validator service is used to check if the card is valid or not")
public class ValidatorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationService.class);
    private ValidationManager validationManager;

    public ValidatorService(ValidationManager validationManager) {
        this.validationManager = validationManager;
    }

    @POST
    @Path("/validate")
    @ApiOperation(value = "Check Credit Card Validity",
            notes="Check whether the Credit Card is valid")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Card Info Status", response = CardInfo.class),
            @ApiResponse(code = 404, message = "Cannot find the method"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    public Response validateCard(CardInfo cardInfo) {
        LOGGER.info("validate card");
        return Response.ok(validationManager.validateCard(cardInfo))
                .build();
    }

    @GET
    @Path("/blacklist")
    @ApiOperation(value = "Get the black list cards", notes = "Get the list of black cards")
    @ApiResponses(value = {
       @ApiResponse(code = 200, message = "Black List cards", response = String.class),
       @ApiResponse(code = 404, message = "Black List cards method not found"),
       @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public Response getCardBlacklist() {
        LOGGER.info("get blacklist cards");
        return Response.ok(validationManager.getBlackList()).build();
    }

    
}
