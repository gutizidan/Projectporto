package com.example.projectporto;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.JadwalViewHolder> {
    private Context mContext;
    private List<Model> dataList;

    public Adapter(Context mContext, List<Model> dataList) {
        this.dataList = dataList;
        this.mContext = mContext;

    }

    @NonNull
    @Override
    public JadwalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.recyclerlist, parent, false);
        return new JadwalViewHolder(view);
    }
    @Override
    public void onBindViewHolder(JadwalViewHolder holder, int position) {
        final Model surah = dataList.get(position);


        holder.title.setText(surah.getTitle());
        holder.desc.setText(surah.getDesc());
        Glide.with(holder.itemView.getContext())
                .load(surah.getUrl())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.img);

    }

    @Override
    public int getItemCount() {
        return dataList.size();

    }

    @Override
    public long getItemId(int position) {
        return (long) position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
    public class JadwalViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        private TextView title, desc;

        public JadwalViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.Titleberita);
            desc = (TextView) itemView.findViewById(R.id.deskripsi);
            img = itemView.findViewById(R.id.urlgambard);
        }
    }
}
