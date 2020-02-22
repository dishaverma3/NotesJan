package application.weatherapi.disha.notesjanitri.ui.ViewNotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import application.weatherapi.disha.notesjanitri.R;
import application.weatherapi.disha.notesjanitri.data.local.Notes;

import android.os.Bundle;
import android.view.View;

import java.util.Collections;
import java.util.List;

public class ViewNotes extends AppCompatActivity {

    ViewNotesViewModel viewModel;
    RecyclerView recyclerView;
    NotesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_notes);

        init();

        viewModel.getAllNotes();

        viewModel.isListSet.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean)
                    setRecyclerView(viewModel.list);
            }
        });

    }

    private void setRecyclerView(List<Notes> list) {
        if(list.size() != 0)
        {
            adapter = new NotesAdapter(list,getApplicationContext());
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);

        }else {
            recyclerView.setVisibility(View.GONE);
        }

    }

    private void init() {
        viewModel = new ViewModelProvider(this).get(ViewNotesViewModel.class);
        recyclerView = findViewById(R.id.recycler);
    }
}
