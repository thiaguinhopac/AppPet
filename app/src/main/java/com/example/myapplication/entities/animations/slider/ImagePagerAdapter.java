package com.example.myapplication.entities.animations.slider;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kwikkunusantara on 8/10/18.
 */

public class ImagePagerAdapter extends PagerAdapter {

    private Context context;
    private List<String> images;

    public ImagePagerAdapter(Context context) {
        this.context = context;
        this.images = new ArrayList<>();
    }

    public void setImages(List<String> images) {
        for (int i = 0; i < images.size(); i++){
            this.images.add(images.get(i));
        }
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
        String image = images.get(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.activity_main, container, false);
        ImageView ivHeader = (ImageView) itemView.findViewById(R.id.iv_header);

        Picasso.with(context)
                .load(image)
                .into(ivHeader);

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}
