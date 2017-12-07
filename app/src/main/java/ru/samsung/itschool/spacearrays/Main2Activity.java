package ru.samsung.itschool.spacearrays;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void startActivity(View v) {
        switch (v.getId()) {
            case R.id.button:
                Intent i = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(i);
                break;
        }
    }
}

