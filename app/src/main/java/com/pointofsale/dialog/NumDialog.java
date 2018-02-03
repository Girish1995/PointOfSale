package com.pointofsale.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pointofsale.R;
import com.pointofsale.adapter.SpeedKeyAdapter;

import java.util.ArrayList;

import java.util.Collections;

/**
 * Created by Girish Grover on 1/23/2018.
 */

public class NumDialog extends Dialog implements View.OnClickListener {

    Context context;
    LinearLayout one,two,three,four,five,six,seven,eight,nine,zero,dot,clear,tick,cross;
    TextView discount,change_txt;
    String what="";
    ArrayList<Integer> arrayList;
    SpeedKeyAdapter speedKeyAdapter;

    public NumDialog(@NonNull Context context) {
        super(context);
        this.context=context;
    }

    public NumDialog(Context context, SpeedKeyAdapter speedKeyAdapter, ArrayList<Integer> arrayList, String what){
        super(context);

        this.context=context;
        this.speedKeyAdapter=speedKeyAdapter;
        this.arrayList=arrayList;
        this.what=what;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.num_dialog);


        init();
        clicks();

        change_txt=(TextView)findViewById(R.id.change_txt);

        if (what.equals("add_key")){
        change_txt.setVisibility(View.VISIBLE);}
        else {
            change_txt.setText("Add Total Discount(%)");
        }
    }

    public void init(){

        one=(LinearLayout)findViewById(R.id.one);
        two=(LinearLayout)findViewById(R.id.two);
        three=(LinearLayout)findViewById(R.id.three);
        four=(LinearLayout)findViewById(R.id.four);
        five=(LinearLayout)findViewById(R.id.five);
        six=(LinearLayout)findViewById(R.id.six);
        seven=(LinearLayout)findViewById(R.id.seven);
        eight=(LinearLayout)findViewById(R.id.eight);
        nine=(LinearLayout)findViewById(R.id.nine);
        zero=(LinearLayout)findViewById(R.id.zero);
        dot=(LinearLayout)findViewById(R.id.dot);
        clear=(LinearLayout)findViewById(R.id.clear);
        tick=(LinearLayout)findViewById(R.id.tick);
        cross=(LinearLayout)findViewById(R.id.cross);

        discount=(TextView)findViewById(R.id.discount);
    }

    public void clicks(){

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        dot.setOnClickListener(this);
        clear.setOnClickListener(this);
        tick.setOnClickListener(this);
        cross.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.one:
                discount.append("1");
                break;

            case R.id.two:
                discount.append("2");
                break;

            case R.id.three:
                discount.append("3");
                break;

            case R.id.four:
                discount.append("4");
                break;

            case R.id.five:

                discount.append("5");
                break;

            case R.id.six:
                discount.append("6");
                break;

            case R.id.seven:

                discount.append("7");
                break;

            case R.id.eight:
                discount.append("8");
                break;

            case R.id.nine:
                discount.append("9");
                break;

            case R.id.zero:
                discount.append("0");
                break;


            case R.id.clear:

                if (discount.getText().toString().length()>0) {
                    discount.setText(discount.getText().toString().substring(0,discount.getText().toString().length() - 1));
                } break;

            case R.id.dot:
                discount.append(".");
                break;

            case R.id.tick:
                if (what.equals("add_key")) {


                    arrayList.add(Integer.parseInt(discount.getText().toString()));
                    Collections.sort(arrayList);
                    speedKeyAdapter.notifyDataSetChanged();
                }
                dismiss();
                break;

            case R.id.cross:
                dismiss();
                break;


        }
    }
}
