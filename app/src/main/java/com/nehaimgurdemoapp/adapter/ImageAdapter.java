package com.nehaimgurdemoapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.nehaimgurdemoapp.R;
import com.nehaimgurdemoapp.model.Datum;
import com.nehaimgurdemoapp.utils.DateUtil;

import java.util.List;

//class to set values of the images to the list views
public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.MyViewHolder> {

    // class variables
    private List<Datum> mDataSet;
    private Context context;
    private OnItemClickListener listener;

    // Provide a suitable constructor (depends on the kind of dataset)
    public ImageAdapter(List<Datum> myDataset, Context context, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.listener = onItemClickListener;
        this.mDataSet = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public ImageAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                        int viewType) {
        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gallary_view, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // - get element from the dataset at this position
        // - replace the contents of the view with that element
        Datum item = mDataSet.get(position);

        holder.bind(item, listener);

        holder.titleTv.setText(item.getTitle());
        holder.countTv.setText(String.format("%d %s", item.getImagesCount(), context.getString(R.string.items)));
        holder.timeTv.setText(DateUtil.getDateTime(item.getDatetime()));

        if (item.getImagesCount() != null && item.getImagesCount() > 0) {
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.placeholder(R.drawable.placeholder);
            requestOptions.error(R.drawable.placeholder);
            Glide.with(context)
                    .load(item.getImages().get(0).getLink())
                    .apply(requestOptions)
                    .thumbnail(Glide.with(context).load(item.getImages().get(0).getLink()))
                    .into(holder.image);
        }

    }

    // Return the size of the dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    // OnItemClickListener to get details of the particular image when clicked on the view
    public interface OnItemClickListener {
        void onItemClick(Datum item);
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        // define view elements
        private TextView titleTv;
        private TextView timeTv;
        private TextView countTv;
        private ImageView image;


        // Initialise the each element of the view
        private MyViewHolder(View itemView) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.title_tv);
            timeTv = itemView.findViewById(R.id.date_tv);
            countTv = itemView.findViewById(R.id.count_tv);
            image = itemView.findViewById(R.id.image_view);

        }

        // Method to bind the onClickListener to the view
        private void bind(final Datum item, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }
}
