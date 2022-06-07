package application.dao.exchange;

import application.consumer.exchange.LastExchangeConusmer;
import application.consumer.exchange.PreviousExchangeConsumer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import application.model.exchange.ExchangeCurrency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class ExchangeCurrencyDAO implements ExchangeDAO {

    @Autowired
    private LastExchangeConusmer lastExchangeUpdate;

    @Autowired
    private PreviousExchangeConsumer previousExchangeUpdate;

    @Bean("lastExchange")
    @Scope("prototype")
    public ExchangeCurrency getLastExchange() throws JsonProcessingException {
        return new ObjectMapper().readValue(lastExchangeUpdate.getLastExchangeUpdate(), ExchangeCurrency.class);
    }

    @Bean("previousExchange")
    @Scope("prototype")
    public ExchangeCurrency getPreviousExchange() throws JsonProcessingException {
        return new ObjectMapper().readValue(previousExchangeUpdate.getPreviousExchangeUpdate(), ExchangeCurrency.class);
    }
}
