package com.swing.app.hearme.tabs;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.swing.app.hearme.MainActivity;
import com.swing.app.hearme.R;
import com.swing.app.hearme.utils.TranslateManager;

import java.util.ArrayList;
import java.util.Locale;

import com.swing.app.hearme.R;

/**
 * Created by swing on 10/27/17.
 */

public class TabTranslate extends Fragment {
    private View _view;

    private static final int REQ_CODE_SPEECH_INPUT = 100;
    private Button _btnTranslate;
    private EditText _txtTranslate;
    private LinearLayout _layTransImages;
    private TranslateManager _translateManager;
    private ImageButton _bntSpeechToText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        _view = inflater.inflate(R.layout.tab_translate, container, false);

        setupConstrols();
        setupEvents();

        return _view;
    }

    private void setupConstrols() {
        _layTransImages = (LinearLayout) _view.findViewById(R.id.llTranslateImages);
        _btnTranslate = (Button) _view.findViewById(R.id.btnTranslateOk);
        _txtTranslate = (EditText) _view.findViewById(R.id.txtTranslateText);
        _translateManager = new TranslateManager(getActivity(), _layTransImages);
        _bntSpeechToText = (ImageButton) _view.findViewById(R.id.btnSpeechToText);
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
                    Toast.makeText(getActivity(), "Porfavor ingresa una frase o palabra", Toast.LENGTH_SHORT).show();
                }
            }
        });
        _bntSpeechToText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.instancia.buttonClick(_txtTranslate);
            }
        });
    }

    private void clearTranslateLayout() {
        _layTransImages.removeAllViews();
    }
}
