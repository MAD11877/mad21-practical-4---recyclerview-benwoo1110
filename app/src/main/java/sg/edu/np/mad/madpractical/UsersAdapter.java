package sg.edu.np.mad.madpractical;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Random;

public class UsersAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private final List<User> users;

    public UsersAdapter(List<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layoutType = viewType == 1 ? R.layout.rv_item : R.layout.rv_item_2;
        View item = LayoutInflater.from(parent.getContext()).inflate(layoutType, parent, false);
        return new UserViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        User targetUser = this.users.get(position);
        holder.name.setText(targetUser.name);
        holder.description.setText(targetUser.description);
        holder.image.setOnClickListener(v -> new AlertDialog.Builder(context)
                .setTitle("Profile")
                .setMessage(targetUser.name)
                .setNegativeButton("close", null)
                .setPositiveButton("view", (dialog, which) -> {
                    Intent intent = new Intent(context, MainActivity.class);
                    intent.putExtra("id", position);
                    context.startActivity(intent);
                })
                .show());
    }

    @Override
    public int getItemViewType(int position) {
        return this.users.get(position).name.endsWith("7") ? 0 : 1;
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
