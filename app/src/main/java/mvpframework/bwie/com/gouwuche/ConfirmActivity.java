package mvpframework.bwie.com.gouwuche;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmActivity extends AppCompatActivity  implements View.OnClickListener {
    private TextView mTvLeft;
    /**
     * 立即下单
     */
    private Button mBt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        //接收传过来实付款
        Intent intent = getIntent();
        String money = intent.getStringExtra("money");
        initView();
        mTvLeft.setText("实付款：¥" + money);
    }

    private void initView() {
        mTvLeft = (TextView) findViewById(R.id.tvLeft);
        mBt = (Button) findViewById(R.id.bt);
        mBt.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt:
                //跳转到订单页面
                Intent intent = new Intent(ConfirmActivity.this, OrderActivity.class);
                startActivity(intent);
                break;
        }
    }
}
