package com.swing.app.hearme.tabs;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.swing.app.hearme.R;

public class TabLetras extends Fragment {

    private View _view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        _view = inflater.inflate(R.layout.activity_tab_letras, container, false);
        return _view;
    }
}
