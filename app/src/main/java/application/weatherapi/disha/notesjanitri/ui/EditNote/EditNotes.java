package application.weatherapi.disha.notesjanitri.ui.EditNote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import application.weatherapi.disha.notesjanitri.R;
import application.weatherapi.disha.notesjanitri.data.local.Notes;
import application.weatherapi.disha.notesjanitri.ui.ViewNotes.ViewNotes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class EditNotes extends AppCompatActivity {

    TextView title;
    EditNotesViewModel viewModel;
    EditText body;
    FloatingActionButton fab;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_notes);

        init();

        viewModel.getData(id);

        viewModel.isDataSet.observe(this, aBoolean -> {
            if (aBoolean)
                setData(viewModel.notes);
        });

        fab.setOnClickListener(view -> {
            viewModel.notes.setNotesBody(body.getText().toString());
            viewModel.notes.setCompleted(false);
            viewModel.updateNotes(viewModel.notes);

            startActivity(new Intent(this, ViewNotes.class));

            finish();
        });
    }

    private void setData(Notes notes) {
        title.setText(notes.getTitle());
        body.setText(notes.getNotesBody());
    }

    private void init() {
        title = findViewById(R.id.title);
        body = findViewById(R.id.body);
        fab = findViewById(R.id.save_button);
        id = getIntent().getExtras().getInt("id");
        viewModel = new ViewModelProvider(this).get(EditNotesViewModel.class);
    }
}
