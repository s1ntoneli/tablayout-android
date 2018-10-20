package com.antiless.support.samples;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.antiless.support.widget.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new ContentPagerAdapter());
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    public static class ContentPagerAdapter extends PagerAdapter {
        private static final int PAGE_COUNT = 3;
        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            TextView textView = new TextView(container.getContext());
            textView.setText(getPageTitle(position));
            container.addView(textView);
            return textView;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            if (((View) object).getParent() == container) {
                container.removeView((View) object);
            }
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return "Tab-" + position;
        }
    }
}
