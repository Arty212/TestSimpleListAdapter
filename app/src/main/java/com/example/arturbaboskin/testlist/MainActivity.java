package com.example.arturbaboskin.testlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = findViewById(R.id.list);

        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 100000; i++)
            users.add(new User("NoName " + i,
                    " 8 800 555 35 " + i % 100));

        int to[] = new int[]{R.id.name, R.id.number, R.id.img};
        String from[] = new String[]{"name", "number", "img"};

        ArrayList<HashMap<String, Object>> data = new ArrayList<>();
        for (User i:users){
            HashMap<String, Object> user = new HashMap<>();
            user.put(from[0], i.getName());
            user.put(from[1], i.getNumber());
            user.put(from[2], i.getImg());
            data.add(user);
        }

        SimpleAdapter adapter = new SimpleAdapter(getApplicationContext(),
                data, R.layout.item, from, to);

        list.setAdapter(adapter);

    }
}
