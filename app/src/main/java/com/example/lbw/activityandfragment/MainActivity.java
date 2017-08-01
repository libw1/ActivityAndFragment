package com.example.lbw.activityandfragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FristFragment.CallBack,SecondFragment.Send2Frist{
    public FristFragment fristFragment;
    private SecondFragment secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //动态添加fragment
        final FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        fristFragment = new FristFragment();
        transaction.add(R.id.fragment,fristFragment);
        transaction.commit();
        //方法一(handler)
       /* Message message = new Message();
        message.what = 1;
        message.obj = "aaa";
        mHandler.sendMessage(message);*/
        //方式2(bundle)
        //方式3接口回调
        fristFragment.setCallBack(this);
        secondFragment = new SecondFragment();
        secondFragment.setSend(this);
    }


    @Override
    public void getData(String data) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString("send",data);
        secondFragment.setArguments(bundle);
        transaction.replace(R.id.fragment,secondFragment);
        transaction.commit();
    }

    @Override
    public void send(String data) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString("send to frist",data);
        fristFragment.setArguments(bundle);
        transaction.replace(R.id.fragment,fristFragment);
        transaction.commit();
    }
}
