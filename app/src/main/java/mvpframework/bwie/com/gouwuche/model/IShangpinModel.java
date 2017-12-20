package mvpframework.bwie.com.gouwuche.model;

import java.util.Map;

import mvpframework.bwie.com.gouwuche.bean.AddCartBean;
import mvpframework.bwie.com.gouwuche.bean.GetCart;
import mvpframework.bwie.com.gouwuche.bean.ShangpinBean;
import mvpframework.bwie.com.gouwuche.net.OnNetListener;

/**
 * 张梦乔创建于 2017/12/18.
 * 9:12
 */

public interface IShangpinModel {
    public void doPost(Map<String,String> params, OnNetListener<ShangpinBean> onNetListener);
    public void doAdd(Map<String,String> params, OnNetListener<AddCartBean> onNetListener);
    public void GetCart(Map<String,String> params, OnNetListener<GetCart> onNetListener);
}
