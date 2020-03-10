package ch.noseryoung.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ch.noseryoung.fragment.R;
import ch.noseryoung.fragment.entities.Album;

public class AlbumViewAdapter extends RecyclerView.Adapter<AlbumViewAdapter.ViewHolder> {

    private Context context;

    public AlbumViewAdapter(Context context, List<Album> albumList) {
        this.context = context;
        this.albumList = albumList;
    }

    private List<Album> albumList;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewAdapter.ViewHolder holder, int position) {
        Album album = albumList.get(position);
        holder.album.setText(album.getTitle());
    }


    @Override
    public int getItemCount() {
        return albumList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView album;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            album = itemView.findViewById(R.id.albumTitle);

        }
    }
}
