package com.example.testone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * 需求二：实现类似效果图TopBar复合型控件效果
 1）	自定义控件样式实现没问题。
 2）	支持自定义属性，在attrs.xml中配置正确：中间标题内容文字，字体大小，文字颜色，背景颜色
 3）	支持自定义属性，在attrs.xml中配置正确：左边按钮文字，字体大小，文字颜色，背景颜色
 4）	支持自定义属性，在attrs.xml中配置正确：右边按钮文字，字体大小，文字颜色，背景颜色
 5）	构造方法中自定义属性配置正确
 6）	左右按钮通过回调接口定义点击事件。
 7）	点击左右按钮弹出吐司，如图1。
 8）	在布局文件中使用复合型控件时使用自定义的属性赋值
 9）	左右按钮背景设置背景选择器，点击时红色，未点击时蓝色。

 */
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
