package application.controllers;

import application.model.giphy.GiphyClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import application.model.exchange.ExchangeCurrency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DecimalFormat;

@Controller
@RequestMapping("currencies")
public class CurrenciesController {

    @Autowired
    @Qualifier("lastExchange")
    private ExchangeCurrency lastExchange;

    @Autowired
    @Qualifier("previousExchange")
    private ExchangeCurrency previousExchange;

    @Autowired
    @Qualifier("giphyClientForMore")
    private GiphyClient giphyForMoreValue;

    @Autowired
    @Qualifier("giphyClientForLess")
    private GiphyClient giphyForLessValue;

    @GetMapping("/${test.url}")
    public String showLastExchange(@PathVariable String url, Model model) throws JsonProcessingException {
        double lastExchangeRate = lastExchange.getRate(url);
        double previousExchangeRate = previousExchange.getRate(url);
        double difference = lastExchangeRate - previousExchangeRate;

        model.addAttribute("lastExchange", lastExchangeRate);
        model.addAttribute("previousExchange", previousExchangeRate);
        model.addAttribute("difference", new DecimalFormat("#0.000000").format(difference));

        if (lastExchangeRate > previousExchangeRate){
            model.addAttribute("imageUrl", giphyForMoreValue.getRandomGiphyURL());
        } else {
            model.addAttribute("imageUrl", giphyForLessValue.getRandomGiphyURL());
        }

        return "currencies_rate";
    }

}
