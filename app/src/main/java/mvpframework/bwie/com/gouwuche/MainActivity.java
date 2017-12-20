package mvpframework.bwie.com.gouwuche;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import mvpframework.bwie.com.gouwuche.bean.ShangpinBean;
import mvpframework.bwie.com.gouwuche.prestener.ShangpinPrestener;
import mvpframework.bwie.com.gouwuche.view.IShangpinView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener ,IShangpinView{

    private ImageView mIv;
    private TextView mTvBargainPrice;
    private TextView mTvPrice;
    /**
     * 购物车
     */
    private TextView mTvCart;
    /**
     * 加入购物车
     */
    private TextView mTvAddCart;

    private ShangpinPrestener shangpinPrestener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        shangpinPrestener=new ShangpinPrestener(this);
        shangpinPrestener.doPost();

    }

    private void initView() {
        mIv = (ImageView) findViewById(R.id.iv);
        mIv.setOnClickListener(this);
        mTvBargainPrice = (TextView) findViewById(R.id.tvBargainPrice);
        mTvBargainPrice.setOnClickListener(this);
        mTvPrice = (TextView) findViewById(R.id.tvPrice);
        mTvPrice.setOnClickListener(this);
        mTvCart = (TextView) findViewById(R.id.tvCart);
        mTvCart.setOnClickListener(this);
        mTvAddCart = (TextView) findViewById(R.id.tvAddCart);
        mTvAddCart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tvCart:
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
                break;
            case R.id.tvAddCart:
                shangpinPrestener.addCart();
                break;
        }
    }

    @Override
    public void show(ShangpinBean shangpinBean) {
        String images = shangpinBean.getData().getImages();
        String[] split = images.split("\\|");
        Glide.with(this).load(split[0]).into(mIv);

        mTvBargainPrice.setText("原价："+shangpinBean.getData().getPrice());
        mTvPrice.setText("优惠价："+shangpinBean.getData().getBargainPrice());
    }

    @Override
    public void addShwo(String str) {
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }
}
