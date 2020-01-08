package ch.noseryoung.restexample.services;

import java.util.List;

import ch.noseryoung.restexample.entities.Post;
import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceholderAPI {

        @GET("posts")
        Call<List<Post>> getPosts();
}
