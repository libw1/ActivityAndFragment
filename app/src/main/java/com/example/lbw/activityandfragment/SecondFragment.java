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

public class SecondFragment extends Fragment {
    private EditText editText;
    private Button send;
    private TextView textView;
    private View view = null;
    private Send2Frist send2Frist;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_second,container,false);
        initView();
        if (getArguments() != null) {
            Bundle bundle = getArguments();
            textView.setText(bundle.getString("send"));
        }
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sendToFrist = editText.getText().toString();
                if (!sendToFrist.isEmpty()) {
                    send2Frist.send(sendToFrist);
                } else {
                    Toast.makeText(getContext(),"请输入发送内容",Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

    private void initView() {
        editText = (EditText)view.findViewById(R.id.edit_second);
        textView = (TextView)view.findViewById(R.id.second_text);
        send = (Button)view.findViewById(R.id.send_to_frist);
    }

    public interface Send2Frist {
        void send(String data);
    }

    public void setSend(Send2Frist send2Frist){
        this.send2Frist = send2Frist;
    }
}
