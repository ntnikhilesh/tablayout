package com.example.dell.otp;

/**
 * Created by DELL on 12/7/2016.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<Items> mDataset;
    int position1;
    String all_tags,mtags="",profile_img="";
    private Context context;

//handle click event by interface
    private RecyclerViewClickListener listener;
    // Provide a suitable constructor (depends on the kind of dataset)
    //getting context and data from Main Activity
    public MyAdapter(Context applicationContext, ArrayList<Items> myDataset, RecyclerViewClickListener listener){
        this.context=applicationContext;
        mDataset = myDataset;
        this.listener = listener;

    }



    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView tv_ques;



        public ViewHolder(View itemView, final RecyclerViewClickListener listener) {

            super(itemView);
            tv_ques = (TextView) itemView.findViewById(R.id.tv_contact);


            // handle click event

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("row clicked","");
                    if(listener != null)
                        listener.onRowClicked(getAdapterPosition());
                }
            });



        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_row, parent, false);

        //set listner
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v,listener);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
           position1=position;

            holder.tv_ques.setText("Nikhil T");


    }



    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}