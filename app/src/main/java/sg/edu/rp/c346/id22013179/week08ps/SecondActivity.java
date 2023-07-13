package sg.edu.rp.c346.id22013179.week08ps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;


public class SecondActivity extends AppCompatActivity {
    Button btnShowSong;
    ListView lvSongDetails;
    ArrayList<Song> songList;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnShowSong = findViewById(R.id.btnShowSong);
        lvSongDetails = findViewById(R.id.lvSongDetails);
        ArrayList<Song> songList;
        Adapter adapter;

        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_second);

            btnShowSong = findViewById(R.id.btnShowSong);
            lvSongDetails = findViewById(R.id.lvSongDetails);
            songList = DBHelper.getSong();
            adapter = new Adapter(this, R.layout.simple_list_item, songList);
            lvSongDetails.setAdapter(adapter);

            lvSongDetails.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Song clickSong = (Song) parent.getItemAtPosition(position);
                    Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                    intent.putExtra("song", clickSong);
                    startActivity(intent);
                }
            });

            btnShowSong.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ArrayList<Song> allStars = DBHelper.getAllStars();
                    adapter.clear();
                    adapter.addAll(allStars);
                    adapter.notifyDataSetChanged();
                }
            });

            public void onResume(){
                super.onResume();
                ArrayList<Song>songList = DBHelper.getSong();
                adapter.clear();
                adapter.addAll(songList);
                adapter.notifyDataSetChanged();
            }
        }
    }
}
