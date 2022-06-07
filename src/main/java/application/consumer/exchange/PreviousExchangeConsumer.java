package application.consumer.exchange;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "previousexchange", url = "${exchange.previousURL}")
public interface PreviousExchangeConsumer {

    @GetMapping("")
    String getPreviousExchangeUpdate();

}
