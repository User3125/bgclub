package com.example.ilvinas.stalozaidimuklubas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddNewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnew);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button button_addnew = (Button) findViewById(R.id.button_add_new);
        button_addnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText etID = (EditText) findViewById(R.id.input_id);
                EditText etTitle = (EditText) findViewById(R.id.input_title);
                EditText etYear = (EditText) findViewById(R.id.input_year);
                EditText etAuthor = (EditText) findViewById(R.id.input_author);
                Spinner spPublisher = (Spinner) findViewById(R.id.sp_publisher);
                CheckBox cbCat01 = (CheckBox) findViewById(R.id.cb_cat01);
                CheckBox cbCat02 = (CheckBox) findViewById(R.id.cb_cat02);
                CheckBox cbCat03 = (CheckBox) findViewById(R.id.cb_cat03);
                CheckBox cbCat04 = (CheckBox) findViewById(R.id.cb_cat04);
                CheckBox cbCat05 = (CheckBox) findViewById(R.id.cb_cat05);
                CheckBox cbCat06 = (CheckBox) findViewById(R.id.cb_cat06);
                CheckBox cbCat07 = (CheckBox) findViewById(R.id.cb_cat07);
                CheckBox cbCat08 = (CheckBox) findViewById(R.id.cb_cat08);
                CheckBox cbCat09 = (CheckBox) findViewById(R.id.cb_cat09);
                CheckBox cbCat10 = (CheckBox) findViewById(R.id.cb_cat10);
                CheckBox cbCat11 = (CheckBox) findViewById(R.id.cb_cat11);
                CheckBox cbCat12 = (CheckBox) findViewById(R.id.cb_cat12);
                CheckBox cbCat13 = (CheckBox) findViewById(R.id.cb_cat13);
                CheckBox cbCat14 = (CheckBox) findViewById(R.id.cb_cat14);
                CheckBox cbCat15 = (CheckBox) findViewById(R.id.cb_cat15);
                EditText etOwner = (EditText) findViewById(R.id.input_owner);
                EditText etHolder = (EditText) findViewById(R.id.input_holder);
                Zaidimas zaidimas = new Zaidimas(Integer.parseInt(etID.getText().toString()), "", etTitle.getText().toString(), cbCat01.isSelected(), cbCat02.isSelected(), cbCat03.isSelected(), cbCat04.isSelected(), cbCat05.isSelected(), cbCat06.isSelected(), cbCat07.isSelected(), cbCat08.isSelected(), cbCat09.isSelected(), cbCat10.isSelected(), cbCat11.isSelected(), cbCat12.isSelected(), cbCat13.isSelected(), cbCat14.isSelected(), cbCat15.isSelected(), Integer.parseInt(etYear.getText().toString()), etAuthor.getText().toString(), spPublisher.getSelectedItem().toString(), etOwner.getText().toString(), etHolder.getText().toString());
                String message = "Sukurtas naujas įrašas: " + zaidimas.getTitle() + ", " + zaidimas.getPublisher();
                Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
            }
        });

        Button button_cancel = (Button) findViewById(R.id.button_add_cancel);
        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivity(Intent);}
        });

    }

}
