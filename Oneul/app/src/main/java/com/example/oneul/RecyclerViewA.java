package com.example.oneul;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

    public class RecyclerViewA extends RecyclerView.Adapter<RecyclerViewA.ViewHolder> {

        private String[] ddate = {"2019-11-01","2019-11-02","2019-11-03","2019-11-04","2019-11-05"
                ,"2019-11-06","2019-11-07","2019-11-08","2019-11-09","2019-11-10"};

        private String[] dcontent = {"행복한 하루였다.","기분좋은 하루였다.", "신나는 하루였다.", "화나는 하루였다.",
        "짜증나는 하루였다.", "황당한 하루였다.", "어이없는 하루였다.", "그저 그런 하루였다."};

        public class ViewHolder extends  RecyclerView.ViewHolder {
            public TextView date;
            public TextView contents;
            public ImageView emo;

            public ViewHolder(View view) {
                super(view);
                this.date = view.findViewById(R.id.date);
                this.contents = view.findViewById(R.id.content);
                this.emo = view.findViewById(R.id.emo);
            }
        }

        @Override
        public RecyclerViewA.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
            RecyclerViewA.ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(RecyclerViewA.ViewHolder holder, final int position) {
            holder.date.setText(ddate[position]);
            holder.contents.setText(dcontent[position]);

            holder.emo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), position+"번 째 이미지", Toast.LENGTH_SHORT).show();
                }
            });

            holder.contents.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Test!", Toast.LENGTH_SHORT).show();
                }
            });

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), position+"번 째!", Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return ddate.length;
        }
    }
