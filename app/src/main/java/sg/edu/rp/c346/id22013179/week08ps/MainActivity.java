package sg.edu.rp.c346.id22013179.week08ps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnInsert;
    Button btnGetSong;
    TextView tvTitle;
    TextView tvSinger;
    TextView tvYear;
    TextView tvStar;

    ListView lv;
    EditText editTitle;
    EditText editSingers;
    EditText editYear;
    RadioGroup radioGroupStars;
    ArrayList<Song> songList = new ArrayList<>();
    ArrayAdapter<Song> aaSong;

    RadioButton radioGroupStar1;
    RadioButton radioGroupStar2;
    RadioButton radioGroupStar3;
    RadioButton radioGroupStar4;
    RadioButton radioGroupStar5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.btnInsert);
        btnGetSong = findViewById(R.id.btnGetSong);
        tvTitle = findViewById(R.id.tvTitle);
        tvSinger = findViewById(R.id.tvSinger);
        tvYear = findViewById(R.id.tvYear);
        tvStar = findViewById(R.id.tvStar);
        lv = findViewById(R.id.lv);
        editTitle = findViewById(R.id.editTitle);
        editSingers = findViewById(R.id.editSingers);
        editYear = findViewById(R.id.editYear);
        radioGroupStars = findViewById(R.id.radioGroupStars);
        radioGroupStar1 =findViewById(R.id.radioButton1);
        radioGroupStar2 =findViewById(R.id.radioButton2);
        radioGroupStar3 =findViewById(R.id.radioButton3);
        radioGroupStar4 =findViewById(R.id.radioButton4);
        radioGroupStar5 =findViewById(R.id.radioButton5);

        songList = new ArrayList<>();
        aaSong = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, songList);
        lv.setAdapter(aaSong);

        btnInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                String title = editTitle.getText().toString();
                String singers = editSingers.getText().toString();
                int year = Integer.parseInt(editYear.getText().toString());
                int stars = getStarsSelect();

                db.insertSong(title, singers, year,stars);

                Toast.makeText(MainActivity.this, "Song inserted successfully!", Toast.LENGTH_SHORT).show();

                editTitle.setText("");
                editSingers.setText("");
                editYear.setText("");

            }
        });

        btnGetSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });


    }
    private int getStarsSelect(){
        int starsNo = radioGroupStars.getCheckedRadioButtonId();

        if(starsNo == R.id.radioButton1){
            return 1;
        }
        else if(starsNo == R.id.radioButton2){
            return 2;
        }
        else if(starsNo == R.id.radioButton3){
            return 3;
        }
        else if(starsNo == R.id.radioButton4){
            return 4;
        }
        else if(starsNo == R.id.radioButton5){
            return 5;
        }
        return 0;
    }
}
