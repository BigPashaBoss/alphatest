package application.dao.giphy;

import application.model.giphy.GiphyClient;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface GiphyDAO {

    GiphyClient getGiphyClientForMoreValue() throws JsonProcessingException;

    GiphyClient getGiphyClientForLessValue() throws JsonProcessingException;



}
