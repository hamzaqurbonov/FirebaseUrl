package com.example.firebaseurl;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.Source;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {


    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference cities = db.collection("cities");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_example);


        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        String[] videoIds = {"qmjupP2QfUI", "prnPXVsjBaU", "GTWCWJt-YJI", "K0FLHvxKgzA", "8cCSKkrmOek", "co_NSujPyN4", "xyqdZAagHa4", "eW9PIzfK064"};

        RecyclerView.Adapter recyclerViewAdapter = new RecyclerViewAdapter(videoIds, this.getLifecycle());
        recyclerView.setAdapter(recyclerViewAdapter);




        // ----------------------------Битта обектни олади--------------------------------

//        DocumentReference docRef = db.collection("cities").document("SF");
////
//// Source can be CACHE, SERVER, or DEFAULT.
//        Source source = Source.CACHE;
//
//// Get the document, forcing the SDK to use the offline cache
//        docRef.get(source).addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                if (task.isSuccessful()) {
//                    // Document found in the offline cache
//                    DocumentSnapshot document = task.getResult();
//                    Log.d("demo1", "Cached document data: " + document.getData());
//                } else {
//                    Log.d("demo1", "Cached get failed: ", task.getException());
//                }
//            }
//        });




        // ------------------------------------------------------------

//        DocumentReference docRef2 = db.collection("cities").document("BJ");
//        docRef2.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//            @Override
//            public void onSuccess(DocumentSnapshot documentSnapshot) {
////                City city = documentSnapshot.toObject(City.class);
//            }
//        });



        // -------------------------Hamma obekt ichida aylanadi-----Faqt true lar------------------------------

//        db.collection("cities")
//                .whereEqualTo("capital", true)
//                .get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        if (task.isSuccessful()) {
//                            for (QueryDocumentSnapshot document : task.getResult()) {
//                                Log.d("demo1", document.getId() + " => " + document.getData());
//                            }
//                        } else {
//                            Log.d("demo1", "Error getting documents: ", task.getException());
//                        }
//                    }
//                });




        // ---------------------------Hamma obekt ichida aylanadi----------------------------------
//        db.collection("cities")
//                .get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        if (task.isSuccessful()) {
//                            for (QueryDocumentSnapshot document : task.getResult()) {
//                                Log.d("demo1", document.getId() + " => " + document.getData());
//                            }
//                        } else {
//                            Log.d("demo1", "Error getting documents: ", task.getException());
//                        }
//                    }
//                });


        // ----------------------Янги collection яратиш--------------------------------------

//        db.collection("cities")
//                .document("SF")
//                .collection("landmarks")
//                .get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        if (task.isSuccessful()) {
//                            for (QueryDocumentSnapshot document : task.getResult()) {
//                                Log.d("demo1", document.getId() + " => " + document.getData());
//                            }
//                        } else {
//                            Log.d("demo1", "Error getting documents: ", task.getException());
//                        }
//                    }
//                });




        // ------------------------Kechikishlarni tekshiradi------------------------------------

//        final DocumentReference docRef = db.collection("cities").document("SF");
//        docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot snapshot,
//                                @Nullable FirebaseFirestoreException e) {
//                if (e != null) {
//                    Log.w("demo1", "Listen failed.", e);
//                    return;
//                }
//
//                if (snapshot != null && snapshot.exists()) {
//                    Log.d("demo1", "Current data: " + snapshot.getData());
//                } else {
//                    Log.d("demo1", "Current data: null");
//                }
//            }
//        });

        // ----------------------state=CA bo'lsa shu kalitni massivga aylantirayapti--------------------------------------

