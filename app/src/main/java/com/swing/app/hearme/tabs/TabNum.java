package com.swing.app.hearme.tabs;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.swing.app.hearme.R;
import android.support.v4.app.Fragment;

public class TabNum extends Fragment {

    private View _view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        _view = inflater.inflate(R.layout.tab_num,container,false);
        return _view;
    }
}
