package com.uid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private List<Users> myList;

    RecyclerViewAdapter(List<Users> users){

        myList = users;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView userNameTv;

        private ImageView userImageIv;

        private ViewHolder(View v){
            super(v);

            userNameTv = (TextView)v.findViewById(R.id.nameTv);

            userImageIv = (ImageView) v.findViewById(R.id.userIv);
        }
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview, parent, false);
        return new ViewHolder(view1);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position){

        holder.userNameTv.setText("Name : "+ myList.get(position).getLogin()+" .");
        holder.userNameTv.append("\n");
        holder.userNameTv.append("ID : "+myList.get(position).getId()+" .");

        holder.userImageIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"This is "+myList.get(1)+" ." ,Toast.LENGTH_LONG).show();
            }
        });

        switch (position){
            case 0 :
                holder.userImageIv.setImageResource(R.drawable.caseone);
                break;

            case 1 :
                holder.userImageIv.setImageResource(R.drawable.casetwo);
                break;

            case 2 :
                holder.userImageIv.setImageResource(R.drawable.casethree);
                break;

            case 3 :
                holder.userImageIv.setImageResource(R.drawable.casefour);
                break;

            case 4 :
                holder.userImageIv.setImageResource(R.drawable.casefive);
                break;

            case 5 :
                holder.userImageIv.setImageResource(R.drawable.casesix);
                break;

            case 6 :
                holder.userImageIv.setImageResource(R.drawable.caseseven);
                break;

            case 7 :
                holder.userImageIv.setImageResource(R.drawable.caseeight);
                break;

            case 8 :
                holder.userImageIv.setImageResource(R.drawable.casenine);
                break;

            case 9 :
                holder.userImageIv.setImageResource(R.drawable.caseten);
                break;

            case 10:
                holder.userImageIv.setImageResource(R.drawable.caseeleven);
                break;

            case 11:
                holder.userImageIv.setImageResource(R.drawable.casetwelve);
                break;

            case 12:
                holder.userImageIv.setImageResource(R.drawable.casetherteen);
                break;

            case 13:
                holder.userImageIv.setImageResource(R.drawable.casefourteen);
                break;

            case 14:
                holder.userImageIv.setImageResource(R.drawable.casefifteen);
                break;

            case 15:
                holder.userImageIv.setImageResource(R.drawable.casesixteen);
                break;

            case 16:
                holder.userImageIv.setImageResource(R.drawable.caseseventeen);
                break;

            case 17:
                holder.userImageIv.setImageResource(R.drawable.caseeighteen);
                break;

            case 18:
                holder.userImageIv.setImageResource(R.drawable.casenineteen);
                break;

            case 19:
                holder.userImageIv.setImageResource(R.drawable.casetwenty);
                break;

            case 20:
                holder.userImageIv.setImageResource(R.drawable.casetwentyone);
                break;

            case 21:
                holder.userImageIv.setImageResource(R.drawable.casetwentytwo);
                break;

            case 22:
                holder.userImageIv.setImageResource(R.drawable.casetwentythree);
                break;

            default:
                holder.userImageIv.setImageResource(R.drawable.addimg);
                break;
        }
    }

    @Override
    public int getItemCount(){return myList.size();}
}