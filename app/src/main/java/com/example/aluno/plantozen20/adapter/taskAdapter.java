package com.example.aluno.plantozen20.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aluno.plantozen20.R;
import com.example.aluno.plantozen20.activity.TaskActivity;

/**
 * Created by Danie on 07/11/2017.
 */
/**
 * Created by Aluno on 02/10/2017.
 */

        import android.os.Bundle;
        import android.support.v7.widget.CardView;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;
        import android.util.Log;
        import android.content.Context;



        import android.content.Intent;


        import com.example.aluno.plantozen20.R;
        import com.example.aluno.plantozen20.activity.TaskActivity;

public class taskAdapter extends RecyclerView.Adapter<taskAdapter.MyViewHolder> {
    private String[] mDataset;
    private String[] mDataset2;
    private Intent intent = null;


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView mCardView;
        public TextView mTextView;
        public TextView mTextView2;
        private final Context context;

        public MyViewHolder(View v) {
            super(v);
            context = v.getContext();

            mCardView = (CardView) v.findViewById(R.id.card_view);
            mTextView = (TextView) v.findViewById(R.id.tv_text);
            mTextView2 = (TextView) v.findViewById(R.id.tv_data);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public taskAdapter(String[] myDataset, String[] myDataset2) {
        mDataset = myDataset;
        mDataset2 = myDataset2;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public taskAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {


        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.mTextView.setText(mDataset[position]);
        holder.mTextView2.setText(mDataset2[position]);
        final Context context = holder.context;
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String currentValue = mDataset[position];
             //   intent =  new Intent(context, TaskActivity.class);
              //  Bundle b = new Bundle();

                // b.putString("titulo", currentValue);
                // b.putInt("key", 1); //Your id
                //intent.putExtras(b); //Put your id to your next Intent
                //context.startActivity(intent);
                Log.d("CardView", "CardView Clicked: " + currentValue);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}