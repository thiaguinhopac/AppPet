package com.example.myapplication.entities.animations.slider;


    import android.os.Bundle;
import android.support.v4.view.ViewPager;

    import androidx.appcompat.app.AppCompatActivity;

    import com.example.myapplication.R;

    import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Slider extends AppCompatActivity {

        private ViewPager viewPager;
        private CirclePageIndicator pagerIndicator;

        private ImagePagerAdapter imagePagerAdapter;

        private Timer timer;

        private List<String> images;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            viewPager = (ViewPager) findViewById(R.id.pager);
            pagerIndicator = (CirclePageIndicator) findViewById(R.id.indicator);

            imagePagerAdapter = new ImagePagerAdapter(this);

            viewPager.setAdapter(imagePagerAdapter);
            pagerIndicator.setViewPager(viewPager);

            images = new ArrayList<>();
            images.add("https://scontent.fcgk12-1.fna.fbcdn.net/v/t1.0-9/30260981_1697358283684452_5345280777774956544_n.jpg?_nc_cat=0&oh=780b2eba44f38c3400b8e219060b3278&oe=5C08A56E");
            images.add("https://scontent.fcgk12-1.fna.fbcdn.net/v/t1.0-9/30412288_1697358530351094_6652467221207449600_n.jpg?_nc_cat=0&oh=9c39ae9327064d3c21490a556acf28a3&oe=5C137E2E");
            images.add("https://scontent.fcgk12-1.fna.fbcdn.net/v/t1.0-9/30412267_1697358943684386_6572812530102566912_n.jpg?_nc_cat=0&oh=1876343af22cad2f49d352343eb3eb6b&oe=5C12B116");
            images.add("https://scontent.fcgk12-1.fna.fbcdn.net/v/t1.0-9/30261069_1697359000351047_8720462127048949760_n.jpg?_nc_cat=0&oh=44a1c82bebff0f61b811ef2bb94b3196&oe=5BC978E2");

            imagePagerAdapter.setImages(images);

            timer = new Timer();
            timer.scheduleAtFixedRate(new SliderTimer(), 3000, 5000);
        }

        private class SliderTimer extends TimerTask {

            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (viewPager.getCurrentItem() < imagePagerAdapter.getCount() - 1) {
                            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                        } else {
                            viewPager.setCurrentItem(0);
                        }
                    }
                });
            };
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();

            timer.cancel();
        }

}
