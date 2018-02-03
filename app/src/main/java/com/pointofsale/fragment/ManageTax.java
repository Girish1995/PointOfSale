package com.pointofsale.fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.pointofsale.R;

public class ManageTax extends Fragment implements View.OnClickListener {
    
    Context context;
    LinearLayout product,
            manage_tax,
            inventory,
            view_stock,
            return_stock,
            view_return_stocks,
            supplier;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        context=container.getContext();
        View view=inflater.inflate(R.layout.fragment_inventory, container, false);

        init(view);

        product.setOnClickListener(this);
        manage_tax.setOnClickListener(this);
        inventory.setOnClickListener(this);
        view_stock.setOnClickListener(this);
        return_stock.setOnClickListener(this);
        view_return_stocks.setOnClickListener(this);
        supplier.setOnClickListener(this);

        return view;
    }

    public void init(View v) {

        product=(LinearLayout)v.findViewById(R.id.products);
        manage_tax=(LinearLayout)v.findViewById(R.id.manage_tax);
        inventory=(LinearLayout)v.findViewById(R.id.inventory);
        view_stock=(LinearLayout)v.findViewById(R.id.view_stock);
        return_stock=(LinearLayout)v.findViewById(R.id.return_stock);
        view_return_stocks=(LinearLayout)v.findViewById(R.id.view_return_stock);
        supplier=(LinearLayout)v.findViewById(R.id.supplier);

    }
    private void fun_firstFragment1(Fragment fragment) {
        Fragment newFragment6 = fragment;
        Fragment fragment6 = newFragment6;
        FragmentTransaction fragmentTransaction6 = getFragmentManager().beginTransaction();
//            fragmentTransaction6.setCustomAnimations(android.R.anim.fade_in,
//                    android.R.anim.fade_out);
        fragmentTransaction6.replace(R.id.relative2, fragment6, "");
        fragmentTransaction6.commitAllowingStateLoss();
    }

    public void changeColor(LinearLayout linearLayout){
        product.setBackgroundResource(R.drawable.rect_dark_yellow_bg);
        manage_tax.setBackgroundResource(R.drawable.rect_dark_yellow_bg);
        inventory.setBackgroundResource(R.drawable.rect_dark_yellow_bg);
        view_stock.setBackgroundResource(R.drawable.rect_dark_yellow_bg);
        return_stock.setBackgroundResource(R.drawable.rect_dark_yellow_bg);
        view_return_stocks.setBackgroundResource(R.drawable.rect_dark_yellow_bg);
        supplier.setBackgroundResource(R.drawable.rect_dark_yellow_bg);

        linearLayout.setBackgroundResource(R.drawable.rect_light_yellow_bg);
    }
    @Override
    public void onClick(View view) {


        switch (view.getId()){
            case R.id.products:
                changeColor(product);
 fun_firstFragment1(new Inventory());
                break;

            case R.id.manage_tax:
                changeColor(manage_tax);
              //  fun_firstFragment1(new ManageTax());
                break;

            case R.id.inventory:
                changeColor(inventory);
                fun_firstFragment1(new InventoryDownload());
                break;

            case R.id.view_stock:
                changeColor(view_stock);
                fun_firstFragment1(new ViewStock());
                break;

            case R.id.return_stock:
                changeColor(return_stock);
                fun_firstFragment1(new ReturnStock());
                break;

            case R.id.view_return_stock:
                changeColor(view_return_stocks);
                fun_firstFragment1(new ViewReturnStock());
                break;

            case R.id.supplier:
                changeColor(supplier);
                fun_firstFragment1(new Supplier());
                break;

            default:

                break;


        }

    }
}