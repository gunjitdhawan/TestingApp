package in.grappes.sampleapp.ViewHolder;

/**
 * Created by GunjitDhawan on 3/4/2016.
 */

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import in.grappes.sampleapp.R;

/**
 * Created by GunjitDhawan on 3/4/2016.
 */
public class LayoutTwoViewHolder extends RecyclerView.ViewHolder{

    public RecyclerView nestedHorizontalRecyclerView;

    public LayoutTwoViewHolder(View itemView) {
        super(itemView);
        nestedHorizontalRecyclerView = (RecyclerView) itemView.findViewById(R.id.recycler_view_type_2);
        nestedHorizontalRecyclerView.setLayoutManager(new LinearLayoutManager(nestedHorizontalRecyclerView.getContext(), LinearLayoutManager.HORIZONTAL, false));
        nestedHorizontalRecyclerView.setNestedScrollingEnabled(false);
        nestedHorizontalRecyclerView.setAdapter(null);

    }
}
