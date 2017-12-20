package mvpframework.bwie.com.gouwuche.view;

import java.util.List;

import mvpframework.bwie.com.gouwuche.bean.GetCart;

/**
 * 张梦乔创建于 2017/12/18.
 * 15:00
 */

public interface ISecondListener {
    void show(List<GetCart.DataBean> group,List<List<GetCart.DataBean.ListBean>> child);
}
