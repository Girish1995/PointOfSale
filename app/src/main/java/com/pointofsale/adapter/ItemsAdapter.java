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
 * Created by Girish Grover on 1/22/2018.
 */

public class ItemsAdapter extends BaseAdapter{

    private Context contxt;
    private ArrayList<Items> transactionModelArrayList = new ArrayList<>();

    public ItemsAdapter(Context contxt,ArrayList<Items> transactionModelArrayList){
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
        TextView item_name,price,qty,left_price;
        EditText discount;
        ImageView delete;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        View view = convertView;
        view = View.inflate(contxt, R.layout.item_row,null);
        holder = new ViewHolder();

        holder.item_name = (TextView)  view.findViewById(R.id.item_name);
        holder.price=(TextView)view.findViewById(R.id.price);
        holder.qty=(TextView)view.findViewById(R.id.qty);
        holder.left_price=(TextView)view.findViewById(R.id.left_price);

        holder.discount=(EditText)view.findViewById(R.id.discount);
        holder.delete=(ImageView)view.findViewById(R.id.delete);

        view.setTag(holder);

        holder.item_name.setText(transactionModelArrayList.get(position).getItem_name());
        holder.price.setText(transactionModelArrayList.get(position).getPrice());
        holder.qty.setText(transactionModelArrayList.get(position).getQty());

        holder.discount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (holder.discount.getText().toString().length()>0){

                    Double discount=Double.parseDouble(holder.discount.getText().toString());
                    Double price=Double.parseDouble(holder.price.getText().toString());

                    discount=(discount/100)*price;

                    Double discount_price=price-discount;

                    holder.left_price.setText(String.valueOf(discount_price));

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transactionModelArrayList.remove(position);

                notifyDataSetChanged();
            }
        });

        return view;
    }
}
