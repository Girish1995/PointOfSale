package com.pointofsale.start;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.pointofsale.R;
import com.pointofsale.dialog.ExitDialog;

import java.util.ArrayList;
import java.util.Arrays;

public class SelectBusinessType extends AppCompatActivity implements View.OnClickListener {

    Button submit;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_business_type);

        submit=(Button)findViewById(R.id.submit);
        spinner=(Spinner)findViewById(R.id.spinner);
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.business_type)));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item,list);

        spinner.setAdapter(adapter);
        submit.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {


        switch (view.getId()){
            case R.id.submit:

                if (spinner.getSelectedItem().toString().equals("Select Role")){
                    Toast.makeText(this, "Select a Role First!!", Toast.LENGTH_SHORT).show();
                }
                else{

                    startActivity(new Intent(SelectBusinessType.this,MainDashboard.class));
                }

                break;

                default:
                    break;
        }
    }


    @Override
    public void onBackPressed() {
        ExitDialog exitDialog=new ExitDialog(SelectBusinessType.this);
        exitDialog.show();
    }
}