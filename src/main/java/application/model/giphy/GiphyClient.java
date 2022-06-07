package application.model.giphy;

import application.model.giphy.entity.Giphy;
import application.model.giphy.entity.GiphyStore;
import application.model.giphy.entity.Image;
import org.springframework.beans.factory.annotation.Value;

import java.security.SecureRandom;

public class GiphyClient implements GiphyRandom {

    @Value("${giphy.countGif}")
    private int countGif;

    @Value("${giphy.size}")
    private String gifSize;

    private GiphyStore giphyStore;

    public GiphyClient(GiphyStore giphyStore) {
        this.giphyStore = giphyStore;
    }

    @Override
    public String getRandomGiphyURL() {
        int randomGif = new SecureRandom().nextInt(countGif);
        Giphy gif = giphyStore.getData().get(randomGif);
        Image gifImage = gif.getImageBySize(gifSize);
        return gifImage.getUrl();
    }

}
