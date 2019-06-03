package com.expedia.validator.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class ValidatorConfig extends ResourceConfig {

    /**
     * Used to set the service, manager beans and setup swagger
     */
    public ValidatorConfig() {
        packages("com.expedia.validator.services");
        packages("com.expedia.validator.manager");
        register(io.swagger.jaxrs.listing.ApiListingResource.class);
        register(io.swagger.jaxrs.listing.SwaggerSerializers.class);
        register(CORSResponseFilter.class);
    }

}
