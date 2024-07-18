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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseError;
import com.google.firebase.Timestamp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.Source;
import com.google.firestore.v1.WriteResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    City city1 = new City();
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    DatabaseReference mDatabase;
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




        // ----------------------------Битта обектни олади---Source-----------------------------
//
//        DocumentReference docRef = db.collection("users").document("SF");
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


        // ------------------------Modul dan ma'lumot olish------------------------------------

        DocumentReference docRef2 = db.collection("users").document("SF");
        docRef2.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
//                City city = documentSnapshot.toObject(City.class);
//                Log.d("demo1", "City " + city.getState());
            }
        });

        // ----------------------------Битта обектни олади--------------------------------


//        db.collection("users").document("SF").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                if (task.isSuccessful()) {
//                    // Document found in the offline cache
//                    DocumentSnapshot document = task.getResult();
//
//
//
//                    if (document.exists()) {
//                        Map<String, Object> map = document.getData();
//                        List<String> list = (ArrayList<String>) document.get("gadin");
////                      ----------------Map ni ichki kalitini oladi -------------
//                        Log.d("demo1", " get(1) " + ((Map<String, Object>)map.get("work")).get("name"));
////                      ----------------Map ni ichki massivini oladi -------------
//                        Log.d("demo1", " get(2) " + ((Map<String, Object>)map.get("work")).get("gadin"));
////                      ----------------Map ni ichki massivini kalitini oladi -------------
//                        List<String> list2 = (ArrayList<String>) ((Map<String, Object>)map.get("work")).get("gadin");
//                        Log.d("demo1", " get(3) " + list2.get(1));
//
//
//                        for (Map.Entry<String, Object> entry : map.entrySet()) {
//                            if (entry.getKey().equals("work")) {
//
////                                Log.d("demo1", " get(1) " + ((Map<String, Object>)map.get("work")).get("name"));
////                                Log.d("demo1", " getValue() " + entry.getValue().toString());//
////                                Log.d("demo1", " getKey() " + entry.getKey());
//                            }
//                            if (entry.getKey().trim().equals("region")) {
////                                Log.d("demo1", entry.getValue().toString());
////                                Log.d("demo1", " trim() " + entry.getValue());
//                            }
//                        }
//
////                        Log.d("demo1", "Cached document data: "+ list + document.getData());
//                    }
//
//                } else {
////                    Log.d("demo1", "Cached get failed: ", task.getException());
//                }
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

//        db.collection("users")
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
//
////                      ----------------Map ni kalitini oladi -------------
//
//                            Map<String, Object> map2 = doc.getData();
//                            Log.d("demo1", " get(map kalit) " + map2.get("work"));
//
////                      ----------------Map ni ichki kalitini oladi -------------
//                            Map<String, Object> map3 = (Map<String, Object>) doc.getData().get("work");
//                            Map<String, Object> map5 = (Map<String, Object>) doc.getData().get("work");
//                            Map<String, Object> map4 = (Map<String, Object>) doc.getData().get("1");
//                            Log.d("demo1", " get(map ichki kalit) " + map3.get("id"));
//                            Log.d("demo1", " get(map5) " + map5.get("gadin"));
//
//                            if (map2 != null) {
////                                cities.add((String) map5.get("gadin"));
//                                cities.add((String) map4.get("id"));
//                            }
//
//
//
////                            if (doc.get("work") != null) {
////                                cities.add(doc.getString("id"));
////                            }
//                        }
//                        Log.d("demo1", "Current cites in CA: " + cities);
//                    }
//                });

        // --------------------state=CA bo'lsa shu obekt olinyapti----------------------------------------

        db.collection("users")
                .whereEqualTo("1.old", "2")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot snapshots,
                                        @Nullable FirebaseFirestoreException e) {
                        if (e != null) {
                            Log.w("demo1", "listen:error", e);
                            return;
                        }

                        Log.d("demo1", "New city: " );
                        for (DocumentChange dc : snapshots.getDocumentChanges()) {
                            switch (dc.getType()) {
                                case ADDED:
                                    Log.d("demo1", "New city: " + dc.getDocument().getData());
                                    break;
                                case MODIFIED:
                                    Log.d("demo1", "Modified city: " + dc.getDocument().getData());
                                    break;
                                case REMOVED:
                                    Log.d("demo1", "Removed city: " + dc.getDocument().getData());
                                    break;
                            }
                        }

                    }
                });
        //

        // -------------------Жамисини capital-true ларини тортиб берди----------------------------------------

