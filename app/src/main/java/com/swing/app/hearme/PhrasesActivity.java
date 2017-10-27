package com.swing.app.hearme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PhrasesActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);
    }

    public void imageClick(View v){
        Toast.makeText(this, ((EditText)(v)).getText(), Toast.LENGTH_LONG).show();
    }
}
