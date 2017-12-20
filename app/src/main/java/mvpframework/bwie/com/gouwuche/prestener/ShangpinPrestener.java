package mvpframework.bwie.com.gouwuche.prestener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;

import mvpframework.bwie.com.gouwuche.bean.AddCartBean;
import mvpframework.bwie.com.gouwuche.bean.GetCart;
import mvpframework.bwie.com.gouwuche.bean.ShangpinBean;
import mvpframework.bwie.com.gouwuche.model.IShangpinModel;
import mvpframework.bwie.com.gouwuche.model.ShangpinModel;
import mvpframework.bwie.com.gouwuche.net.OnNetListener;
import mvpframework.bwie.com.gouwuche.view.ISecondListener;
import mvpframework.bwie.com.gouwuche.view.IShangpinView;

/**
 * 张梦乔创建于 2017/12/18.
 * 10:34
 */

public class ShangpinPrestener {
    private IShangpinModel iShangpinModel;
    private IShangpinView iShangpinView;
    private ISecondListener iSecondListener;

    public ShangpinPrestener(IShangpinView iShangpinView) {
        this.iShangpinView = iShangpinView;
        iShangpinModel=new ShangpinModel();
    }

    public ShangpinPrestener(ISecondListener iSecondListener) {
        this.iSecondListener = iSecondListener;
        iShangpinModel=new ShangpinModel();
    }

    //查看商品
    public void doPost(){
        Map<String,String> params=new HashMap<>();
        params.put("pid","71");
        iShangpinModel.doPost(params, new OnNetListener<ShangpinBean>() {
            @Override
            public void onSuccess(ShangpinBean shangpinBean) {
                if (iShangpinView != null) {
                    iShangpinView.show(shangpinBean);
                }
            }

            @Override
            public void onFaliure(Exception e) {

            }
        });
    }
    //添加购物车
    public void addCart(){
        Map<String,String> params=new HashMap<>();
        params.put("pid", "71");
        params.put("uid", "70");
        iShangpinModel.doAdd(params, new OnNetListener<AddCartBean>() {
            @Override
            public void onSuccess(AddCartBean addCartBean) {
                if(iShangpinView!=null){
                    iShangpinView.addShwo(addCartBean.getCode().equals("0")?"添加成功":"添加失败了");
                }
            }

            @Override
            public void onFaliure(Exception e) {

            }
        });
    }
    //查看购物车
    public void getCart(){
        Map<String, String> params = new HashMap<>();
        params.put("uid", "1234");
        params.put("pid", "71");
        iShangpinModel.GetCart(params, new OnNetListener<GetCart>() {
            @Override
            public void onSuccess(GetCart getCart) {
                if (iSecondListener != null) {
                    List<GetCart.DataBean> group = getCart.getData();
                    List<List<GetCart.DataBean.ListBean>> child = new ArrayList<>();
                    for (int i = 0; i < group.size(); i++) {
                        child.add(group.get(i).getList());
                    }
                    iSecondListener.show(group, child);
                }
            }

            @Override
            public void onFaliure(Exception e) {

            }
        });
    }
}
