package com.swing.app.hearme.tabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.swing.app.hearme.AdvancedActivity;
import com.swing.app.hearme.BasicActivity;
import com.swing.app.hearme.MediumActivity;
import com.swing.app.hearme.R;

/**
 * Created by kuroi on 27/10/2017.
 */

public class TabAcademy extends Fragment {

    private View _view;
    Button btnBasic, btnMedium, btnAdvanced;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        _view = inflater.inflate(R.layout.tab_academy,container,false);

        setControls();
        setEvents();


        return _view;
    }

    private void setControls(){
        btnBasic = (Button)(_view.findViewById(R.id.btnBasico));
        btnMedium = (Button)(_view.findViewById(R.id.btnMedio));
        btnAdvanced = (Button)(_view.findViewById(R.id.btnAvanzado));
    }

    private void setEvents(){
        btnBasic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(_view.getContext(), BasicActivity.class);
                startActivity(intent);
            }
        });

        btnMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(_view.getContext(), MediumActivity.class);
                startActivity(intent);
            }
        });

        btnAdvanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(_view.getContext(), AdvancedActivity.class);
                startActivity(intent);
            }
        });
    }
}
