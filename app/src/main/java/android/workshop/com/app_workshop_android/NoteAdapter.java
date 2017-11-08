package android.workshop.com.app_workshop_android;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by IFSP- on 08/11/2017.
 */

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.MyViewHolder>{

    private ArrayList<Note> notes;
    private Context context;

    public NoteAdapter(ArrayList<Note> notes, Context context) {

        this.notes = notes;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Note note = notes.get(position);

        holder.textViewTitle.setText(note.getTitle());
        holder.textViewDescription.setText(note.getDescription());
        String[] arrayBackground = holder.linear.getContext().getResources().getStringArray(R.array.card_colorsBackground);

        String[] arrayDescription = holder.textViewDescription.getContext().getResources().getStringArray(R.array.card_colorsDescription);

        String[] arrayTitle = holder.textViewTitle.getContext().getResources().getStringArray(R.array.card_colorsTitle);

        Random random = new Random();

        String color = arrayBackground[random.nextInt(5)];
        String color2 = arrayDescription[random.nextInt(5)];
        String color3 = arrayTitle[random.nextInt(5)];

        holder.linear.setBackgroundColor(Color.parseColor(color));
        holder.textViewDescription.setTextColor(Color.parseColor(color2));
        holder.textViewTitle.setTextColor(Color.parseColor(color3));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewDescription;
        TextView textViewTitle;
        LinearLayout linear;

        public MyViewHolder(View itemView) {
            super(itemView);


            linear = itemView.findViewById(R.id.parent);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
        }
    }
}
