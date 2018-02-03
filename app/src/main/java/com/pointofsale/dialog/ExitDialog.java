package com.pointofsale.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;

import com.pointofsale.R;

/**
 * Created by Girish Grover on 1/21/2018.
 */

public class ExitDialog extends Dialog implements View.OnClickListener {

    Button yes,cancel;
    Context context;
    public ExitDialog(@NonNull Context context) {
        super(context);
        this.context=context;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exit_dialog);

        yes=(Button)findViewById(R.id.yes);
        cancel=(Button)findViewById(R.id.cancel);


        yes.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()){
            case R.id.yes:
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                break;

            case R.id.cancel:
                dismiss();
                break;

                default:
                    break;

        }
    }
}
