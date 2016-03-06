package in.grappes.sampleapp.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.lsjwzh.widget.recyclerviewpager.RecyclerViewPager;

import in.grappes.sampleapp.R;

/**
 * Created by GunjitDhawan on 3/4/2016.
 */
public class LayoutThreeViewHolder extends RecyclerView.ViewHolder{

    public RecyclerViewPager nestedHorizontalRecyclerView;
    public LinearLayout indicator;

    public LayoutThreeViewHolder(View itemView) {
        super(itemView);
        nestedHorizontalRecyclerView = (RecyclerViewPager) itemView.findViewById(R.id.recycler_view_type_3);
        indicator = (LinearLayout) itemView.findViewById(R.id.indicator);



    }
}
