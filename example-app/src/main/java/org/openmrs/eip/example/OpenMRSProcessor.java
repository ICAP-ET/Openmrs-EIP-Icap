package org.openmrs.eip.example;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.kafka.connect.data.Struct;
import org.openmrs.eip.mysql.watcher.Event;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component("openmrs-processor")
public class OpenMRSProcessor implements Processor {


    @Override
    public void process(Exchange exchange) throws Exception {
        Message message = exchange.getMessage();
        if(Objects.nonNull(exchange.getProperty("event"))){
            Event event =  (Event)exchange.getProperty("event");
            if(Objects.nonNull(event.getCurrentState())){
                Map<String,Object> state =  event.getCurrentState();

            }
        }



    }
}
