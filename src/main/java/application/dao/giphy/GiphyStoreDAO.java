package application.dao.giphy;

import application.consumer.giphy.GiphyConsumer;
import application.model.giphy.GiphyClient;
import application.model.giphy.entity.GiphyStore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class GiphyStoreDAO implements GiphyDAO {

    @Autowired
    private GiphyConsumer giphyConsumer;

    private ObjectMapper mapper = new ObjectMapper();

    @Bean("giphyClientForMore")
    @Scope("prototype")
    public GiphyClient getGiphyClientForMoreValue() throws JsonProcessingException {
        GiphyStore gifStore = mapper.readValue(giphyConsumer.getGifForMoreValue(), GiphyStore.class);
        return new GiphyClient(gifStore);
    }

    @Bean(name = "giphyClientForLess")
    @Scope("prototype")
    public GiphyClient getGiphyClientForLessValue() throws JsonProcessingException {
        GiphyStore gifStore = mapper.readValue(giphyConsumer.getGifForLessValue(), GiphyStore.class);
        return new GiphyClient(gifStore);
    }
}
