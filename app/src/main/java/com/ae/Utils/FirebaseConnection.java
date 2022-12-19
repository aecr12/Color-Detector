package com.ae.Utils;


import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class FirebaseConnection {
    ArrayList<String> nameList = new ArrayList<>();
    ArrayList<String> hexList = new ArrayList<>();

    Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            DatabaseReference databaseReference;
            databaseReference = FirebaseDatabase.getInstance().getReference();

            databaseReference.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    if (!task.isSuccessful()) {
                        Log.e("firebase", "Error getting data", task.getException());
                    } else {
                        //Log.d("firebase", String.valueOf(task.getResult().getValue()));

                        DataSnapshot snapshot = task.getResult();

                        for (int i = 0; i < snapshot.getChildrenCount(); i++) {
                            // System.out.println(snapshot.child(String.valueOf(i)).getValue());
                            HashMap<String,String> colorsHashMap = (HashMap<String, String>) snapshot.child(String.valueOf(i)).getValue();
                            nameList.add(colorsHashMap.get("name"));
                            hexList.add(colorsHashMap.get("hex"));
                        }
                    }
                }
            });

        }
    });

    public Thread getThread() {
        return thread;
    }

    public ArrayList<String> getNameList() {
        return nameList;
    }

    public ArrayList<String> getHexList() {
        return hexList;
    }


}


