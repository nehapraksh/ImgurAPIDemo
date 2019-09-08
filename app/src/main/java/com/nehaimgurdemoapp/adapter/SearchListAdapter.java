package com.nehaimgurdemoapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.nehaimgurdemoapp.R;

import java.util.ArrayList;
import java.util.List;

public class SearchListAdapter extends BaseAdapter implements Filterable {

    private List<String> titleArrayList;
    private Context mContext;
    private List<String> orig;

    public SearchListAdapter(Context context, List<String> titleList) {
        this.mContext = context;
        this.titleArrayList = titleList;
    }

    public class ViewHolder {
        TextView title;
    }

    public Filter getFilter() {
        return new Filter() {

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                final FilterResults oReturn = new FilterResults();
                final ArrayList<String> results = new ArrayList<String>();
                if (orig == null)
                    orig = titleArrayList;
                if (constraint != null) {
                    if (orig != null && orig.size() > 0) {
                        for (final String g : orig) {
                            if (g.toLowerCase()
                                    .contains(constraint.toString()))
                                results.add(g);
                        }
                    }
                    oReturn.values = results;
                }
                return oReturn;
            }

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint,
                                          FilterResults results) {
                titleArrayList = (ArrayList<String>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return titleArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return titleArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.search_view, parent, false);
            holder = new ViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.txtName);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        return convertView;

    }

}

