package com.example.hafalapps;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.hafalapps.SurahActivity.Al_LahabActivity;
import com.example.hafalapps.SurahActivity.AladiatActivity;
import com.example.hafalapps.SurahActivity.AlalaqActivity;
import com.example.hafalapps.SurahActivity.AlasrActivity;
import com.example.hafalapps.SurahActivity.AlbayyinahActivity;
import com.example.hafalapps.SurahActivity.AlfalaqActivity;
import com.example.hafalapps.SurahActivity.AlfilActivity;
import com.example.hafalapps.SurahActivity.AlhumazahActivity;
import com.example.hafalapps.SurahActivity.AlikhlasActivity;
import com.example.hafalapps.SurahActivity.AlkafirunActivity;
import com.example.hafalapps.SurahActivity.AlkautsarActivity;
import com.example.hafalapps.SurahActivity.AlmaunActivity;
import com.example.hafalapps.SurahActivity.AlqodrActivity;
import com.example.hafalapps.SurahActivity.AlqoriahActivity;
import com.example.hafalapps.SurahActivity.AlquraisyActivity;
import com.example.hafalapps.SurahActivity.AnnasActivity;
import com.example.hafalapps.SurahActivity.AnnasrActivity;
import com.example.hafalapps.SurahActivity.AttakasurActivity;
import com.example.hafalapps.SurahActivity.AttinActivity;
import com.example.hafalapps.SurahActivity.AzzalzalahActivity;
import com.example.hafalapps.SurahActivity.MurajaahActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MurajaahFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MurajaahFragment extends Fragment {

    Button satu1, dua2, tiga3, empat4, lima5, enam6, tujuh7, delapan8, sembilan9, sepuluh10,
           sebelas11, duabelas12, tigabelas13, empatbelas14, limabelas15, enambelas16, tujuhbelas17, delapanbelas18, sembilanbelas19,duapuluh20,
            duasatu21, duadua22, duatiga23, duaempat24, dualima25, duaenam26, duatujuh27, duadelapan28, duasembilan29, tigapuluh30 ;
    //firebase auth
    FirebaseAuth firebaseAuth;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MurajaahFragment() {
        // Required empty public constructor
    }



    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MurajaahFragment newInstance(String param1, String param2) {
        MurajaahFragment fragment = new MurajaahFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_murajaah, container, false);

        Button satu1 = (Button) view.findViewById(R.id.satu);
        Button dua2 = (Button) view.findViewById(R.id.dua);
        Button tiga3 = (Button) view.findViewById(R.id.tiga);
        Button empat4 = (Button) view.findViewById(R.id.empat);
        Button lima5 = (Button) view.findViewById(R.id.lima);
        Button enam6 = (Button) view.findViewById(R.id.enam);
        Button tujuh7 = (Button) view.findViewById(R.id.tujuh);
        Button delapan8 = (Button) view.findViewById(R.id.delapan);
        Button sembilan9 = (Button) view.findViewById(R.id.sembilan);
        Button sepiluh10 = (Button) view.findViewById(R.id.sepuluh);
        Button sebelas11 = (Button) view.findViewById(R.id.sebelas);
        Button duabelas12 = (Button) view.findViewById(R.id.duabelas);
        Button tigabelas13 = (Button) view.findViewById(R.id.tigabelas);
        Button empatbelas14 = (Button) view.findViewById(R.id.empatbelas);
        Button limabelas15 = (Button) view.findViewById(R.id.limabelas);
        Button enambelas16 = (Button) view.findViewById(R.id.enambelas);
        Button tujuhbelas17 = (Button) view.findViewById(R.id.tujuhbelas);
        Button delapanbelas18 = (Button) view.findViewById(R.id.delapanbelas);
        Button sembilanbelas19 = (Button) view.findViewById(R.id.sembilanbelas);
        Button duapuluh20 = (Button) view.findViewById(R.id.duapuluh);
        Button duasatu21 = (Button) view.findViewById(R.id.duasatu);

        //init
        firebaseAuth = FirebaseAuth.getInstance();

        satu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MurajaahActivity.class);
                startActivity(intent);
            }
        });

        dua2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AnnasActivity.class);
                startActivity(intent);
            }
        });

        tiga3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AlfalaqActivity.class);
                startActivity(intent);
            }
        });

        empat4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AlikhlasActivity.class);
                startActivity(intent);
            }
        });

        lima5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Al_LahabActivity.class);
                startActivity(intent);
            }
        });

        enam6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AnnasrActivity.class);
                startActivity(intent);
            }
        });

        tujuh7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AlkafirunActivity.class);
                startActivity(intent);
            }
        });

        delapan8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AlkautsarActivity.class);
                startActivity(intent);
            }
        });

        sembilan9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AlmaunActivity.class);
                startActivity(intent);
            }
        });

        sepiluh10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AlquraisyActivity.class);
                startActivity(intent);
            }
        });

        sebelas11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AlfilActivity.class);
                startActivity(intent);
            }
        });

        duabelas12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AlhumazahActivity.class);
                startActivity(intent);
            }
        });

        tigabelas13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AlasrActivity.class);
                startActivity(intent);
            }
        });

        empatbelas14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AttakasurActivity.class);
                startActivity(intent);
            }
        });

        limabelas15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AlqoriahActivity.class);
                startActivity(intent);
            }
        });

        enambelas16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AladiatActivity.class);
                startActivity(intent);
            }
        });

        tujuhbelas17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AzzalzalahActivity.class);
                startActivity(intent);
            }
        });

        delapanbelas18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AlbayyinahActivity.class);
                startActivity(intent);
            }
        });

        sembilanbelas19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AlqodrActivity.class);
                startActivity(intent);
            }
        });

        duapuluh20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AlalaqActivity.class);
                startActivity(intent);
            }
        });

        duasatu21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AttinActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }


    private void checkUserStatus() {
        //get current user
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null) {
            //user is signed in stay here
            //set email of logged in user
            //mProfileTv.setText(user.getEmail());
        } else {
            //user not signed in,go to main activity
            startActivity(new Intent(getActivity(), MainActivity.class));
            getActivity().finish();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true); //to show menu option in fragment
        super.onCreate(savedInstanceState);

    }

    /*inflate options menu*/
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        //inflating enu
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
    //handle menu item click

    @Override
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