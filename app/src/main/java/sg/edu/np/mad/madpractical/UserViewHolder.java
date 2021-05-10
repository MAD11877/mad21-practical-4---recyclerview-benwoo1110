package sg.edu.np.mad.madpractical;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {

    ImageView image;
    TextView name;
    TextView description;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);

        this.image = itemView.findViewById(R.id.image_profile);
        this.name = itemView.findViewById(R.id.name);
        this.description = itemView.findViewById(R.id.description);
    }

}
