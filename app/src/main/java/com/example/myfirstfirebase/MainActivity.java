package com.example.myfirstfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText editTextName;
    Button buttonAdd;
    Spinner spinnerGenres;
    DatabaseReference databaseArtists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseArtists = FirebaseDatabase.getInstance().getReference("artists");

        editTextName  = (EditText) findViewById(R.id.editTextName);
        buttonAdd     = (Button) findViewById(R.id.buttonAddArtist);
        spinnerGenres = (Spinner) findViewById(R.id.spinnerGenres);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               addArtist();
            }
        });
    }

    private void addArtist()  {
        String name = editTextName.getText().toString().trim();
        String genre = spinnerGenres.getSelectedItem().toString();

        if(!TextUtils.isEmpty(name)) {
            String id = databaseArtists.push().getKey();
            Artist artist = new Artist(id, name, genre);
            databaseArtists.child(id).setValue(artist);
            Toast.makeText(this, "Artist Added", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "You should enter a name", Toast.LENGTH_LONG).show();
        }
    }
}
