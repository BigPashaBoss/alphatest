package application.model.giphy.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties({"mp4_size", "mp4", "webp_size", "webp", "frames", "hash"})
public class Image {

    private int height;
    private int width;
    private int size;
    private String url;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return height == image.height && width == image.width && size == image.size && Objects.equals(url, image.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, width, size, url);
    }

    @Override
    public String toString() {
        return "Image{" +
                "height=" + height +
                ", width=" + width +
                ", size=" + size +
                ", url='" + url + '\'' +
                '}';
    }
}
