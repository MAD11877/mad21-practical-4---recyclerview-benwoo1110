package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        List<User> userData = new ArrayList<User>() {{
            add(new User("81234", "khjsdaf", 1, false));
            add(new User("3456", "khjsdaf", 1, false));
            add(new User("812547834", "khjsdaf", 1, false));
            add(new User("2345", "khjsdaf", 1, true));
            add(new User("6789", "khjsdaf", 1, false));
            add(new User("81237", "khjsdaf", 1, false));
            add(new User("3456", "khjsdaf", 1, false));
            add(new User("812547834", "khjsdaf", 1, false));
            add(new User("2345", "khjsdaf", 1, true));
            add(new User("6789", "khjsdaf", 1, false));
        }};

        RecyclerView recyclerView = findViewById(R.id.rv);

        UsersAdapter adapter = new UsersAdapter(userData);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        DividerItemDecoration divider = new DividerItemDecoration(recyclerView.getContext(), layoutManager.getOrientation());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(divider);
    }
}