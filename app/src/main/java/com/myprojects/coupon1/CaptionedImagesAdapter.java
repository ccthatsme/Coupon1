package com.myprojects.coupon1;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class CaptionedImagesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private CardView cardView;
        private ImageView iv;
        private TextView tv;

        public ViewHolder(@NonNull View v) {
            super(v);
            cardView = v.findViewById(R.id.card_view);
            this.cardView = cardView;

           ImageView iv = (ImageView) cardView.getChildAt(0);
            TextView tv = (TextView) cardView.getChildAt(1);


        }
    }

    private Bitmap[] images;
    private String[] descriptions;

    public CaptionedImagesAdapter(Bitmap[] images, String[] descriptions) {
        this.images = images;
        this.descriptions = descriptions;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_captioned_image,parent,false);
        return new ViewHolder(cv);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CardView cardView = (CardView) holder.itemView;

        //what i did on line 57 do here specifically for textview and imageview?
       // ImageView imageView = (ImageView) holder.itemView;


        ImageView imageView = cardView.findViewById(R.id.info_image);



        imageView.setImageBitmap(images[position]);

        TextView textView = cardView.findViewById(R.id.info_text);
        textView.setText(descriptions[position]);
    }

    @Override
    public int getItemCount() {
        return descriptions.length;
    }
}
