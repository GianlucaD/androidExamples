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
        mDataset.add("Gianluca 1");
        mDataset.add("Gianluca 2");
        mDataset.add("Gianluca 3");
        mDataset.add("Gianluca 4");
        mDataset.add("Gianluca 5");
        mDataset.add("Gianluca 6");
        mDataset.add("Gianluca 7");
        mDataset.add("Gianluca 8");
        mDataset.add("Gianluca 9");
        mDataset.add("Gianluca 10");
        mDataset.add("Gianluca 11");
        mDataset.add("Gianluca 12");
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
