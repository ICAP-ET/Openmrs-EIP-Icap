package org.openmrs.sync.component.camel;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.camel.Exchange;
import org.openmrs.sync.component.camel.fetchmodels.FetchModelsRuleEngine;
import org.openmrs.sync.component.model.BaseModel;
import org.openmrs.sync.component.model.SyncModel;
import org.openmrs.sync.component.utils.JsonUtils;
import org.springframework.context.ApplicationContext;

public class OpenmrsExtractProducer extends AbstractOpenmrsProducer {

    public OpenmrsExtractProducer(final OpenmrsEndpoint endpoint,
                                  final ApplicationContext applicationContext,
                                  final ProducerParams params) {
        super(endpoint, applicationContext, params);
    }

    @Override
    public void process(final Exchange exchange) {
        FetchModelsRuleEngine ruleEngine = (FetchModelsRuleEngine) applicationContext.getBean("fetchModelsRuleEngine");

        List<BaseModel> models = ruleEngine.process(params);

        List<SyncModel> modelsArray = models.stream()
                .filter(Objects::nonNull)
                .map(this::buildSyncModel)
                .collect(Collectors.toList());

        exchange.getIn().setBody(JsonUtils.marshall(modelsArray));
    }

    private SyncModel buildSyncModel(final BaseModel model) {
        return SyncModel.builder()
                .tableToSyncModelClass(params.getTableToSync().getModelClass())
                .model(model)
                .build();
    }
}
