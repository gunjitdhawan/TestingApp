package in.grappes.sampleapp.Adapters;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lsjwzh.widget.recyclerviewpager.RecyclerViewPager;

import java.util.List;

import in.grappes.sampleapp.ViewHolder.LayoutOneViewHolder;
import in.grappes.sampleapp.ViewHolder.LayoutThreeViewHolder;
import in.grappes.sampleapp.ViewHolder.LayoutTwoViewHolder;
import in.grappes.sampleapp.Model.Category;
import in.grappes.sampleapp.R;


/**
 * Created by GunjitDhawan on 2/26/2016.
 */
public class VerticalFeedAdapter extends RecyclerView.Adapter {

    List<Category> feedList;
    Context context;

    private final int VIEW_ITEM_1 = 1;
    private final int VIEW_ITEM_2 = 2;
    private final int VIEW_ITEM_3 = 3;


    public VerticalFeedAdapter(List<Category> feedList, final Context context) {
        this.context = context;
        this.feedList = feedList;

    }

    @Override
    public int getItemViewType(int position) {
        if (feedList.get(position).getTemplate().equalsIgnoreCase("product-template-1"))
            return VIEW_ITEM_1;
        else if (feedList.get(position).getTemplate().equalsIgnoreCase("product-template-2"))
            return VIEW_ITEM_2;
        else
            return VIEW_ITEM_3;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        if (viewType == VIEW_ITEM_1) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.item_layout_1, parent, false);

            vh = new LayoutOneViewHolder(view);
        } else if (viewType == VIEW_ITEM_2) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.item_layout_2, parent, false);

            vh = new LayoutTwoViewHolder(view);
        } else {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.item_layout_3, parent, false);

            vh = new LayoutThreeViewHolder(view);
        }
        return vh;

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, int i) {
        final Category categoryFeed = feedList.get(i);
        if (viewHolder instanceof LayoutOneViewHolder) {

            try {
                Glide.with(context).load(categoryFeed.getItem().get(0).getItemImageLink()).placeholder(R.drawable.placeholder).into(((LayoutOneViewHolder) viewHolder).contentImage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (viewHolder instanceof LayoutThreeViewHolder) {

            HorizontalFeedAdapter hfd = new HorizontalFeedAdapter(categoryFeed.getItem(), context, 3);
            LinearLayoutManager layout = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            ((LayoutThreeViewHolder) viewHolder).nestedHorizontalRecyclerView.setLayoutManager(layout);
            ((LayoutThreeViewHolder) viewHolder).nestedHorizontalRecyclerView.setAdapter(hfd);
            ((LayoutThreeViewHolder) viewHolder).nestedHorizontalRecyclerView.setNestedScrollingEnabled(false);

            for(int j = 0;j<categoryFeed.getItem().size();j++)
            {
                if(j==0)
                {
                    ImageView img = new ImageView(context);
                    img.setLayoutParams(new ViewGroup.LayoutParams(50,50));
                    img.setImageResource(R.drawable.filled_circle);
                    img.setPadding(10, 10, 10, 10);
                    ((LayoutThreeViewHolder) viewHolder).indicator.addView(img);
                }
                else {
                    ImageView img = new ImageView(context);
                    img.setLayoutParams(new ViewGroup.LayoutParams(50, 50));
                    img.setImageResource(R.drawable.not_selected);
                    img.setPadding(10, 10, 10, 10);
                    ((LayoutThreeViewHolder) viewHolder).indicator.addView(img);
                }
            }

            ((LayoutThreeViewHolder) viewHolder).nestedHorizontalRecyclerView.addOnPageChangedListener(new RecyclerViewPager.OnPageChangedListener() {
                @Override
                public void OnPageChanged(int i, int i1) {
                    ((LayoutThreeViewHolder) viewHolder).indicator.removeAllViewsInLayout();
                    for(int j = 0;j<categoryFeed.getItem().size();j++)
                    {

                        if(j==i1) {
                            ImageView img = new ImageView(context);
                            img.setLayoutParams(new ViewGroup.LayoutParams(50, 50));
                            img.setImageResource(R.drawable.filled_circle);
                            img.setPadding(10, 10, 10, 10);
                            ((LayoutThreeViewHolder) viewHolder).indicator.addView(img);
                        }
                        else
                        {
                            ImageView img = new ImageView(context);
                            img.setLayoutParams(new ViewGroup.LayoutParams(50, 50));
                            img.setImageResource(R.drawable.not_selected);
                            img.setPadding(10, 10, 10, 10);
                            ((LayoutThreeViewHolder) viewHolder).indicator.addView(img);
                        }
                    }

                }
            });
            hfd.notifyDataSetChanged();


        } else {
            HorizontalFeedAdapter horizontalFeedAdapter = new HorizontalFeedAdapter(categoryFeed.getItem(), context, 2);
            ((LayoutTwoViewHolder) viewHolder).nestedHorizontalRecyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            ((LayoutTwoViewHolder) viewHolder).nestedHorizontalRecyclerView.setAdapter(horizontalFeedAdapter);
            ((LayoutTwoViewHolder) viewHolder).nestedHorizontalRecyclerView.setNestedScrollingEnabled(false);
            horizontalFeedAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        return feedList.size();
    }

}
