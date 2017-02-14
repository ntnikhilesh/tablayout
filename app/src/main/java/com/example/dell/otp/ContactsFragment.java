package com.example.dell.otp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// In this case, the fragment displays simple text based on the page
public class ContactsFragment extends Fragment implements RecyclerViewClickListener{
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;

    private RecyclerView recyclerView;
    private ArrayList<Items> data;
    private MyAdapter adapter;
    private FrameLayout fl;
    Items[] items;
    private ServiceInterface serviceInterface;

    //Getting page no from Adapter
    public static ContactsFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        ContactsFragment fragment = new ContactsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fl = (FrameLayout)inflater.inflate(R.layout.contacts_layout, container, false);

        //Ininitalze view of Recycle View
        initViews();

        //TextView textView = (TextView) view;
        //textView.setText("Fragment #" + mPage);
        return fl;
    }

    //initialize views
    private void initViews(){
        recyclerView = (RecyclerView)fl.findViewById(R.id.card_recycler_view);
        // recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        inflate_RecyclerView();

    }




    //inflate Recycle view items
    public void inflate_RecyclerView()

    {
        serviceInterface = NetworkApiGenerator.createService(ServiceInterface.class);

        serviceInterface.getUnansweresandroidquestions("VZhcpZM*4qY7QhxpPc7OYw((","stackoverflow.com","android","desc","votes", new Callback<Questions>() {
            @Override
            public void success(Questions questions, Response response)
            {
                                //fetcch array objects
                items=questions.getItems();
                Log.d("val","-"+items[0].getName());

                //convert Array into ArrayList
                ArrayList<Items> arrayList = new ArrayList<Items>(Arrays.asList(items));

                // send listner interface object(this) to adapter along with context and listner
                adapter = new MyAdapter(getActivity(),arrayList,ContactsFragment.this);

                // finaly set into adapter
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void failure(RetrofitError error)
            {
                Log.d("API error", error.getMessage());
            }
        });




    }

    @Override
    public void onRowClicked(int position) {

    }

    @Override
    public void onViewClicked(View v, int position) {

    }
}

