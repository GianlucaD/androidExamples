package ch.noseryoung.cardlayoutdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.AbsListView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ArrayList<User> data = new ArrayList<User>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        data.add(new User("Gianluca", "Daffré"));
        data.add(new User("Bart", "Simpson"));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView userView = findViewById(R.id.usersView);
        userView.setHasFixedSize(true);
        // use a linear layout manager
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        userView.setLayoutManager(layoutManager);
        UserAdapter userAdapter = new UserAdapter(data);
        userView.setAdapter(userAdapter);
    }
}
