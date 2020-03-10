package ch.noseryoung.fragment.services;

import java.util.List;

import ch.noseryoung.fragment.entities.Album;
import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceholderAPI {

        @GET("albums")
        Call<List<Album>> getAlbums();
}
