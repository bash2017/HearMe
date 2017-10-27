package com.swing.app.hearme.tabs;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.swing.app.hearme.R;

/**
 * Created by swing on 10/27/17.
 */

public class TabPhrases extends Fragment{
    private View _view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        _view = inflater.inflate(R.layout.tab_phrases,container,false);
        //_txtNuevaPass.setText(this.getArguments().getString("pass"));
        return _view;
    }
}
