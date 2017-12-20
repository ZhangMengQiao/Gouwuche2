package mvpframework.bwie.com.gouwuche.model;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;

import mvpframework.bwie.com.gouwuche.bean.AddCartBean;
import mvpframework.bwie.com.gouwuche.bean.GetCart;
import mvpframework.bwie.com.gouwuche.bean.ShangpinBean;
import mvpframework.bwie.com.gouwuche.net.Api;
import mvpframework.bwie.com.gouwuche.net.HttpUtils;
import mvpframework.bwie.com.gouwuche.net.OnNetListener;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 张梦乔创建于 2017/12/18.
 * 10:32
 */

public class ShangpinModel implements IShangpinModel {
    private Handler handler=new Handler(Looper.getMainLooper());
    //查看商品
    @Override
    public void doPost(Map<String, String> params, final OnNetListener<ShangpinBean> onNetListener) {
        HttpUtils.getHttpUtils().doPost(Api.str1, params, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final ShangpinBean shangpinBean = new Gson().fromJson(response.body().string(), ShangpinBean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.onSuccess(shangpinBean);
                    }
                });
            }
        });
    }

    //加入购物车
    @Override
    public void doAdd(Map<String, String> params, final OnNetListener<AddCartBean> onNetListener) {
        ; HttpUtils.getHttpUtils().doPost(Api.str1, params, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final AddCartBean addCartBean = new Gson().fromJson(response.body().string(), AddCartBean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.onSuccess(addCartBean);
                    }
                });
            }
        });
    }

    //查询购物车
    @Override
    public void GetCart(Map<String, String> params, final OnNetListener<GetCart> onNetListener) {
        HttpUtils.getHttpUtils().doPost(Api.str2, params, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final GetCart getCart = new Gson().fromJson(response.body().string(), GetCart.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.onSuccess(getCart);
                    }
                });
            }
        });
    }
}
