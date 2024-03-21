package org.openmrs.eip.example;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("direct:event-listener-example")
                .routeId("event-listener-example")
                .process("openmrs-processor")
                .log("=============================Received db event===============================: ${body}");

    }
}