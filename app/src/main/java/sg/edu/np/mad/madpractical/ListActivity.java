package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    static List<User> usersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        usersList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            usersList.add(new User(
                    "Name" + randomInt(),
                    "Description " + randomInt(),
                    i,
                    randomInt() % 2 == 1
            ));
        }

        RecyclerView recyclerView = findViewById(R.id.rv);

        UsersAdapter adapter = new UsersAdapter(usersList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        DividerItemDecoration divider = new DividerItemDecoration(recyclerView.getContext(), layoutManager.getOrientation());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(divider);
    }

    private int randomInt() {
        return new Random().nextInt();
    }
}