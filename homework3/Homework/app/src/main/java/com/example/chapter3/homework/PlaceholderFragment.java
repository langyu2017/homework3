package com.example.chapter3.homework;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.airbnb.lottie.LottieAnimationView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlaceholderFragment extends Fragment {

    private LottieAnimationView lottie;
    private ListView list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        View view = inflater.inflate(R.layout.fragment_placeholder, container, false);
        lottie = view.findViewById(R.id.animation_view);
        lottie.playAnimation();
        list = view.findViewById(R.id.lvItems);
        //list.setVisibility(list.INVISIBLE);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {

                String[] friendList ={"Item 1" ,"Item 2" ,"Item 3" ,"Item 4" ,"Item 5" ,"Item 6" ,"Item 7" ,"Item 8"  };
                List<String> friendL =new ArrayList<>(Arrays.asList(friendList));
                ArrayAdapter<String> friendAdapter = new ArrayAdapter<>(
                        getActivity(),
                        R.layout.list_item,
                        R.id.list_item_friends_tv,
                        friendL);
                list.setAdapter(friendAdapter);

                lottie.setAlpha(0f);
                list.setAlpha(1);

                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
            }
        }, 5000);
    }



}
