package ru.samsung.itschool.spacearrays;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
    static int f = 0;
    static int s = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void addRocket(View v) {
        MyDraw.onAddRocket();
        f++;
        if(f>=10) showToast(v);
    }

    public void addStar(View v) {
        MyDraw.onAddStar();
        s++;
        if(s>=500) showToast(v);
    }
    public void showToast(View view) {
        Toast toast = Toast.makeText(this, "Максимальное количество ракет. Игра закончена.", Toast.LENGTH_LONG);
        toast.show();
    }
}
