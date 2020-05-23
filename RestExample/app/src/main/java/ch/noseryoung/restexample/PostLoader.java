package ch.noseryoung.restexample;

import android.util.Log;
import android.widget.TextView;

import java.util.List;

import ch.noseryoung.restexample.entities.Post;
import ch.noseryoung.restexample.services.JsonPlaceholderAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostLoader implements Callback<List<Post>>{

    private static final String TAG = "PostLoader";
    private static PostLoader instance;
    private boolean loaded = false;
    private List<Post> posts;

    private PostLoader(){
    }

    public static PostLoader getInstance(){
        if (instance == null){
            instance = new PostLoader();
        }
        return instance;
    }

    public List<Post> getData() {
        if (!loaded) {
            Retrofit rf = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(GsonConverterFactory.create()).build();
            JsonPlaceholderAPI jsonPlaceholderAPI = rf.create(JsonPlaceholderAPI.class);
            Call<List<Post>> call = jsonPlaceholderAPI.getPosts();
            call.enqueue(this);
        }
        return posts;
    }

    @Override
    public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
        if (!response.isSuccessful()) {
            Log.e(TAG, "Failure on gettings posts. Error Code:" + response.code());
            return;
        }
        posts = response.body();
    }

    @Override
    public void onFailure(Call<List<Post>> call, Throwable t) {

    }
}
