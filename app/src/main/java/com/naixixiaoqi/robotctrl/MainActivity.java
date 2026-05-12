package com.naixixiaoqi.robotctrl;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

    // 电机、灯光、模式控制UI
    private SeekBar motorAngleSeek;
    private Button lightOnBtn;
    private Button lightOffBtn;
    private ToggleButton modeSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        bindEvent();
    }

    // 初始化界面控件
    private void initView(){
        motorAngleSeek = findViewById(R.id.motorAngleSeek);
        lightOnBtn = findViewById(R.id.lightOnBtn);
        lightOffBtn = findViewById(R.id.lightOffBtn);
        modeSwitch = findViewById(R.id.modeSwitch);
    }

    // 绑定所有点击、滑动事件
    private void bindEvent(){
        // 电机角度调节（左右各30度，匹配GA12-N20电机设定）
        motorAngleSeek.setMax(60);
        motorAngleSeek.setProgress(30);
        motorAngleSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int realAngle = progress - 30;
                sendMotorAngle(realAngle);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        // 灯光开关
        lightOnBtn.setOnClickListener(v -> setLight(true));
        lightOffBtn.setOnClickListener(v -> setLight(false));

        // 身份模式切换
        modeSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> switchMode(isChecked));
    }

    // 发送电机角度指令给ESP32
    private void sendMotorAngle(int angle){
        // 预留蓝牙/串口通信接口
    }

    // 控制底座+兔耳朵磁吸灯光
    private void setLight(boolean isOn){
        // 预留灯光控制通信接口
    }

    // 切换拟人/行车姿态联动模式
    private void switchMode(boolean advanced){
        // 预留模式切换逻辑
    }
}