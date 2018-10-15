package comsdlminiproject.httpsgithub.ppms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DataRetrieved extends AppCompatActivity
{

    private ListView listView;
    DatabaseReference dbRef;
    List<PetPumpDB>petPumpDBList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_retrieved);

        listView = findViewById(R.id.activity_list_view_xml);

        dbRef = FirebaseDatabase.getInstance().getReference("Daily Details");

        petPumpDBList = new ArrayList<>();

    }

    @Override
    protected void onStart() {
        super.onStart();
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                for(DataSnapshot petPumpSnapshot : dataSnapshot.getChildren())
                {
                    PetPumpDB petPumpObj = petPumpSnapshot.getValue(PetPumpDB.class);
                    petPumpDBList.add(petPumpObj);
                }
                PetPumpAdapter petPumpAdapter = new PetPumpAdapter(DataRetrieved.this,petPumpDBList);
                listView.setAdapter(petPumpAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
