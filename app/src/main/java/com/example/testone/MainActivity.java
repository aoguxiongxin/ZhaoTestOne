package com.example.testone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyTitleView viewById = (MyTitleView) findViewById(R.id.mytitleview);
        viewById.setOnBackClickListener(new MyTitleView.OnBackClickListener() {
            @Override
            public void OnBackClick(View view) {
                Toast.makeText(MainActivity.this, "点击了 返回", Toast.LENGTH_SHORT).show();
            }
        });

        viewById.setOnMoreClickListener(new MyTitleView.OnMoreClickListener() {
            @Override
            public void OnMoreClick(View view) {
                Toast.makeText(MainActivity.this, "点击了 更多", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
