package com.swing.app.hearme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.swing.app.hearme.utils.TranslateManager;


public class TranslateActivity extends AppCompatActivity {

    private Button _btnTranslate;
    private EditText _txtTranslate;
    private LinearLayout _layTransImages;
    private TranslateManager _translateManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);
        setupConstrols();
        setupEvents();
    }

    private void setupConstrols() {
        _layTransImages = (LinearLayout) findViewById(R.id.llTranslateImages);
        _btnTranslate = (Button) findViewById(R.id.btnTranslateOk);
        _txtTranslate = (EditText) findViewById(R.id.txtTranslateText);
        _translateManager = new TranslateManager(getApplicationContext(),_layTransImages);
    }

    private void setupEvents() {
        _btnTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = _txtTranslate.getText().toString();
                if (!text.isEmpty() && !text.trim().isEmpty()) {
                    clearTranslateLayout();
                    _translateManager.getTranslation(text.trim());
                } else {
                    Toast.makeText(getApplicationContext(), "Porfavor ingresa una frase o palabra", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void clearTranslateLayout(){
        _layTransImages.removeAllViews();
    }
}
