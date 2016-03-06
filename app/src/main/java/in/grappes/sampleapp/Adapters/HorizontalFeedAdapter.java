package in.grappes.sampleapp.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import in.grappes.sampleapp.Model.Item;
import in.grappes.sampleapp.ViewHolder.NestedLayoutViewHolder;
import in.grappes.sampleapp.R;

/**
 * Created by GunjitDhawan on 3/4/2016.
 */
public class HorizontalFeedAdapter extends RecyclerView.Adapter {

    private static final int VIEW_ITEM_2 = 2;
    private static final int VIEW_ITEM_3 = 3;
    List<Item> feedList;
    Context context;
    int template;

    public HorizontalFeedAdapter(List<Item> feedList, final Context context, int template) {
        this.context = context;
        this.feedList = feedList;
        this.template = template;
    }

    @Override
    public int getItemViewType(int position) {
        if(template==2)
            return  VIEW_ITEM_2;
        else
            return VIEW_ITEM_3;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        if(viewType == VIEW_ITEM_2) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.sub_item_template_2, parent, false);

            vh = new NestedLayoutViewHolder(view);
        }
        else
        {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.sub_item_template_3, parent, false);

            vh = new NestedLayoutViewHolder(view);
        }

        return vh;

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, int i) {
        final Item feed = feedList.get(i);
        Glide.with(context).load(feed.getItemImageLink()).placeholder(R.drawable.placeholder).into(((NestedLayoutViewHolder) viewHolder).contentImage);
    }

    @Override
    public int getItemCount() {
        return feedList.size();
    }

}