//        db.collection("cities")
//                .whereEqualTo("state", "CA")
//                .addSnapshotListener(new EventListener<QuerySnapshot>() {
//                    @Override
//                    public void onEvent(@Nullable QuerySnapshot value,
//                                        @Nullable FirebaseFirestoreException e) {
//                        if (e != null) {
//                            Log.w("demo1", "Listen failed.", e);
//                            return;
//                        }
//
//                        List<String> cities = new ArrayList<>();
//                        for (QueryDocumentSnapshot doc : value) {
//                            if (doc.get("name") != null) {
//                                cities.add(doc.getString("name"));
//                            }
//                        }
//                        Log.d("demo1", "Current cites in CA: " + cities);
//                    }
//                });

        // --------------------state=CA bo'lsa shu obekt olinyapti----------------------------------------

//        db.collection("cities")
//                .whereEqualTo("state", "CA")
//                .addSnapshotListener(new EventListener<QuerySnapshot>() {
//                    @Override
//                    public void onEvent(@Nullable QuerySnapshot snapshots,
//                                        @Nullable FirebaseFirestoreException e) {
//                        if (e != null) {
//                            Log.w("demo1", "listen:error", e);
//                            return;
//                        }
//
//                        for (DocumentChange dc : snapshots.getDocumentChanges()) {
//                            switch (dc.getType()) {
//                                case ADDED:
//                                    Log.d("demo1", "New city: " + dc.getDocument().getData());
//                                    break;
//                                case MODIFIED:
//                                    Log.d("demo1", "Modified city: " + dc.getDocument().getData());
//                                    break;
//                                case REMOVED:
//                                    Log.d("demo1", "Removed city: " + dc.getDocument().getData());
//                                    break;
//                            }
//                        }
//
//                    }
//                });
        //

        // ------------------------------------------------------------

        db.collection("cities")
                .whereEqualTo("capital", true)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("demo1", document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.d("demo1", "Error getting documents: ", task.getException());
                        }
                    }
                });
        // ------------------------------------------------------------
        // ------------------------------------------------------------
        // ------------------------------------------------------------
        // ------------------------------------------------------------
        // ------------------------------------------------------------
        // ------------------------------------------------------------


        CollectionReference cities = db.collection("cities");

        Map<String, Object> data1 = new HashMap<>();
        data1.put("name", "San Francisco");
        data1.put("state", "CA");
        data1.put("country", "USA");
        data1.put("capital", false);
        data1.put("population", 860000);
        data1.put("regions", Arrays.asList("west_coast", "norcal"));
        cities.document("SF").set(data1);

        Map<String, Object> data2 = new HashMap<>();
        data2.put("name", "Los Angeles");
        data2.put("state", "CA");
        data2.put("country", "USA");
        data2.put("capital", false);
        data2.put("population", 3900000);
        data2.put("regions", Arrays.asList("west_coast", "socal"));
        cities.document("LA").set(data2);

        Map<String, Object> data3 = new HashMap<>();
        data3.put("name", "Washington D.C.");
        data3.put("state", null);
        data3.put("country", "USA");
        data3.put("capital", true);
        data3.put("population", 680000);
        data3.put("regions", Arrays.asList("east_coast"));
        cities.document("DC").set(data3);

        Map<String, Object> data4 = new HashMap<>();
        data4.put("name", "Tokyo");
        data4.put("state", null);
        data4.put("country", "Japan");
        data4.put("capital", true);
        data4.put("population", 9000000);
        data4.put("regions", Arrays.asList("kanto", "honshu"));
        cities.document("TOK").set(data4);

        Map<String, Object> data5 = new HashMap<>();
        data5.put("name", "Beijing");
        data5.put("state", null);
        data5.put("country", "China");
        data5.put("capital", true);
        data5.put("population", 21500000);
        data5.put("regions", Arrays.asList("jingjinji", "hebei"));
        cities.document("BJ").set(data5);





