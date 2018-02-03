package com.pointofsale.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.pointofsale.R;

import java.util.ArrayList;

/**
 * Created by Girish Grover on 1/22/2018.
 */

public class CategoriesAdapter extends BaseAdapter {

    private Context contxt;
    private ArrayList<String> transactionModelArrayList = new ArrayList<>();

    public CategoriesAdapter(Context contxt,ArrayList<String> transactionModelArrayList){
        this.contxt = contxt;
        this.transactionModelArrayList = transactionModelArrayList;
    }

    @Override
    public int getCount() {
        return transactionModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        TextView category;}

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        View view = convertView;
        view = View.inflate(contxt, R.layout.category_row,null);
        holder = new ViewHolder();

        holder.category=(TextView) view.findViewById(R.id.category);

        if (transactionModelArrayList.get(position).toString().equals("All")){
            holder.category.setBackgroundResource(R.drawable.rect_dark_yellow_bg);
        }
        else{
            holder.category.setBackgroundResource(R.drawable.rect_light_yellow_bg);
        }

        view.setTag(holder);

        holder.category.setText(transactionModelArrayList.get(position).toString());

        holder.category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String str=holder.category.getText().toString();
                for (int i=0;i<transactionModelArrayList.size();i++){
                    if (!transactionModelArrayList.get(i).toString().equals(str)) {
                        holder.category.setBackgroundResource(R.drawable.rect_dark_yellow_bg);
                    }
                    else{
                        holder.category.setBackgroundResource(R.drawable.rect_light_yellow_bg);

                    }
                    notifyDataSetChanged();
                }


                 }
        });

        return view;
    }
}