package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ImageView profileImage = findViewById(R.id.imageViewProfile);
        profileImage.setOnClickListener(v -> new AlertDialog.Builder(this)
                .setTitle("Profile")
                .setMessage("MADness")
                .setNegativeButton("close", null)
                .setPositiveButton("view", (dialog, which) -> {
                    Intent intent = new Intent(this, MainActivity.class);
                    intent.putExtra("id", new Random().nextInt());
                    startActivity(intent);
                })
                .show());
    }
}