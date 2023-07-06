package sg.edu.rp.c346.id22014726.songs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText title;
    EditText singers;
    EditText year;
    RadioGroup ratings;
    Button insert;
    Button show;
    ListView lv;
    ArrayList<String> songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.editTitle);
        singers = findViewById(R.id.editSingers);
        year = findViewById(R.id.editYear);
        ratings = findViewById(R.id.Star);
        insert = findViewById(R.id.btnInsert);
        show = findViewById(R.id.btnShow);

    insert.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DBHelper db = new DBHelper(MainActivity.this);
            int ratingID = ratings.getCheckedRadioButtonId();
            String star = "";
            if(ratingID == R.id.rb1){
                star = "1";
            }else if(ratingID == R.id.rb2{
                star = "2";
            }else if(ratingID == R.id.rb3{
                star = "3";
            }else if(ratingID == R.id.rb4){
                star = "4";
            }else{
                star = "5";
            }
            db.insertSong(title.getText().toString(), singers.getText().toString(), Integer.parseInt(year.getText().toString()), stars);
            Toast toast = Toast.makeText(insert.getContext(), "Song added successfully", Toast.LENGTH_LONG);
            db.close();
        }
    });
            show.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DBHelper db = new DBHelper(MainActivity.this);

                    ArrayList<String> Title = db.getSongTitle();
                    ArrayList<String> Singers = db.getSongSingers();
                    ArrayList<String> Year = db.getSongYear();
                    ArrayList<String> Stars = db.getSongStars();
                    db.close();

                    String txt = "";
                    songs = new ArrayList<>();
                    for (int i = 0; i < Title.size(); i++) {
                        Log.d("Database Content", i +"\nSong Title: " + Title.get(i) + "\nSingers: " + dSingers.get(i) + "\nYear of Release: " + dyear.get(i)
                                + "\nStars: " + ratings.get(i));
                        txt = "\nSong Title: " + Title.get(i) + "\nSingers: " + Singers.get(i) + "\nYear of Release: " + dyear.get(i)
                                + "\nStars: " + ratings.get(i);
                        songs.add(i,txt + "\n");
                    }


                    ArrayAdapter adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, songs);
                    lv.setAdapter(adapter);

                }
            });
    }
}