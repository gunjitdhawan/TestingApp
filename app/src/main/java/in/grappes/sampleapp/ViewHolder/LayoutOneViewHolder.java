package in.grappes.sampleapp.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import in.grappes.sampleapp.R;

/**
 * Created by GunjitDhawan on 3/4/2016.
 */
public class LayoutOneViewHolder extends RecyclerView.ViewHolder{

    public ImageView contentImage;

    public LayoutOneViewHolder(View itemView) {
        super(itemView);
        contentImage = (ImageView) itemView.findViewById(R.id.full_width_image);
    }
}
