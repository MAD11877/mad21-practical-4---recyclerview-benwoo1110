package sg.edu.np.mad.madpractical;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private User user;
    private int random;

    private TextView textViewName;
    private TextView textViewDescription;
    private Button buttonFollow;
    private Button buttonMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.random = getIntent().getIntExtra("id", 0);

        this.textViewName = findViewById(R.id.textViewName);
        this.textViewDescription = findViewById(R.id.textViewDescription);
        this.buttonFollow = findViewById(R.id.buttonFollow);
        this.buttonMessage = findViewById(R.id.buttonMessage);

        User dummyUser = new User("Ben", "Code. Create. Coordinate.",  1, false);
        this.setUser(dummyUser);
        this.buttonFollow.setOnClickListener(v -> {
            this.user.setFollowed(!this.user.isFollowed());
            this.updateUserFollowState();
        });
    }

    private void setUser(User user) {
        this.user = user;
        this.updateUserInfo();
        this.updateUserFollowState();
    }

    private void updateUserInfo() {
        this.textViewName.setText(user.getName() + " " + this.random);
        this.textViewDescription.setText(user.getDescription());
    }

    private void updateUserFollowState() {
        if (this.user.isFollowed()) {
            Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();
            this.buttonFollow.setText(R.string.unfollow);
            return;
        }
        Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();
        this.buttonFollow.setText(R.string.follow);
    }
}