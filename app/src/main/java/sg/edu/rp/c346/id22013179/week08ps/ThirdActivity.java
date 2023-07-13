package sg.edu.rp.c346.id22013179.week08ps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    TextView tvSongID;
    TextView tvSongTitle;
    TextView tvYears;
    TextView tvSingers;
    TextView tvStars;
    EditText etSongID;
    EditText etSongTitle;
    EditText etSingers;
    EditText etYears;
    EditText etStars;
    Button btnUpdate, btnDelete, btnCancel;

    Song song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        tvSongID = findViewById(R.id.tvSongID);
        tvSongTitle = findViewById(R.id.tvSongTitle);
        tvYears= findViewById(R.id.tvYears);
        tvSingers = findViewById(R.id.tvSingers);
        tvStars = findViewById(R.id.tvStars);
        etSongID = findViewById(R.id.etSongID);
        etSongTitle = findViewById(R.id.etSongTitle);
        etSingers = findViewById(R.id.etSingers);
        etYears = findViewById(R.id.etYears);
        etStars = findViewById(R.id.etStars);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnCancel = findViewById(R.id.btnCancel);

        Intent intent= getIntent();
        song = (Song) intent.getSerializableExtra("song");
        etSongTitle.setText(song.getTitle());
        etSingers.setText(song.getSingers());
        etYears.setText(String.valueOf(song.getYear()));
        etStars.setText(String.valueOf(song.getStars()));

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title =  etSongTitle.getText().toString().trim();
                String singer =  etSingers.getText().toString().trim();
                int year =  Integer.parseInt(etYears.getText().toString().trim());
                int star =  Integer.parseInt(etStars.getText().toString().trim());
                song.setTitle(title);
                song.setSingers(singer);
                song.setYear(year);
                song.setStars(star);
                DBHelper.updateSongs(song);
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper.deleteSongs(song.getId());
                finish();
            }
        });

    }
}

