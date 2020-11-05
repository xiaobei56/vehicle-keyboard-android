/*
 * Copyright (c) 2017. Xi'an iRain IOT Technology service CO., Ltd (ShenZhen). All Rights Reserved.
 */

package com.parkingwang.vehiclekeyboard.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parkingwang.keyboard.OnInputChangedListener;
import com.parkingwang.keyboard.PopupKeyboard;
import com.parkingwang.keyboard.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private InputView mInputView;
    private PopupKeyboard mPopupKeyboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInputView = findViewById(R.id.input_view);
        // 创建弹出键盘
        mPopupKeyboard = new PopupKeyboard(this);
        // 弹出键盘内部包含一个KeyboardView，在此绑定输入两者关联。
        mPopupKeyboard.attach(mInputView, this);
        mPopupKeyboard.getController().addOnInputChangedListener(new OnInputChangedListener() {
            @Override
            public void onChanged(String number, boolean isCompleted) {
                if (isCompleted) {
                    mPopupKeyboard.dismiss(MainActivity.this);
                }
            }
            @Override
            public void onCompleted(String number, boolean isAutoCompleted) {
                mPopupKeyboard.dismiss(MainActivity.this);
                Toast.makeText(MainActivity.this, number, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 默认选中第一个车牌号码输入框
        mInputView.performFirstFieldView();
    }
    public void onClick(View view) {
        int id = view.getId();
        // 切换键盘类型
        switch (id) {
            case R.id.show_dialog:
                new VehicleDialog().show(getSupportFragmentManager());
                break;
            case R.id.btn_show_car_input:

                break;
        }
    }
}
