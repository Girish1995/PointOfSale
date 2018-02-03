package com.pointofsale.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pointofsale.R;

public class InvoiceFragment extends Fragment {

Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context=container.getContext();
        View view=inflater.inflate(R.layout.fragment_invoice, container, false);

        init(view);

        return view;
    }

    private void init(View view) {


    }

}
