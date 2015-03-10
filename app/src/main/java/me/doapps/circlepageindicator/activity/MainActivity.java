package me.doapps.circlepageindicator.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.viewpagerindicator.CirclePageIndicator;

import me.doapps.circlepageindicator.R;
import me.doapps.circlepageindicator.fragment.ImageFragment;


public class MainActivity extends ActionBarActivity {
    private FragmentAdapter fragmentAdapter;
    private ViewPager viewPager;
    private CirclePageIndicator circlePageIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager)findViewById(R.id.viewPager);
        circlePageIndicator = (CirclePageIndicator)findViewById(R.id.circlePageIndicator);

        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager());

        viewPager.setAdapter(fragmentAdapter);
        circlePageIndicator.setViewPager(viewPager);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /*Adapter*/
    class FragmentAdapter extends FragmentPagerAdapter {

        int[] id_mensajes = {R.string.image_text_uno,R.string.image_text_dos,R.string.image_text_tres};
        int[] id_images = {R.drawable.noti2,R.drawable.noti3,R.drawable.noti4};

        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return ImageFragment.newInstance(id_images[position], id_mensajes[position]);
        }

        @Override
        public int getCount() {
            return id_images.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return id_images + "";
        }

        @Override
        public void destroyItem(View container, int position, Object object) {
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
        }
    }
}
