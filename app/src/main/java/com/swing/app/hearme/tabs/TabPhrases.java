package com.swing.app.hearme.tabs;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.swing.app.hearme.R;

/**
 * Created by swing on 10/27/17.
 */

public class TabPhrases extends Fragment{
    private View _view;
    private Button _btnBuenosDias, _btnBuenasTardes, _btnHola, _btnAdios, _btnGusto;
    private LinearLayout _llImagenes;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        _view = inflater.inflate(R.layout.tab_phrases,container,false);
        //_txtNuevaPass.setText(this.getArguments().getString("pass"));
        cargarControles();
        cargarEventos();
        return _view;
    }

    private void cargarControles(){
        _btnBuenosDias = (Button)(_view.findViewById(R.id.btnBuenosDias));
        _btnBuenasTardes = (Button)(_view.findViewById(R.id.btnBuenosTardes));
        _btnHola = (Button)(_view.findViewById(R.id.btnHola));
        _btnAdios = (Button)(_view.findViewById(R.id.btnAdios));
        _btnGusto = (Button)(_view.findViewById(R.id.btnGusto));
        _llImagenes = (LinearLayout)(_view.findViewById(R.id.llFrases));
    }

    private void cargarEventos(){
        _btnBuenosDias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambiarFotos("buenos_dias");
            }
        });

        _btnBuenasTardes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambiarFotos("buenos_tardes");
            }
        });

        _btnHola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambiarFotos("hola");
            }
        });

        _btnAdios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambiarFotos("adios");
            }
        });

        _btnGusto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambiarFotos("gusto");
            }
        });
    }

    private void cambiarFotos(String boton){
        _llImagenes.removeAllViews();
        int width = 650, heigth = 650;
        switch (boton){
            case "buenos_dias":
                LayoutInflater vi = (LayoutInflater) _view.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View v = vi.inflate(R.layout.scustom_view, null);

                TextView textView = (TextView) v.findViewById(R.id.txtCustomView);
                ImageView imageView = (ImageView) v.findViewById(R.id.imgCustomView);
                //imageView.setBackground(getResources().getDrawable(R.drawable.buenos_dias1));
                Picasso.with(getContext()).load(R.drawable.buenos_dias1).into(imageView);

                textView.setText("Buenos dias (1)");
                v.setLayoutParams(new LinearLayout.LayoutParams(
                        width,
                        heigth));
                _llImagenes.addView(v);

                v = vi.inflate(R.layout.scustom_view, null);

                textView = (TextView) v.findViewById(R.id.txtCustomView);
                imageView = (ImageView) v.findViewById(R.id.imgCustomView);
                //imageView.setBackground(getResources().getDrawable(R.drawable.buenos_dias2));
                Picasso.with(getContext()).load(R.drawable.buenos_dias2).into(imageView);

                textView.setText("Buenos dias (2)");
                v.setLayoutParams(new LinearLayout.LayoutParams(
                        width,
                        heigth));
                _llImagenes.addView(v);

                v = vi.inflate(R.layout.scustom_view, null);

                textView = (TextView) v.findViewById(R.id.txtCustomView);
                imageView = (ImageView) v.findViewById(R.id.imgCustomView);
                //imageView.setBackground(getResources().getDrawable(R.drawable.buenos_dias3));
                Picasso.with(getContext()).load(R.drawable.buenos_dias3).into(imageView);

                textView.setText("Buenos dias (3)");
                v.setLayoutParams(new LinearLayout.LayoutParams(
                        width,
                        heigth));
                _llImagenes.addView(v);

                v = vi.inflate(R.layout.scustom_view, null);

                textView = (TextView) v.findViewById(R.id.txtCustomView);
                imageView = (ImageView) v.findViewById(R.id.imgCustomView);
                //imageView.setBackground(getResources().getDrawable(R.drawable.buenos_dias4));
                Picasso.with(getContext()).load(R.drawable.buenos_dias4).into(imageView);

                textView.setText("Buenos dias (4)");
                v.setLayoutParams(new LinearLayout.LayoutParams(
                        width,
                        heigth));
                _llImagenes.addView(v);
                break;
            case "buenos_tardes":
                LayoutInflater vibt = (LayoutInflater) _view.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View vbt = vibt.inflate(R.layout.scustom_view, null);

                TextView textViewbt = (TextView) vbt.findViewById(R.id.txtCustomView);
                ImageView imageViewbt = (ImageView) vbt.findViewById(R.id.imgCustomView);
                //imageViewbt.setBackground(getResources().getDrawable(R.drawable.buenas_tardes1));
                Picasso.with(getContext()).load(R.drawable.buenas_tardes1).into(imageViewbt);

                textViewbt.setText("Buenos tardes (1)");
                vbt.setLayoutParams(new LinearLayout.LayoutParams(
                        width,
                        heigth));
                _llImagenes.addView(vbt);

                vibt = (LayoutInflater) _view.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                vbt = vibt.inflate(R.layout.scustom_view, null);

                textViewbt = (TextView) vbt.findViewById(R.id.txtCustomView);
                imageViewbt = (ImageView) vbt.findViewById(R.id.imgCustomView);
                //imageViewbt.setBackground(getResources().getDrawable(R.drawable.buenas_tardes2));
                Picasso.with(getContext()).load(R.drawable.buenas_tardes2).into(imageViewbt);

                textViewbt.setText("Buenos tardes (2)");
                vbt.setLayoutParams(new LinearLayout.LayoutParams(
                        width,
                        heigth));
                _llImagenes.addView(vbt);

                vibt = (LayoutInflater) _view.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                vbt = vibt.inflate(R.layout.scustom_view, null);

                textViewbt = (TextView) vbt.findViewById(R.id.txtCustomView);
                imageViewbt = (ImageView) vbt.findViewById(R.id.imgCustomView);
                //imageViewbt.setBackground(getResources().getDrawable(R.drawable.buenas_tardes3));
                Picasso.with(getContext()).load(R.drawable.buenas_tardes3).into(imageViewbt);

                textViewbt.setText("Buenos tardes (3)");
                vbt.setLayoutParams(new LinearLayout.LayoutParams(
                        width,
                        heigth));
                _llImagenes.addView(vbt);
                break;
            case "hola":
                LayoutInflater vih = (LayoutInflater) _view.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View vbh = vih.inflate(R.layout.scustom_view, null);

                TextView textViewh = (TextView) vbh.findViewById(R.id.txtCustomView);
                ImageView imageViewh = (ImageView) vbh.findViewById(R.id.imgCustomView);
                //imageViewh.setBackground(getResources().getDrawable(R.drawable.hola1));
                Picasso.with(getContext()).load(R.drawable.hola1).into(imageViewh);

                textViewh.setText("Hola (1)");
                vbh.setLayoutParams(new LinearLayout.LayoutParams(
                        width,
                        heigth));
                _llImagenes.addView(vbh);

                vih = (LayoutInflater) _view.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                vbh = vih.inflate(R.layout.scustom_view, null);

                textViewh = (TextView) vbh.findViewById(R.id.txtCustomView);
                imageViewh = (ImageView) vbh.findViewById(R.id.imgCustomView);
                //imageViewh.setBackground(getResources().getDrawable(R.drawable.hola2));
                Picasso.with(getContext()).load(R.drawable.hola2).into(imageViewh);

                textViewh.setText("Hola (2)");
                vbh.setLayoutParams(new LinearLayout.LayoutParams(
                        width,
                        heigth));
                _llImagenes.addView(vbh);
                break;
            case "adios":
                LayoutInflater via = (LayoutInflater) _view.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View vba = via.inflate(R.layout.scustom_view, null);

                TextView textViewa = (TextView) vba.findViewById(R.id.txtCustomView);
                ImageView imageViewa = (ImageView) vba.findViewById(R.id.imgCustomView);
                //imageViewa.setBackground(getResources().getDrawable(R.drawable.buenas_tardes1));
                Picasso.with(getContext()).load(R.drawable.buenas_tardes1).into(imageViewa);

                textViewa.setText("Adios");
                vba.setLayoutParams(new LinearLayout.LayoutParams(
                        width,
                        heigth));
                _llImagenes.addView(vba);
                break;
            case "gusto":
                LayoutInflater vig = (LayoutInflater) _view.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View vbg = vig.inflate(R.layout.scustom_view, null);

                TextView textViewg = (TextView) vbg.findViewById(R.id.txtCustomView);
                ImageView imageViewg = (ImageView) vbg.findViewById(R.id.imgCustomView);
                //imageViewg.setBackground(getResources().getDrawable(R.drawable.mucho));
                Picasso.with(getContext()).load(R.drawable.mucho).into(imageViewg);

                textViewg.setText("Mucho");
                vbg.setLayoutParams(new LinearLayout.LayoutParams(
                        width,
                        heigth));
                _llImagenes.addView(vbg);
                vig = (LayoutInflater) _view.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                vbg = vig.inflate(R.layout.scustom_view, null);

                textViewg = (TextView) vbg.findViewById(R.id.txtCustomView);
                imageViewg = (ImageView) vbg.findViewById(R.id.imgCustomView);
                //imageViewg.setBackground(getResources().getDrawable(R.drawable.gusto));
                Picasso.with(getContext()).load(R.drawable.gusto).into(imageViewg);

                textViewg.setText("Gusto");
                vbg.setLayoutParams(new LinearLayout.LayoutParams(
                        width,
                        heigth));
                _llImagenes.addView(vbg);
                break;
        }
    }
}