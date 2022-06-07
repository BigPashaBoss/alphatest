package application.consumer.exchange;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "lastexchange", url = "${exchange.lastURL}")
public interface LastExchangeConusmer {

    @GetMapping("")
    String getLastExchangeUpdate();

}