//        CollectionReference citiesRef = db.collection("cities");
//
//        Map<String, Object> ggbData = new HashMap<>();
//        ggbData.put("name", "Golden Gate Bridge");
//        ggbData.put("type", "bridge");
//        citiesRef.document("SF").collection("landmarks").add(ggbData);
//
//        Map<String, Object> lohData = new HashMap<>();
//        lohData.put("name", "Legion of Honor");
//        lohData.put("type", "museum");
//        citiesRef.document("SF").collection("landmarks").add(lohData);
//
//        Map<String, Object> gpData = new HashMap<>();
//        gpData.put("name", "Griffith Park");
//        gpData.put("type", "park");
//        citiesRef.document("LA").collection("landmarks").add(gpData);
//
//        Map<String, Object> tgData = new HashMap<>();
//        tgData.put("name", "The Getty");
//        tgData.put("type", "museum");
//        citiesRef.document("LA").collection("landmarks").add(tgData);
//
//        Map<String, Object> lmData = new HashMap<>();
//        lmData.put("name", "Lincoln Memorial");
//        lmData.put("type", "memorial");
//        citiesRef.document("DC").collection("landmarks").add(lmData);
//
//        Map<String, Object> nasaData = new HashMap<>();
//        nasaData.put("name", "National Air and Space Museum");
//        nasaData.put("type", "museum");
//        citiesRef.document("DC").collection("landmarks").add(nasaData);
//
//        Map<String, Object> upData = new HashMap<>();
//        upData.put("name", "Ueno Park");
//        upData.put("type", "park");
//        citiesRef.document("TOK").collection("landmarks").add(upData);
//
//        Map<String, Object> nmData = new HashMap<>();
//        nmData.put("name", "National Museum of Nature and Science");
//        nmData.put("type", "museum");
//        citiesRef.document("TOK").collection("landmarks").add(nmData);
//
//        Map<String, Object> jpData = new HashMap<>();
//        jpData.put("name", "Jingshan Park");
//        jpData.put("type", "park");
//        citiesRef.document("BJ").collection("landmarks").add(jpData);
//
//        Map<String, Object> baoData = new HashMap<>();
//        baoData.put("name", "Beijing Ancient Observatory");
//        baoData.put("type", "museum");
//        citiesRef.document("BJ").collection("landmarks").add(baoData);

    }

}
//    Map<String, Object> data1 = new HashMap<>();
//        data1.put("name", "San Francisco");
//                data1.put("state", "CA");
//                data1.put("country", "USA");
//                data1.put("capital", false);
//                data1.put("population", 860000);
//                data1.put("regions", Arrays.asList("west_coast", "norcal"));
//                cities.document("SF").set(data1);
//
//                Map<String, Object> data2 = new HashMap<>();
//        data2.put("name", "Los Angeles");
//        data2.put("state", "CA");
//        data2.put("country", "USA");
//        data2.put("capital", false);
//        data2.put("population", 3900000);
//        data2.put("regions", Arrays.asList("west_coast", "socal"));
//        cities.document("LA").set(data2);
//
//        Map<String, Object> data3 = new HashMap<>();
//        data3.put("name", "Washington D.C.");
//        data3.put("state", null);
//        data3.put("country", "USA");
//        data3.put("capital", true);
//        data3.put("population", 680000);
//        data3.put("regions", Arrays.asList("east_coast"));
//        cities.document("DC").set(data3);
//
//        Map<String, Object> data4 = new HashMap<>();
//        data4.put("name", "Tokyo");
//        data4.put("state", null);
//        data4.put("country", "Japan");
//        data4.put("capital", true);
//        data4.put("population", 9000000);
//        data4.put("regions", Arrays.asList("kanto", "honshu"));
//        cities.document("TOK").set(data4);
//
//        Map<String, Object> data5 = new HashMap<>();
//        data5.put("name", "Beijing");
//        data5.put("state", null);
//        data5.put("country", "China");
//        data5.put("capital", true);
//        data5.put("population", 21500000);
//        data5.put("regions", Arrays.asList("jingjinji", "hebei"));
//        cities.document("BJ").set(data5);