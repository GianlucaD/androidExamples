package ch.noseryoung.listviewdemo;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnListItemClickListener {


    private HashMap<Integer, String> mDataset = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataset.put(0, "Gianluca 0");
        mDataset.put(1, "Gianluca 1");
        mDataset.put(2, "Gianluca 2");
        mDataset.put(3, "Gianluca 3");
        mDataset.put(4, "Gianluca 4");
        mDataset.put(5, "Gianluca 5");
        mDataset.put(6, "Gianluca 6");
        mDataset.put(7, "Gianluca 7");
        mDataset.put(8, "Gianluca 8");
        mDataset.put(9, "Gianluca 9");
        mDataset.put(10, "Gianluca 10");
        mDataset.put(11, "Gianluca 11");
        mDataset.put(12, "Gianluca 12");
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
        Toast toast = Toast.makeText(this.getApplicationContext(), "clicked on " + mDataset.get(position), Toast.LENGTH_SHORT);
        toast.show();
    }
}
