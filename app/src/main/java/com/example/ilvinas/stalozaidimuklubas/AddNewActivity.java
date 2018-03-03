package com.example.ilvinas.stalozaidimuklubas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class AddNewActivity extends AppCompatActivity {

    public final String ENTRY = "com.example.ilvinas.stalozaidimuklubas";
    public final int NEW_ENTRY_IND = -1;

    Bundle bundle;
    EditText etTitle, etYear, etAuthor, etOwner, etHolder;
    Spinner spPublisher;
    CheckBox cbCat01, cbCat02, cbCat03, cbCat04, cbCat05, cbCat06, cbCat07, cbCat08, cbCat09, cbCat10, cbCat11, cbCat12, cbCat13, cbCat14, cbCat15;
    Button button_addnew, button_update, button_delete;
    BGDBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnew);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        bundle = getIntent().getExtras();

        etTitle = (EditText) findViewById(R.id.input_title);
        etYear = (EditText) findViewById(R.id.input_year);
        etAuthor = (EditText) findViewById(R.id.input_author);
        spPublisher = (Spinner) findViewById(R.id.sp_publisher);
        cbCat01 = (CheckBox) findViewById(R.id.cb_cat01);
        cbCat02 = (CheckBox) findViewById(R.id.cb_cat02);
        cbCat03 = (CheckBox) findViewById(R.id.cb_cat03);
        cbCat04 = (CheckBox) findViewById(R.id.cb_cat04);
        cbCat05 = (CheckBox) findViewById(R.id.cb_cat05);
        cbCat06 = (CheckBox) findViewById(R.id.cb_cat06);
        cbCat07 = (CheckBox) findViewById(R.id.cb_cat07);
        cbCat08 = (CheckBox) findViewById(R.id.cb_cat08);
        cbCat09 = (CheckBox) findViewById(R.id.cb_cat09);
        cbCat10 = (CheckBox) findViewById(R.id.cb_cat10);
        cbCat11 = (CheckBox) findViewById(R.id.cb_cat11);
        cbCat12 = (CheckBox) findViewById(R.id.cb_cat12);
        cbCat13 = (CheckBox) findViewById(R.id.cb_cat13);
        cbCat14 = (CheckBox) findViewById(R.id.cb_cat14);
        cbCat15 = (CheckBox) findViewById(R.id.cb_cat15);
        etOwner = (EditText) findViewById(R.id.input_owner);
        etHolder = (EditText) findViewById(R.id.input_holder);

        db = new BGDBHandler(AddNewActivity.this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.publishers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spPublisher.setAdapter(adapter);

        etTitle.setError(null);
        etYear.setError(null);
        etAuthor.setError(null);
        etOwner.setError(null);
        etHolder.setError(null);
        cbCat01.setError(null);

        if (!(bundle.getInt(ENTRY) == NEW_ENTRY_IND)) {
            setTitle(R.string.title_activity_update);
            Zaidimas gametemp = db.getGame(bundle.getInt(ENTRY));
            etTitle.setText(gametemp.getTitle());
            etYear.setText(String.valueOf(gametemp.getYear()));
            etAuthor.setText(gametemp.getAuthor());
            spPublisher.setSelection(adapter.getPosition(gametemp.getPublisher()));
            cbCat01.setChecked(gametemp.isCat01());
            cbCat02.setChecked(gametemp.isCat02());
            cbCat03.setChecked(gametemp.isCat03());
            cbCat04.setChecked(gametemp.isCat04());
            cbCat05.setChecked(gametemp.isCat05());
            cbCat06.setChecked(gametemp.isCat06());
            cbCat07.setChecked(gametemp.isCat07());
            cbCat08.setChecked(gametemp.isCat08());
            cbCat09.setChecked(gametemp.isCat09());
            cbCat10.setChecked(gametemp.isCat10());
            cbCat11.setChecked(gametemp.isCat11());
            cbCat12.setChecked(gametemp.isCat12());
            cbCat13.setChecked(gametemp.isCat13());
            cbCat14.setChecked(gametemp.isCat14());
            cbCat15.setChecked(gametemp.isCat15());
            etOwner.setText(gametemp.getOwner());
            etHolder.setText(gametemp.getHolder());
        } else {
            setTitle(R.string.title_activity_addnew);
        }

        button_addnew = (Button) findViewById(R.id.button_add_new);
        button_addnew.setEnabled(bundle.getInt(ENTRY) == NEW_ENTRY_IND);
        button_addnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Zaidimas game = obtainInput();
                if (game.getTitle()!=null) {
                    db.addGame(game);
                    Toast.makeText(view.getContext(), "Sukurtas naujas įrašas: " + game.getTitle(), Toast.LENGTH_LONG).show();
                    //Zaidimas ctrl = db.getGame(game.getId());
                    //Toast.makeText(view.getContext(), "Atnaujintas įrašas: " + ctrl.getTitle(), Toast.LENGTH_LONG).show();
                }
            }
        });

        button_update = (Button) findViewById(R.id.button_add_update);
        button_update.setEnabled(!(bundle.getInt(ENTRY) == NEW_ENTRY_IND));
        button_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Zaidimas game = obtainInput();
                if (game.getTitle()!=null) {
                    game.setId(bundle.getInt(ENTRY));
                    db.updateGame(game);
                    Toast.makeText(view.getContext(), "Atnaujintas įrašas: " + game.getTitle(), Toast.LENGTH_LONG).show();
                    //Zaidimas ctrl = db.getGame(game.getId());
                    //Toast.makeText(view.getContext(), "Atnaujintas įrašas: " + ctrl.getTitle(), Toast.LENGTH_LONG).show();
                }
            }
        });

        button_delete = (Button) findViewById(R.id.button_add_delete);
        button_delete.setEnabled(!(bundle.getInt(ENTRY) == NEW_ENTRY_IND));
        button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Zaidimas game = obtainInput();
                game.setId((bundle.getInt(ENTRY)));
                if (game.getTitle()!=null) {
                    db.deleteGame(game.getId());
                    Toast.makeText(view.getContext(), "Įrašas ištrintas", Toast.LENGTH_LONG).show();
                }
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

    private Zaidimas obtainInput() {
        Zaidimas result = new Zaidimas();
        if (!Validation.isValidTitle(etTitle.getText().toString())) {
            etTitle.requestFocus();
            etTitle.setError(getResources().getString(R.string.invalid_title));
        } else if (!Validation.isValidYear(etYear.getText().toString())) {
            etYear.requestFocus();
            etYear.setError(getResources().getString(R.string.invalid_year));
        } else if (!(Validation.isValidTitle(etAuthor.getText().toString()) || etAuthor.getText().toString().equals(""))) {
            etAuthor.requestFocus();
            etAuthor.setError(getResources().getString(R.string.invalid_title));
        } else if (!(Validation.isValidTitle(etOwner.getText().toString()) || etOwner.getText().toString().equals(""))) {
            etOwner.requestFocus();
            etOwner.setError(getResources().getString(R.string.invalid_title));
        } else if (!(Validation.isValidTitle(etHolder.getText().toString()) || etHolder.getText().toString().equals(""))) {
            etHolder.requestFocus();
            etHolder.setError(getResources().getString(R.string.invalid_title));
        } else if (!(cbCat01.isChecked() || cbCat02.isChecked() || cbCat03.isChecked() || cbCat04.isChecked() || cbCat05.isChecked() || cbCat06.isChecked() || cbCat07.isChecked() || cbCat08.isChecked() || cbCat09.isChecked() || cbCat10.isChecked() || cbCat11.isChecked() || cbCat12.isChecked() || cbCat13.isChecked() || cbCat14.isChecked() || cbCat15.isChecked())) {
            Toast.makeText(this, getResources().getString(R.string.invalid_cbselection), Toast.LENGTH_SHORT).show();
        } else if (spPublisher.getSelectedItem().toString().equals("")) {
            Toast.makeText(this, getResources().getString(R.string.invalid_spselection), Toast.LENGTH_SHORT).show();
        } else {
            result = new Zaidimas(etTitle.getText().toString(), cbCat01.isChecked(), cbCat02.isChecked(), cbCat03.isChecked(), cbCat04.isChecked(), cbCat05.isChecked(), cbCat06.isChecked(), cbCat07.isChecked(), cbCat08.isChecked(), cbCat09.isChecked(), cbCat10.isChecked(), cbCat11.isChecked(), cbCat12.isChecked(), cbCat13.isChecked(), cbCat14.isChecked(), cbCat15.isChecked(), Integer.parseInt(etYear.getText().toString()), etAuthor.getText().toString(), spPublisher.getSelectedItem().toString(), etOwner.getText().toString(), etHolder.getText().toString());
        }
        return result;
    }

}
