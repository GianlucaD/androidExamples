package ch.noseryoung.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnListItemClickListener {


    private ArrayList mDataset = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataset.add("Gianluca1");
        mDataset.add("Gianluca2");
        mDataset.add("Gianluca3");
        mDataset.add("Gianluca4");
        mDataset.add("Gianluca5");
        mDataset.add("Gianluca6");
        mDataset.add("Gianluca7");
        mDataset.add("Gianluca8");
        mDataset.add("Gianluca9");
        mDataset.add("Gianluca10");
        mDataset.add("Gianluca11");
        mDataset.add("Gianluca12");
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.itemsView);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        MyAdapter mAdapter = new MyAdapter(mDataset, this);
        recyclerView.setAdapter(mAdapter);
    }


    @Override
    public void onItemClick(int position) {
        Toast toast = Toast.makeText(this.getApplicationContext(), "clicked on " + mDataset.get(position ), Toast.LENGTH_SHORT );
        toast.show();
    }
}
