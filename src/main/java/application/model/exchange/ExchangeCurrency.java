package application.model.exchange;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Calendar;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties({"disclaimer","license"})
public class ExchangeCurrency implements ExchangeRate {

    @JsonProperty("base")
    private String baseCurrency;

    @JsonProperty("timestamp")
    private Calendar exchangeUpdateTime;

    @JsonProperty("rates")
    private Map<String, Double> exchangeRate;

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public Calendar getExchangeUpdateTime() {
        return exchangeUpdateTime;
    }

    public void setExchangeUpdateTime(String exchangeUpdateTime) {
        this.exchangeUpdateTime = Calendar.getInstance();
        this.exchangeUpdateTime.setTimeInMillis(Long.parseLong(exchangeUpdateTime) * 1000);
    }

    public Map<String, Double> getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Map<String, Double> exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @Override
    public double getRate(String currency) {
        return getExchangeRate().get(currency);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExchangeCurrency that = (ExchangeCurrency) o;
        return Objects.equals(baseCurrency, that.baseCurrency) && Objects.equals(exchangeUpdateTime, that.exchangeUpdateTime) && Objects.equals(exchangeRate, that.exchangeRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseCurrency, exchangeUpdateTime, exchangeRate);
    }

    @Override
    public String toString() {
        return "ExchangeCurrency{" +
                "baseCurrency='" + baseCurrency + '\'' +
                ", exchangeUpdateTime=" + exchangeUpdateTime.getTime() +
                ", exchangeRate=" + exchangeRate +
                '}';
    }
}
