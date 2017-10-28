package com.swing.app.hearme.utils;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;
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
            Task dbTask = executeTaskFinder(word);
            dbTask.addOnSuccessListener(new OnSuccessListener<ArrayList<View>>() {
                @Override
                public void onSuccess(ArrayList<View> arrayImages) {
                    if (arrayImages != null) {
                        for (int i = 0; i < arrayImages.size(); i++) {
                            _llTranslatePics.addView(arrayImages.get(i));
                            LayoutInflater inflater = LayoutInflater.from(_context);
                        }
                    }
                }
            });
        }
    }


    private Task executeTaskFinder(final String world) {
        final TaskCompletionSource<ArrayList<View>> dbSource = new TaskCompletionSource<>();
        Task dbTask = dbSource.getTask();

        final ArrayList<View> imagesArray = new ArrayList<>();
        DatabaseReference fireData = mDataBase.child(world);
        try {
            if (fireData != null) {
                fireData.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            int i = 1;
                            for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                                LayoutInflater vi = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                                View v = vi.inflate(R.layout.scustom_view, null);

                                TextView textView = (TextView) v.findViewById(R.id.txtCustomView);
                                ImageView imageView = (ImageView) v.findViewById(R.id.imgCustomView);

                                Picasso.with(_context).load(String.valueOf(postSnapshot.getValue())).into(imageView);
                                textView.setText(world + "(" + String.valueOf(i++) + ")");
                                v.setLayoutParams(new LinearLayout.LayoutParams(
                                        650,
                                        650));
                                imagesArray.add(v);
                            }
                            dbSource.setResult(imagesArray);
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
