 package com.jinhao.test.myapplication;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.util.List;

 public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //准备显示信息的UI组件
         TextView tx1 =(TextView)findViewById(R.id.TextView01);
         tx1.setMovementMethod(ScrollingMovementMethod.getInstance());

        //从系统服务获得传感器管理器
        SensorManager sm = (SensorManager)getSystemService(Context.SENSOR_SERVICE);

        //从传感器管理器中获得全部的传感器列表
        List<Sensor> allSsensors=sm.getSensorList(Sensor.TYPE_ALL);

        //显示有多少个传感器
        tx1.setText("检查到该设备拥有"+allSsensors.size()+"种传感器，相关传感器信息为：\n");

        //显示每个传感器的具体信息
        for (Sensor s:allSsensors){
            String tempSting ="\n"+"设备名称："+s.getName()+"\n"+"设备版本："+s.getVersion()+"\n"+"制造厂商："+s.getVendor()+"\n\n";
            switch (s.getType()){
                case Sensor.TYPE_ACCELEROMETER:
                    tx1.setText(tx1.getText().toString()+s.getType()+"加速度传感器 Accelerometer"+tempSting);
                    break;
                case Sensor.TYPE_GYROSCOPE:
                    tx1.setText(tx1.getText().toString()+s.getType()+"陀螺仪传感器 Gyroscope"+tempSting);
                    break;
                case Sensor.TYPE_LIGHT:
                    tx1.setText(tx1.getText().toString()+s.getType()+"光线感应传感器 Light"+tempSting);
                    break;
                case Sensor.TYPE_MAGNETIC_FIELD:
                    tx1.setText(tx1.getText().toString()+s.getType()+"电磁场传感器 Magnetic field"+tempSting);
                    break;
                case Sensor.TYPE_ORIENTATION:
                    tx1.setText(tx1.getText().toString()+s.getType()+"方向传感器 Orientation"+tempSting);
                    break;
                case Sensor.TYPE_PRESSURE:
                    tx1.setText(tx1.getText().toString()+s.getType()+"压力感应传感器 Pressure"+tempSting);
                    break;
                case Sensor.TYPE_PROXIMITY:
                    tx1.setText(tx1.getText().toString()+s.getType()+"距离感应传感器 Proximity"+tempSting);
                    break;
                case Sensor.TYPE_AMBIENT_TEMPERATURE:
                    tx1.setText(tx1.getText().toString()+s.getType()+"温度传感器 Temperature"+tempSting);
                    break;
                default:tx1.setText(tx1.getText().toString()+s.getType()+"目前软件还不能识别的传感器"+tempSting);
                    break;
            }


    }
    }


}
