package com.swing.app.hearme;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.swing.app.hearme.utils.TranslateManager;

import java.util.ArrayList;
import java.util.Locale;


public class TranslateActivity extends AppCompatActivity {
    private static final int REQ_CODE_SPEECH_INPUT = 100;
    private Button _btnTranslate;
    private EditText _txtTranslate;
    private LinearLayout _layTransImages;
    private TranslateManager _translateManager;
    private Button _bntSpeechToText;
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
        _bntSpeechToText = (Button)findViewById(R.id.btnSpeechToText);
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
        _bntSpeechToText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                        RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                        "Hola, ¿que quieres traducir?");
                try {
                    startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
                } catch (ActivityNotFoundException a) {
                    Toast.makeText(getApplicationContext(),
                            "No fue posible iniciar la caracteristica",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    _txtTranslate.setText(result.get(0));
                }
                break;
            }

        }
    }

    private void clearTranslateLayout(){
        _layTransImages.removeAllViews();
    }
}
