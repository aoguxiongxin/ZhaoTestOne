package com.example.testone;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by 傲骨雄心 on 2017/9/2.
 */

public class MyTitleView extends LinearLayout {

    private TextView title_left;
    private TextView title_center;
    private TextView title_right;

    public MyTitleView(Context context) {
        super(context);
        initView(context, null);
    }

    public MyTitleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    private void initView(Context context, @Nullable AttributeSet attrs) {

        View view = LayoutInflater.from(context).inflate(R.layout.titleview, this);
        title_left = (TextView) view.findViewById(R.id.title_left);
        title_center = (TextView) view.findViewById(R.id.title_center);
        title_right = (TextView) view.findViewById(R.id.title_right);
        if (attrs == null) {
            return;
        }
        setViewContent(context, attrs);

        title_left.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnBackClickListener.OnBackClick(v);
            }
        });

        title_right.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnMoreClickListener.OnMoreClick(v);
            }
        });


    }

    private OnBackClickListener mOnBackClickListener;
    private OnMoreClickListener mOnMoreClickListener;

    public interface OnBackClickListener {
        void OnBackClick(View view);
    }

    public interface OnMoreClickListener {
        void OnMoreClick(View view);
    }

    public void setOnBackClickListener(OnBackClickListener mOnBackClickListener) {
        this.mOnBackClickListener = mOnBackClickListener;
    }

    public void setOnMoreClickListener(OnMoreClickListener mOnMoreClickListener) {
        this.mOnMoreClickListener = mOnMoreClickListener;
    }

    private void setViewContent(Context context, @Nullable AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyTitleView);
        int center_TextColor = typedArray.getColor(R.styleable.MyTitleView_title_center_TextColor, Color.RED);
        int left_TextColor = typedArray.getColor(R.styleable.MyTitleView_title_left_TextColor, Color.RED);
        int right_TextColor = typedArray.getColor(R.styleable.MyTitleView_title_right_TextColor, Color.RED);

        String center_Text = typedArray.getString(R.styleable.MyTitleView_title_center_Text);
        String right_Text = typedArray.getString(R.styleable.MyTitleView_title_right_Text);
        String left_Text = typedArray.getString(R.styleable.MyTitleView_title_left_Text);

        float left_TextSize = typedArray.getDimension(R.styleable.MyTitleView_title_left_TextSize, 14);
        float center_TextSize = typedArray.getDimension(R.styleable.MyTitleView_title_center_TextSize, 14);
        float right_TextSize = typedArray.getDimension(R.styleable.MyTitleView_title_right_TextSize, 14);


        Drawable center_bg_Color = typedArray.getDrawable(R.styleable.MyTitleView_title_center_bg_Color);
        Drawable left_bg_Color = typedArray.getDrawable(R.styleable.MyTitleView_title_left_bg_Color);
        Drawable right_bg_Color = typedArray.getDrawable(R.styleable.MyTitleView_title_right_bg_Color);

        title_left.setText(left_Text);
        title_center.setText(center_Text);
        title_right.setText(right_Text);

        title_left.setTextColor(left_TextColor);
        title_center.setTextColor(center_TextColor);
        title_right.setTextColor(right_TextColor);

        title_left.setTextSize(left_TextSize);
        title_center.setTextSize(center_TextSize);
        title_right.setTextSize(right_TextSize);


        title_left.setBackgroundDrawable(left_bg_Color);
        title_center.setBackgroundDrawable(center_bg_Color);
        title_right.setBackgroundDrawable(right_bg_Color);


    }

}

