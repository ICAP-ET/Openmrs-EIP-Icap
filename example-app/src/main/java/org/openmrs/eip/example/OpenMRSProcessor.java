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
        if(Objects.nonNull(message.getBody()) && message.getBody() instanceof Event){
            Event event = (Event) message.getBody();
            String tableName = event.getTableName();
            int primaryKeyId = Integer.parseInt(event.getPrimaryKeyId());
            String identifier = event.getIdentifier();

            // Send these values to another class
            //AnotherClass.processData(tableName, primaryKeyId, identifier);
        }



    }
}
