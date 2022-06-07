package application.consumer.giphy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "giphyFeign", url = "${giphy.api}")
public interface GiphyConsumer {

    @GetMapping("${giphy.url.more}")
    String getGifForMoreValue();

    @GetMapping("${giphy.url.less}")
    String getGifForLessValue();

}
