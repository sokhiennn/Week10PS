package sg.edu.rp.c346.id22013179.week08ps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Song> versionList;

    public CustomAdapter(@NonNull Context context, int resource,
                         ArrayList<Song> objects) {
        super(context, resource, objects);
        this.parent_context = context;
        this.layout_id = resource;
        this.versionList = objects;
    }

    public View getView(int index, View view, ViewGroup pcView) {
        View viewSong = view;

        if (viewSong == null){
            LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            viewSong = inflater.inflate(R.layout.row, pcView, false);
        }
        TextView tvSong = viewSong.findViewById(R.id.textViewSong);
        TextView tvYear = viewSong.findViewById(R.id.textViewYear);
        TextView tvStars = viewSong.findViewById(R.id.textViewStars);
        TextView tvSinger = viewSong.findViewById(R.id.textViewSinger);
        Song songPosition = versionList.get(index);

        tvSong.setText(songPosition.getTitle());
        tvYear.setText(String.valueOf(songPosition.getYear()));
        tvStars.setText(getRating(songPosition.getStars()));
        tvSinger.setText(songPosition.getSingers());

        return viewSong;
    }
    private String getRating(int stars) {
        switch (stars) {
            case 1:
                return "⭐️";
            case 2:
                return "⭐️⭐️";
            case 3:
                return "⭐️⭐️⭐️";
            case 4:
                return "⭐️⭐️⭐️⭐️";
            case 5:
                return "⭐️⭐️⭐️⭐️⭐️";
            default:
                return "";
        }
    }

}
