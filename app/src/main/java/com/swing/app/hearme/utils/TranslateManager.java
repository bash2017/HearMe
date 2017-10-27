package com.swing.app.hearme.utils;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.swing.app.hearme.R;

import java.util.ArrayList;

/**
 * Created by swing on 10/24/17.
 */

public class TranslateManager {
    private DatabaseReference mDataBase;
    private Context _context;
    private LinearLayout _llTranslatePics;

    public TranslateManager(Context context, LinearLayout llTranslatePics) {
        _context = context;
        _llTranslatePics = llTranslatePics;
        mDataBase = FirebaseDatabase.getInstance().getReference().child("images");
    }

    public void getTranslation(String text) {
        String[] words = text.split(" ");
        for (String word : words) {
            ArrayList<ImageView> array = this.findWorld(word);
            try {
                if (array.size() > 0) {
                    Log.i("swgA", "Entramos");
                    for (int i = 0; i < array.size(); i++) {
                        Log.i("swg", String.valueOf(i + "aaaa"));
                        _llTranslatePics.addView(array.get(i));
                    }
                }else{
                    Log.i("no","Entramos");
                }
            } catch (Exception e) {
                Log.e("swg", e.getMessage());
            }

        }
    }

    private ArrayList<ImageView> findWorld(String world) {
        ArrayList<ImageView> arrayImages = new ArrayList<>();
        DatabaseReference fireData = mDataBase.child(world);
        try {
            if (fireData != null) {
                fireData.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot != null && dataSnapshot.child("count").getValue() != null) {
                            int images = dataSnapshot.child("count").getValue(Integer.class);
                            Log.i("swg", String.valueOf(images));
                            String url = String.valueOf(dataSnapshot.child("url1").getValue());
                            Log.i("swg", url);
                            /*for(int i=0; i < images; i++){
                                String str = "url" + String.valueOf(i);
                                String url = dataSnapshot.child(str).getValue().toString();
                                Log.i("swg", url);
                            }*/
                        } else {
                            Log.i("swg", "no, entramos1");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        } catch (Exception e) {
            Log.i("swg", e.getMessage());
        }
        /*ArrayList<ImageView> images = new ArrayList<>();
        if(word.equals("hola")){
            ImageView newImage = new ImageView(_context);
            newImage.setBackgroundResource(R.drawable.a);
            images.add(newImage);
        }*/
        return arrayImages;
    }

    /*private ArrayList<ImageView> findWorld(String word){
        ArrayList<ImageView> images = new ArrayList<>();
        if(word.equals("hola")){
            ImageView newImage = new ImageView(_context);
            newImage.setBackgroundResource(R.drawable.a);
            images.add(newImage);
        }
        return images;
    }*/
}
