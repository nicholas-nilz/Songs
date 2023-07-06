package sg.edu.rp.c346.id22014726.songs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class List extends AppCompatActivity {

    Button back;
    ListView lv;
    ArrayAdapter<String> aa;
    ArrayList<Songs> arrList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        back = findViewById(R.id.btnBack);
        lv = findViewById(R.id.lv);

        DBHelper db = new DBHelper(List.this);
        db.close();
        DBHelper lvdb = new DBHelper(List.this);
        arrList = lvdb.getSongContent();
        lvdb.close();
        aa = new ArrayAdapter(List.this, android.R.layout.simple_list_item_1, arrList);
        lv.setAdapter(aa);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(List.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
