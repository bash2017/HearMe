package com.swing.app.hearme;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.TabLayout;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.swing.app.hearme.tabs.TabAcademy;
import com.swing.app.hearme.tabs.TabPhrases;
import com.swing.app.hearme.tabs.TabTranslate;
import com.swing.app.hearme.utils.SectionPageAdapter;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private SectionPageAdapter _sectionPageAdapter;
    private static final int REQ_CODE_SPEECH_INPUT = 100;
    public  static  MainActivity instancia;
    private EditText _txtTransl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancia = this;
        ViewPager _viewPager = (ViewPager) findViewById(R.id.containerMain);
        setupPageAdapter(_viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(_viewPager);

    }

    private void setupPageAdapter(ViewPager viewPager) {
        _sectionPageAdapter = new SectionPageAdapter(getSupportFragmentManager());
        _sectionPageAdapter.addFragment(new TabTranslate(), "Traductor");
        _sectionPageAdapter.addFragment(new TabPhrases(), "Frases Comunes");
        _sectionPageAdapter.addFragment(new TabAcademy(), "Academia");
        viewPager.setAdapter(_sectionPageAdapter);
    }

    public void buttonClick(EditText edit) {
        _txtTransl = edit;
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Hola, ¿que quieres traducir?");
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(), "No fue posible iniciar la caracteristica", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    _txtTransl.setText(result.get(0));
                }
                break;
            }
        }
    }
}
