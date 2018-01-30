package com.capstone.icoffie.pharmapp.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.capstone.icoffie.pharmapp.MapsActivity;
import com.capstone.icoffie.pharmapp.R;
import com.capstone.icoffie.pharmapp.model.SharedPrefManager;

public class UserAccountsFragment extends Fragment{

    private View view;
    private TextView txtUserName;
    private Button searchDrugs;
    private Handler handler;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_user_account_list, container, false);



        //set welcome user name textview
        txtUserName = (TextView)view.findViewById(R.id.userName);
        searchDrugs = (Button) view.findViewById(R.id.search_drugs_btn);
        txtUserName.append(SharedPrefManager.getClassinstance(getContext()).getUserName());
        searchDrugs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Searhing drugs");
                handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent=new Intent(getActivity().getApplicationContext(), MapsActivity.class);
                        startActivity(intent);
                    }
                },3000);
            }
        });

        // return view to whichever activity calls this fragment
        return view;
    }

    public void showToast(String msg){
        Toast.makeText(getActivity().getApplicationContext(), msg, Toast.LENGTH_SHORT).show();


    }

}

