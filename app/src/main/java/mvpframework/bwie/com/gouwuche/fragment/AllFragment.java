package mvpframework.bwie.com.gouwuche.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.io.IOException;

import mvpframework.bwie.com.gouwuche.R;
import mvpframework.bwie.com.gouwuche.adapter.RvAllAdapter;
import mvpframework.bwie.com.gouwuche.bean.OrderBean;
import mvpframework.bwie.com.gouwuche.net.HttpUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 张梦乔创建于 2017/12/20.
 * 19:28
 */

public class AllFragment extends Fragment {

    private RecyclerView rv;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all, null);
        rv = view.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        String url = "https://www.zhaoapi.cn/product/getOrders?uid=71";
        HttpUtils.getHttpUtils().doGet(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }



            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                final OrderBean orderBean = new Gson().fromJson(string, OrderBean.class);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        RvAllAdapter adapter = new RvAllAdapter(getContext(), orderBean.getData());
                        rv.setAdapter(adapter);
                    }
                });
            }
        });
        return view;
    }
}
