package com.example.administrator.sputil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       final EditText tv= (EditText) findViewById(R.id.tv);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = tv.getText().toString();
                Map<String, Object> map = new HashMap<>();
                map.put("username", s);
                map.put("login", false);
                map.put("float", 1.00);
                map.put("int", 100);
                SPUtil.getInstance().saveSPData(map).save();
            }
        });
    }
}
