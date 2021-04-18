package com.example.myapplication.entities.animations.slider;

import android.content.Context;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.viewpager.widget.PagerAdapter;

import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class ImagePagerAdapter extends PagerAdapter {

    private Context context;
    private List<Bitmap> images;

    public ImagePagerAdapter(Context context) {
        this.context = context;
        this.images = new ArrayList<>();
    }

    public void setImages(List<Bitmap> images) {
        this.images.addAll(images);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Bitmap image = images.get(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.activity_main, container, false);
        ImageView ivHeader = (ImageView) itemView.findViewById(R.id.iv_header);

        ivHeader.setImageBitmap(image);
        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}
