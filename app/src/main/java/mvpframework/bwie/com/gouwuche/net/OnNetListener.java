package mvpframework.bwie.com.gouwuche.net;

/**
 * 张梦乔创建于 2017/12/18.
 * 8:51
 */

public interface OnNetListener<T> {
    public void onSuccess(T t);
    public void onFaliure(Exception e);
}
