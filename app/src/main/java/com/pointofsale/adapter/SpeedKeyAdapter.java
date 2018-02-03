package com.pointofsale.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.pointofsale.R;
import com.pointofsale.model.Items;

import java.util.ArrayList;

/**
 * Created by Girish Grover on 1/24/2018.
 */

public class SpeedKeyAdapter extends BaseAdapter {

    private Context contxt;
    private ArrayList<Integer> transactionModelArrayList = new ArrayList<>();

    public SpeedKeyAdapter(Context contxt,ArrayList<Integer> transactionModelArrayList){
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
        TextView count,delte;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        View view = convertView;
        view = View.inflate(contxt, R.layout.speed_row,null);
        holder = new ViewHolder();

        holder.count = (TextView)  view.findViewById(R.id.count);
holder.delte=(TextView)view.findViewById(R.id.delete);
        view.setTag(holder);

        holder.count.setText(String.valueOf(transactionModelArrayList.get(position)));
holder.delte.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        transactionModelArrayList.remove(position);

        notifyDataSetChanged();

    }
});
        return view;
    }
}
