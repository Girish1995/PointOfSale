package com.pointofsale.fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.pointofsale.R;
import com.pointofsale.start.MainDashboard;

/**
 * Created by Girish Grover on 1/24/2018.
 */

public class OtherCharges extends Fragment implements View.OnClickListener {

    Context context;
    ImageView show_right,hide_right;
    LinearLayout show_hide;
    LinearLayout past_invoice,other_charges,speed_dial,manage_reason,drawer_transaction,manage_emp,cancel_credit;
    FloatingActionButton fab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_other_charges, container, false);
        context = container.getContext();


        show_right=(ImageView)v.findViewById(R.id.show_right);
        hide_right=(ImageView)v.findViewById(R.id.hide_right);
        show_hide=(LinearLayout)v.findViewById(R.id.show_hide);

        fab=(FloatingActionButton)v.findViewById(R.id.fab);

        past_invoice=(LinearLayout)v.findViewById(R.id.past_invoices);
        other_charges=(LinearLayout)v.findViewById(R.id.other_charges);
        speed_dial=(LinearLayout)v.findViewById(R.id.speed_dial);
        manage_reason=(LinearLayout)v.findViewById(R.id.manage_reason);
        drawer_transaction=(LinearLayout)v.findViewById(R.id.drawe_transaction);
        manage_emp=(LinearLayout)v.findViewById(R.id.manage_emp);
        cancel_credit=(LinearLayout)v.findViewById(R.id.cancel_credit);


        past_invoice.setOnClickListener(this);
        other_charges.setOnClickListener(this);
        speed_dial.setOnClickListener(this);
        manage_reason.setOnClickListener(this);
        drawer_transaction.setOnClickListener(this);
        manage_emp.setOnClickListener(this);
        cancel_credit.setOnClickListener(this);


        show_right.setOnClickListener(this);
        hide_right.setOnClickListener(this);
        fab.setOnClickListener(this);
        return v;

    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){

            case R.id.fab:
                fun_firstFragment(new AddCharge());
                fab.setVisibility(View.GONE);
                break;

            case R.id.past_invoices:
                changeColor(past_invoice);
                fun_firstFragment(new MainDashboard.Sales());

                break;

            case R.id.other_charges:
                changeColor(other_charges);
                fun_firstFragment(new OtherCharges());
                break;

            case R.id.speed_dial:
                changeColor(speed_dial);
                fun_firstFragment(new SpeedDial());

                break;

            case R.id.manage_reason:

                changeColor(manage_reason);
                fun_firstFragment(new ManageReason());
                break;

            case R.id.drawe_transaction:

                changeColor(drawer_transaction);
                fun_firstFragment(new DrawerTransaction());
                break;

            case R.id.manage_emp:
                changeColor(manage_emp);
                fun_firstFragment(new ManageEmployee());
                break;

            case R.id.cancel_credit:
                changeColor(cancel_credit);
                fun_firstFragment(new MainDashboard.Sales());
                break;
            case R.id.show_right:

                show_hide.setVisibility(View.VISIBLE);
                break;

            case R.id.hide_right:

                show_hide.setVisibility(View.GONE);
                break;

                default:
                    break;
        }
    }

    public void changeColor(LinearLayout linearLayout){
        past_invoice.setBackgroundResource(R.drawable.rect_dark_yellow_bg);
        other_charges.setBackgroundResource(R.drawable.rect_dark_yellow_bg);
        speed_dial.setBackgroundResource(R.drawable.rect_dark_yellow_bg);
        manage_reason.setBackgroundResource(R.drawable.rect_dark_yellow_bg);
        drawer_transaction.setBackgroundResource(R.drawable.rect_dark_yellow_bg);
        manage_emp.setBackgroundResource(R.drawable.rect_dark_yellow_bg);
        cancel_credit.setBackgroundResource(R.drawable.rect_dark_yellow_bg);

        linearLayout.setBackgroundResource(R.drawable.rect_light_yellow_bg);
    }
    private void fun_firstFragment(Fragment fragment) {
        Fragment newFragment6 = fragment;
        Fragment fragment6 = newFragment6;
        FragmentTransaction fragmentTransaction6 = getFragmentManager().beginTransaction();
//            fragmentTransaction6.setCustomAnimations(android.R.anim.fade_in,
//                    android.R.anim.fade_out);
            fragmentTransaction6.replace(R.id.relative1, fragment6, "");
        fragmentTransaction6.commitAllowingStateLoss();
    }
}
