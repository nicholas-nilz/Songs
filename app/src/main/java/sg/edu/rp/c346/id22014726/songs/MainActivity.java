package sg.edu.rp.c346.id22014726.songs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText title;
    EditText singers;
    EditText year;
    RadioGroup ratings;
    Button insert;
    Button show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.editTitle);
        singers = findViewById(R.id.editSingers);
        year = findViewById(R.id.editYear);
        ratings = findViewById(R.id.Stars);
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
            db.close();
        }
    });
            show.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, activity_listview.class);
                    startActivity(intent);
                }
            });
    }
}