//        db.collection("users")
//                .whereEqualTo("1.capital", true)
//                .get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        if (task.isSuccessful()) {
//                            for (QueryDocumentSnapshot document : task.getResult()) {
//
//                              //  ----------------Map ni ichki kalitini oladi -------------
//                                Map<String, Object> map2 = document.getData();
//                                Log.d("demo1", " get(map2) " + ((Map<String, Object>)map2.get("work")).get("id"));
//
//                                Log.d("demo1", document.getId() + " => " + document.getData());
//                            }
//                        } else {
//                            Log.d("demo1", "Error getting documents: ", task.getException());
//                        }
//                    }
//                });
        // ------------------------------------------------------------

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
        // --------------------objectExample", nestedData  ёзиш ----------------------------------------

//        Map<String, Object> docData = new HashMap<>();
//        docData.put("stringExample", "Hello world!");
//        docData.put("booleanExample", true);
//        docData.put("numberExample", 3.14159265);
//        docData.put("dateExample", new Timestamp(new Date()));
//        docData.put("listExample", Arrays.asList(1, 2, 3));
//        docData.put("nullExample", null);
//
//        Map<String, Object> nestedData = new HashMap<>();
//        nestedData.put("a", 5);
//        nestedData.put("b", true);
//
//        docData.put("objectExample", nestedData);
//
//        db.collection("data").document("one")
//                .set(docData)
//                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void aVoid) {
//                        Log.d("demo1", "DocumentSnapshot successfully written!");
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.w("demo1", "Error writing document", e);
//                    }
//                });


        // ---------------------------Modulga yuborish--Yozish-------------------------------
//        City city = new City("Los Angeles", "CA", "USA",
//                false, 5000000L, Arrays.asList("west_coast", "sorcal"));
//        db.collection("citie").document("LA").set(city);



        // -------------------Stringni kalitga aylantirish---add bilan-yozish-------------------------------------
//        db.collection("cities").document("new-city-id").set(data);
//        Map<String, Object> data = new HashMap<>();
//        data.put("name", "Tokyo");
//        data.put("country", "Japan");
//
//        db.collection("citie")
//                .add(data)
//                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                    @Override
//                    public void onSuccess(DocumentReference documentReference) {
//                        Log.d(TAG, "DocumentSnapshot written with ID: " + documentReference.getId());
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.w(TAG, "Error adding document", e);
//                    }
//                });

        // -------------------------ichki obekt yasash--kerekli---------------------------------

//        db.collection("users").document("frank")
//                .update(
//                        "age", 13,
//                        "favorites.color", "Red",
//                        "favorites.name", "Blue",
//                        "4.3.name", "Black",
//                        "4.3.age", "36",
//                        "4.4.age", "37"
//                );
        // ------------------------------------------------------------

        // --------------------Realtime get in----------------------------------------
//        mDatabase = FirebaseDatabase.getInstance().getReference();
//        mDatabase.child("work").child("id").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DataSnapshot> task) {
//                if (!task.isSuccessful()) {
//                    Log.d("demo1", "Error getting data", task.getException());
//                }
//                else {
//                    Log.d("demo1", String.valueOf(task.getResult().getValue()));
//                }
//            }
//        });


        // ------------------------------------------------------------

        CollectionReference citiesRef = db.collection("cities");
