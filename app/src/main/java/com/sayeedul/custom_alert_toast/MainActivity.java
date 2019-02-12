package com.sayeedul.custom_alert_toast;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toast toast;
    String[] items = {"Jalandhar","Ludhiana","Phagwara"};
    String[] itemsSS = {"Red","Blue","Green"};
    String[] itemsMS = {"Bold","Italic","Underline"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        View v = getLayoutInflater().inflate(R.layout.toastview, (ViewGroup) findViewById(R.id.ToastLayout));

        toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER,0,0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(v);
        toast.show();

    }

    public void showAlert(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //builder.setMessage("Select");
        builder.setCancelable(false);
        builder.setTitle("ALert1");

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "You Pressed Okay", Toast.LENGTH_SHORT).show();
                alertNew();

            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "You pressed Cancel", Toast.LENGTH_SHORT).show();
            }
        });

         /*
        //Simple List
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, items[i], Toast.LENGTH_SHORT).show();
            }
        });

        //List with Radio buttons and single selection
        builder.setSingleChoiceItems(itemsSS, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, itemsSS[i], Toast.LENGTH_SHORT).show();
            }
        });
        */
        //List with Checkboxes and multiple selections
        builder.setMultiChoiceItems(itemsMS, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                Toast.makeText(MainActivity.this, b+", "+i, Toast.LENGTH_SHORT).show();
            }
        });


        builder.setView(getLayoutInflater().inflate(R.layout.toastview,null));

        AlertDialog dialog = builder.create();
        dialog.show();

    }

    public void alertNew()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alert2");
        builder.setCancelable(false);

        builder.setSingleChoiceItems(itemsSS, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "you selected "+(i+1), Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
