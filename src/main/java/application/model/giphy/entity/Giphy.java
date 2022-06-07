package application.model.giphy.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties({"id", "url", "slug", "bitly_gif_url", "bitly_url", "embed_url",
        "username", "source", "title", "rating", "content_url", "source_tld", "source_post_url",
        "is_sticker", "import_datetime", "trending_datetime", "user", "analytics_response_payload",
        "analytics"})
public class Giphy {

    private String type;

    private Map<String, Image> images;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Image> getImages() {
        return images;
    }

    public Image getImageBySize(String size){
        return images.get(size);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Giphy giphy = (Giphy) o;
        return Objects.equals(type, giphy.type) && Objects.equals(images, giphy.images);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, images);
    }

    @Override
    public String toString() {
        return "Giphy{" +
                "type='" + type + '\'' +
                ", images=" + images +
                '}';
    }

}
