package application.model.giphy.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties({"pagination","meta"})
public class GiphyStore {

    private List<Giphy> data;

    public List<Giphy> getData() {
        return data;
    }

    public void setData(List<Giphy> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GiphyStore that = (GiphyStore) o;
        return Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return "GiphyStore{" +
                "data=" + data +
                '}';
    }

}
