package com.mrljdx.androidlua;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.keplerproject.luajava.LuaState;
import org.keplerproject.luajava.LuaStateFactory;

/**
 * Created by Mrljdx on 16/1/4.
 */
public class AndroidLuaActivity extends AppCompatActivity {
    public static final String TAG = "AndroidLuaActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_androidlua);

        TextView tvLua = (TextView) findViewById(R.id.tvLua);

        LuaState luaState = LuaStateFactory.newLuaState();
        luaState.openLibs();//打开标准库

        luaState.LdoString("text = 'Hello Android, I am Lua.'");

        luaState.getGlobal("text");

        String text = luaState.toString(-1);
        Log.e(TAG, "text is ： " + text);
        tvLua.setText(text);

        luaState.LdoFile("hello.lua");


    }

}
