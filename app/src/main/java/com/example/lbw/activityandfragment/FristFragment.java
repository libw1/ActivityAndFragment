package com.example.lbw.activityandfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by lbw on 2017/8/1.
 */

public class FristFragment extends Fragment {
    private TextView textView;
    private CallBack callBack;
    private Button send;
    private EditText editText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frist,container,false);
        textView = (TextView)view.findViewById(R.id.text_view);
        editText = (EditText)view.findViewById(R.id.edit);
        send = (Button)view.findViewById(R.id.send_to_second);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sendText = editText.getText().toString();
                if (!sendText.isEmpty()) {
                    callBack.getData(sendText);
                }else {
                    Toast.makeText(getContext(),"请输入发送内容",Toast.LENGTH_SHORT).show();
                }
            }
        });
        if (getArguments() != null) {
            Bundle bundle = getArguments();
            String s = bundle.getString("send to frist");
            textView.setText(s);
        }
        return view;
    }

    public interface CallBack{
        void getData(String data);
    }

    public void setCallBack(CallBack callBack){
        this.callBack = callBack;
    }
}
