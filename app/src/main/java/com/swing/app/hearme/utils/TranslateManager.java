package com.swing.app.hearme.utils;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

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
            Task dbTask = executeTaskFinder(word);
            dbTask.addOnSuccessListener(new OnSuccessListener<ArrayList<ImageView>>() {
                @Override
                public void onSuccess(ArrayList<ImageView> arrayImages) {
                    if (arrayImages != null) {
                        for (int i = 0; i < arrayImages.size(); i++) {
                            _llTranslatePics.addView(arrayImages.get(i));
                        }
                    }
                }
            });
        }
    }


    private Task executeTaskFinder(final String world) {
        final TaskCompletionSource<ArrayList<ImageView>> dbSource = new TaskCompletionSource<>();
        Task dbTask = dbSource.getTask();

        final ArrayList<ImageView> imagesArray = new ArrayList<>();
        DatabaseReference fireData = mDataBase.child(world);
        try {
            if (fireData != null) {
                fireData.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(500, 600);
                            for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                                ImageView newImage = new ImageView(_context);
                                Picasso.with(_context).load(String.valueOf(postSnapshot.getValue())).into(newImage);
                                newImage.setLayoutParams(layoutParams);
                                imagesArray.add(newImage);
                            }
                            dbSource.setResult(imagesArray);
                        }else{
                            for (int i=0; i < world.length(); i++){

                            }
                            //String[] letters = world.getChars(2, 9, Str2, 0);
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        } catch (Exception e) {
            Log.i("swg Error", e.getMessage());
        }
        return dbTask;
    }
}
