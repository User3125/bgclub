package com.example.ilvinas.stalozaidimuklubas;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Collections;
import java.util.List;

public class GameAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private List<Zaidimas> games = Collections.emptyList();
    private Zaidimas gameTemp;
    private int currentPos;
    public final String ENTRY = "com.example.ilvinas.stalozaidimuklubas";

    public GameAdapter(Context context, List<Zaidimas> games) {
        this.context = context;
        this.games = games;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.container_dbcontent, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyHolder holder1 = (MyHolder) holder;
        gameTemp = games.get(position);
        holder1.tvTitle.setText(gameTemp.getTitle());
        holder1.tvYear.setText((String.valueOf(gameTemp.getYear())));
        holder1.tvAuthor.setText(gameTemp.getAuthor());
        holder1.tvPublisher.setText(gameTemp.getPublisher());
        holder1.tvCats.setText("Bla bla bla");
    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvTitle, tvYear, tvAuthor, tvPublisher, tvCats;

        public MyHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.id_cont_title);
            tvYear = itemView.findViewById(R.id.id_cont_year);
            tvAuthor = itemView.findViewById(R.id.id_cont_author);
            tvPublisher = itemView.findViewById(R.id.id_cont_publisher);
            tvCats = itemView.findViewById(R.id.id_cont_cats);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            currentPos = getAdapterPosition();
            gameTemp = games.get(currentPos);
            Intent intent = new Intent(context, AddNewActivity.class);
            intent.putExtra(ENTRY, games.get(currentPos).getId());
            context.startActivity(intent);
        }
    }
}
