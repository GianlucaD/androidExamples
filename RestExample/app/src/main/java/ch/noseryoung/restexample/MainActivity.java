package ch.noseryoung.restexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import ch.noseryoung.restexample.entities.Post;
import ch.noseryoung.restexample.services.JsonPlaceholderAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView postsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postsView = findViewById(R.id.postsview);
        Retrofit rf = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(GsonConverterFactory.create()).build();
        JsonPlaceholderAPI jsonPlaceholderAPI = rf.create(JsonPlaceholderAPI.class);

        Call<List<Post>> call = jsonPlaceholderAPI.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()){
                    postsView.setText("Error Code:" + response.code());
                    return;
                }
                List<Post> posts = response.body();
                for (Post post:
                        posts) {
                    String content = "";
                    content += "ID:" + post.getId() + "\n";
                    content += "User Id:" + post.getUserId() + "\n";
                    content += "Title:" + post.getTitle() + "\n";
                    content += "Text:" + post.getText() + "\n\n";
                    postsView.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                postsView.setText(t.getMessage());
            }
        });
    }
}
