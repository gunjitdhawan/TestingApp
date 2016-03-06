package in.grappes.sampleapp.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import in.grappes.sampleapp.R;

/**
 * Created by GunjitDhawan on 3/4/2016.
 */
public class NestedLayoutViewHolder  extends RecyclerView.ViewHolder{

    public ImageView contentImage;

    public NestedLayoutViewHolder(View itemView) {
        super(itemView);
        contentImage = (ImageView) itemView.findViewById(R.id.nested_item_image);
    }
}
