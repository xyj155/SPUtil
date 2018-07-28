package com.example.administrator.sputil;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.Map;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Administrator on 2018/7/28.
 */

public class SPUtil {
    private SharedPreferences.Editor editor;
    private static SPUtil sInstance;

    /**
     * 获取上下文
     * @return
     */
    public static Context getApplicationContext() {
        if (App.getInstance().getApplicationContext() == null) {
            return new App();
        }
        return App.getInstance().getApplicationContext();
    }

    public static SPUtil getInstance() {
        synchronized (SPUtil.class) {
            if (sInstance == null) {
                sInstance = new SPUtil();
            }
        }
        return sInstance;
    }


    public SPUtil() {
        editor = getApplicationContext().getSharedPreferences("user", MODE_PRIVATE).edit();
    }

    private static final String TAG = "SPUtil";

    public SPUtil saveSPData(Map<String, Object> value) {
        for (Map.Entry<String, Object> vo : value.entrySet()) {
            Log.i(TAG, "saveSPData: " + vo.getValue().getClass().toString());
            System.out.println(vo.getValue().getClass().toString());
            switch (vo.getValue().getClass().toString()) {
                //整型
                case "class java.lang.Integer":
                    editor.putInt(vo.getKey(), Integer.valueOf(vo.getValue().toString()));
                    break;
                //布尔型
                case "class java.lang.Boolean":
                    editor.putBoolean(vo.getKey(), Boolean.valueOf(vo.getValue().toString()));
                    break;
                //字符串型
                case "class java.lang.String":
                    editor.putString(vo.getKey(), vo.getValue().toString());
                    break;
                //浮点型
                case "class java.lang.Float":
                    editor.putFloat(vo.getKey(), Float.valueOf(vo.getValue().toString()));
                    break;
            }
        }

        return sInstance;
    }

    public void save() {
        editor.apply();
    }
}
