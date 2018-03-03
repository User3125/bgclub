package com.example.ilvinas.stalozaidimuklubas;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final boolean LOCAL_DB_EXPLOITATION_STATUS = false;
    public final String ENTRY = "com.example.ilvinas.stalozaidimuklubas";
    public final int NEW_ENTRY_IND = -1;
    RecyclerView rvDBContent;
    SearchView searchView = null;

    BGDBHandler db = new BGDBHandler(MainActivity.this);
    List<Zaidimas> games0 = Collections.emptyList();
    List<Zaidimas> games = new ArrayList<Zaidimas>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        games0 = db.getAllGames();
        setRecycleView(games0);

        Button button_addnew = (Button) findViewById(R.id.button_addnew);
        button_addnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), AddNewActivity.class);
                intent.putExtra(ENTRY, NEW_ENTRY_IND);
                view.getContext().startActivity(intent);}
        });

        Button button_logout = (Button) findViewById(R.id.button_logout);
        button_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), LoginActivity.class);
                view.getContext().startActivity(intent);}
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);
        MenuItem searchItem = findViewById(R.id.action_search);
        SearchManager searchManager = (SearchManager) MainActivity.this.getSystemService(Context.SEARCH_SERVICE);
        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
        }
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(MainActivity.this.getComponentName()));
            searchView.setIconified(false);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        Toast.makeText(MainActivity.this, "onNewIntent paleistas", Toast.LENGTH_SHORT).show();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            if (searchView != null) {
                searchView.clearFocus();
            }
            Toast.makeText(MainActivity.this, query, Toast.LENGTH_SHORT).show();

            new AsyncFetch(query).execute();
        }
    }

    private void setRecycleView(List<Zaidimas> games) {
        rvDBContent = (RecyclerView) findViewById(R.id.rv_dbcontent);
        rvDBContent.setAdapter(new GameAdapter(MainActivity.this, games));
        rvDBContent.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    private class AsyncFetch extends AsyncTask<String, String, String> {
        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        String searchQuery;

        public AsyncFetch(String searchQuery) {
            this.searchQuery = searchQuery;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.setMessage("Minutėlę...");
            progressDialog.setCancelable(false);
            progressDialog.show();
            Toast.makeText(MainActivity.this, "Atėjau iki preExecute", Toast.LENGTH_SHORT).show();

        }

        @Override
        protected String doInBackground(String... strings) {
            games.clear();
            if (LOCAL_DB_EXPLOITATION_STATUS) {
                games = db.getGames(searchQuery);
            } else {
                for (int i = 0; i < games0.size(); i++) {
                    if (games0.get(i).getTitle().contains(searchQuery)) {
                        games.add(games0.get(i));
                    }
                }
            }
            if (games.isEmpty()) {
                return "none";
            } else {
                return "result";
            }
        }

        @Override
        protected void onPostExecute(String result) {
            progressDialog.dismiss();
            if (result.equals("none")) {
                Toast.makeText(MainActivity.this, "Pagal pateiktus kriterijus duomenų nėra", Toast.LENGTH_SHORT).show();
            } else {
                setRecycleView(games);
            }
        }
    }
}