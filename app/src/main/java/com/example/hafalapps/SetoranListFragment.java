package com.example.hafalapps;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.hafalapps.adapters.AdapterSetoranlist;
import com.example.hafalapps.models.ModelPenilaian;
import com.example.hafalapps.models.ModelSetoranlist;
import com.example.hafalapps.models.ModelSetoran;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SetoranListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SetoranListFragment extends Fragment {

    //firebase auth
    FirebaseAuth firebaseAuth;
    RecyclerView recyclerView;
    List<ModelSetoranlist> setoranlistList;
    List<ModelSetoran> userList;
    DatabaseReference reference;
    FirebaseUser currentUser;
    AdapterSetoranlist adapterSetoranlist;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SetoranListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SetoranListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SetoranListFragment newInstance(String param1, String param2) {
        SetoranListFragment fragment = new SetoranListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setoran_list, container, false);

        //init
        firebaseAuth = FirebaseAuth.getInstance();
        currentUser = FirebaseAuth.getInstance().getCurrentUser();

        recyclerView = view.findViewById(R.id.recyclerView);

        setoranlistList = new ArrayList<>();

        reference = FirebaseDatabase.getInstance().getReference("Setoranlist").child(currentUser.getUid());
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                setoranlistList.clear();
                for (DataSnapshot ds: dataSnapshot.getChildren()){
                    ModelSetoranlist setoranlist = ds.getValue(ModelSetoranlist.class);
                    setoranlistList.add(setoranlist);
                }
                loadSetoran();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return view;
    }

    private void loadSetoran() {
        userList = new ArrayList<>();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                userList.clear();
                for (DataSnapshot ds: dataSnapshot.getChildren()){
                    ModelSetoran user = ds.getValue(ModelSetoran.class);
                    for (ModelSetoranlist setoranlist: setoranlistList){
                        if (user.getUid() !=null && user.getUid().equals(setoranlist.getId())){
                            userList.add(user);
                            break;
                        }
                    }
                    //adapter
                    adapterSetoranlist = new AdapterSetoranlist(getContext(), userList);
                    //set adapter
                    recyclerView.setAdapter(adapterSetoranlist);
                    //set last message
                    for (int i=0; i<userList.size(); i++){
                        lastMessage(userList.get(i).getUid());
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void lastMessage(final String userId) {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Setoran");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String theLastMessage = "default";
                for (DataSnapshot ds: dataSnapshot.getChildren()){
                    ModelPenilaian setoran = ds.getValue(ModelPenilaian.class);
                    if (setoran==null){
                        continue;
                    }
                    String sender = setoran.getSender();
                    String receiver = setoran.getReceiver();
                    if (sender == null || receiver == null){
                        continue;
                    }
                    if (setoran.getReceiver().equals(currentUser.getUid()) &&
                            setoran.getSender().equals(userId) ||
                    setoran.getReceiver().equals(userId) &&
                    setoran.getSender().equals(currentUser.getUid())){
                        theLastMessage = setoran.getMessage();
                    }
                }
                adapterSetoranlist.setLastMessageMap(userId, theLastMessage);
                adapterSetoranlist.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void checkUserStatus() {
        //get current user
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null) {
            //user is signed in stay here
            //set email of logged in user
            //mProfileTv.setText(user.getEmail());
            //save uid of currently signed in user in shared preferences
        } else {
            //user not signed in,go to main activity
            startActivity(new Intent(getActivity(), MainActivity.class));
            getActivity().finish();
        }
    }



    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //get item id
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            firebaseAuth.signOut();
            checkUserStatus();
        }

        return super.onOptionsItemSelected(item);
    }

}