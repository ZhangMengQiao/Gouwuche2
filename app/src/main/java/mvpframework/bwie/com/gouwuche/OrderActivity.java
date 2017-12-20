package mvpframework.bwie.com.gouwuche;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mvpframework.bwie.com.gouwuche.fragment.AllFragment;
import mvpframework.bwie.com.gouwuche.fragment.WaitFragment;

public class OrderActivity extends AppCompatActivity {
    /**
     * 全部
     */
    private TextView mTvAll;
    /**
     * 待支付
     */
    private TextView mTvWait;
    private LinearLayout mLl;
    private ViewPager mVp;
    private List<Fragment> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        initView();
        list.add(new AllFragment());
        list.add(new WaitFragment());
        mVp.setAdapter(new MyAdapter(getSupportFragmentManager()));
    }

    private void initView() {
        mTvAll = (TextView) findViewById(R.id.tvAll);
        mTvWait = (TextView) findViewById(R.id.tvWait);
        mLl = (LinearLayout) findViewById(R.id.ll);
        mVp = (ViewPager) findViewById(R.id.vp);
    }
    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }
}
