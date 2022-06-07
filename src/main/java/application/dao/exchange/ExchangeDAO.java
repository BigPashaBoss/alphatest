package application.dao.exchange;

import application.model.exchange.ExchangeCurrency;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface ExchangeDAO {

    ExchangeCurrency getLastExchange() throws JsonProcessingException;

    ExchangeCurrency getPreviousExchange() throws JsonProcessingException;

}
