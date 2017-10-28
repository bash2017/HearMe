package com.swing.app.hearme.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.swing.app.hearme.R;

/**
 * Created by swing on 10/27/17.
 */

public class SCustomView extends Fragment {
    private View _view;
    private ImageView _imgView;
    private TextView _txtView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        _view = inflater.inflate(R.layout.tab_phrases,container,false);
        _imgView = (ImageView) _view.findViewById(R.id.imgCustomView);
        _txtView = (TextView) _view.findViewById(R.id.txtCustomView);
        return _view;
    }

    private void setText(String texto){
        _txtView.setText(texto);
    }

    private ImageView setImageView(){
        return _imgView;
    }
}