//
//        citiesRef.whereArrayContains("regions", "west_coast");    // -----------------жами документда  -arreyda regions west_coast  бўлганларни олади---
//        Query stateQuery = citiesRef.whereEqualTo("state", "CA");
//        Query populationQuery = citiesRef.whereLessThan("population", 100000);
//        Query nameQuery = citiesRef.whereGreaterThanOrEqualTo("name", "San Francisco");
//        Query notCapitalQuery = citiesRef.whereNotEqualTo("capital", false); // -----------------жами документда  -capital--false бўлганларни олади---
//        citiesRef.whereIn("country", Arrays.asList("China", "Japan"));  // -----------------жами документда  -country--"China", "Japan" бўлганларни олади--------------------------------
//        citiesRef.whereArrayContainsAny("regions", Arrays.asList("west_coast", "east_coast")); // -----------------жами документда  -Arrays--"west_coast", "east_coast" бўлганларни олади------------------------------
//        citiesRef.whereIn("regions", Arrays.asList(new String[]{"west_coast"}, new String[]{"east_coast"}))
//
//        citiesRef.whereEqualTo("state", "CA").whereLessThan("population", 1000000);
//        citiesRef.whereEqualTo("state", "CA").whereEqualTo("name", "Tokyo"); // -----------------жами документда  -state-CA va- name - Tokyo бўлганларни олади--------------------------------
//        citiesRef.orderBy("id");

//        db.collection("users") .orderBy("user")  // ------------ user qatnashdan xamma document olindi


        db.collection("users")
                .orderBy("transctions")

       .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {



                                Log.d("demo1", document.getId() + " => " + document.getData());

                                ArrayList<String> nextArrayList = new ArrayList<>();

                                List transactions = (List) document.get("transctions");
                                for (Object transaction: transactions) {
                                    Map values = (Map)transaction;
                                    City city = document.toObject(City.class);
                                    Log.d("demo1", "City " + city.getAmaut());

                                    nextArrayList.add((String) values.get("amaunt"));
                                    Log.d("demo1", "Map values " +  values);
                                    Log.d("demo1", "map1 " + (String) values.get("amaunt"));
                                    Log.d("demo1", "amaut " + values.toString());
//                                    System.out.println(values.get("amount");
                                }
                                Log.d("demo1", String.valueOf(nextArrayList));
//
                            }
                        } else {
                            Log.d("demo1", "Error getting documents: ", task.getException());
                        }
                    }
                });


        // ---------------------------Massiv---------------------------------


        DocumentReference washingtonRef = db.collection("cities").document("DC");

// Atomically add a new region to the "regions" array field.
        washingtonRef.update("regions", FieldValue.arrayUnion("greater_virginia1"));
        washingtonRef.update("regions", FieldValue.arrayUnion("greater_virginia2"));

// Atomically remove a region from the "regions" array field.
        washingtonRef.update("regions", FieldValue.arrayRemove("east_coast"));
//        washingtonRef.update("regions", FieldValue.delete());



        // -----------------------Ko'paytirish bo'lish qo'shish amallarini bajaradi-------------------------------------

//        DocumentReference washingtonRef = db.collection("cities").document("DC");

// Atomically increment the population of the city by 50.
        washingtonRef.update("population", FieldValue.increment(6 / 2));


        // ------------------------------------------------------------
        // ------------------------------------------------------------
        // ------------------------------------------------------------
        // ------------------------------------------------------------





//        CollectionReference cities = db.collection("cities");
//
//        Map<String, Object> data1 = new HashMap<>();
//        data1.put("name", "San Francisco");
//        data1.put("state", "CA");
//        data1.put("country", "USA");
//        data1.put("capital", false);
//        data1.put("population", 860000);
//        data1.put("regions", Arrays.asList("west_coast", "norcal"));
//        cities.document("SF").set(data1);
//
//        Map<String, Object> data2 = new HashMap<>();
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



//
//        CollectionReference cities = db.collection("cities");
//
//        Map<String, Object> data1 = new HashMap<>();
//        data1.put("name", "San Francisco");
//        data1.put("state", "CA");
//        data1.put("country", "USA");
//        data1.put("capital", false);
//        data1.put("population", 860000);
//        data1.put("regions", Arrays.asList("west_coast", "norcal"));
//        cities.document("SF").set(data1);
//
//        Map<String, Object> data2 = new HashMap<>();
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