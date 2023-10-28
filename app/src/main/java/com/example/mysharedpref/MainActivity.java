package com.example.mysharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mysharedpref.database.SongDAO;
import com.example.mysharedpref.model.Song;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etUsername;
    Button btnSave, btnLoad;

    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPref = getPreferences(Context.MODE_PRIVATE);

        etUsername = findViewById(R.id.etUsername);
        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
        btnLoad = findViewById(R.id.btnLoad);
        btnLoad.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        SongDAO songDao = new SongDAO();

        if(v.getId()==R.id.btnSave){
            Toast.makeText(this, "save btn cliked", Toast.LENGTH_SHORT).show();

            String resultUsername = etUsername.getText().toString();
            Toast.makeText(this, "saving "+resultUsername, Toast.LENGTH_SHORT).show();

//            SharedPreferences.Editor editor = sharedPref.edit();
//            editor.putString("username", resultUsername);
//            editor.apply();

            songDao.addSong(this,new Song(resultUsername));

        }else if(v.getId()==R.id.btnLoad){
            Toast.makeText(this, "load btn clicked", Toast.LENGTH_SHORT).show();

//            String loadedUsername = sharedPref.getString("username","");

            ArrayList<Song> songs = songDao.getSongs(this);
//            String loadedUsername = songs.get(0).title;
//            String loadedUsername = songs.get(songs.size()-1).title; //ambil last song
            String loadedUsername="";
            for(int i=0;i<songs.size();i++){
                loadedUsername+=songs.get(i).title;
            }
            etUsername.setText(loadedUsername);
        }
    }
}