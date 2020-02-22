package application.weatherapi.disha.notesjanitri.ui.ViewNotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import application.weatherapi.disha.notesjanitri.R;
import application.weatherapi.disha.notesjanitri.data.local.Notes;
import application.weatherapi.disha.notesjanitri.model.NotesListitem;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    List<Notes> list;
    Context context;

    public NotesAdapter(List<Notes> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public NotesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_notes,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesAdapter.ViewHolder holder, int position) {
        holder.bind(position);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CheckBox checkBox;
        TextView title;
        LinearLayout layout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            checkBox = itemView.findViewById(R.id.checkbox);
            title = itemView.findViewById(R.id.note_title);
            layout = itemView.findViewById(R.id.layout);
        }

        void bind(int position){
            Notes item = list.get(position);

            if(item.isCompleted())
                checkBox.setChecked(true);
            else checkBox.setChecked(false);

            title.setText(item.getTitle());

            layout.setOnClickListener(view -> {

            });
        }
    }
}
