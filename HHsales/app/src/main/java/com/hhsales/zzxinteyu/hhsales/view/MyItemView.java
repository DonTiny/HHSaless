package com.hhsales.zzxinteyu.hhsales.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Dimension;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hhsales.zzxinteyu.hhsales.R;

/**
 * Created by Administrator on 2018/11/1.
 */

public class MyItemView extends RelativeLayout {
    private int  leftIcon;//设置左侧图标
    private boolean showLeftIcon;//是否显示左侧图标
    private String leftText ;//左侧标题文字
    private String rightText;//右侧描述文字
    private boolean showRightArrow;//是否显示右侧小箭头
    private float LeftImageSize,rightImageSize,textSize;
    private ImageView ivLeftIcon,ivRightArrow;
    private TextView tvLeftText,tvRightText;
    private int leftTextColor;
    private LayoutParams ivLeftIconParams,ivRightArrowParams,tvLeftTextParams,tvRightTextParams;
    public MyItemView(Context context) {
        this(context,null);
    }

    public MyItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray=context.obtainStyledAttributes(attrs, R.styleable.ItemView);
        //leftIcon=typedArray.getDrawable(R.styleable.ItemView_left_icon);
        //leftIcon = typedArray.getInteger(R.styleable.ItemView_left_icon, 0);
        leftIcon=typedArray.getResourceId(R.styleable.ItemView_left_icon, 0);
        showLeftIcon = typedArray.getBoolean(R.styleable.ItemView_show_left_icon, true);
        leftText = typedArray.getString(R.styleable.ItemView_left_text);
        rightText = typedArray.getString(R.styleable.ItemView_right_text);
        showRightArrow = typedArray.getBoolean(R.styleable.ItemView_show_right_arrow, true);
        LeftImageSize = typedArray.getDimension(R.styleable.ItemView_left_image_size, 35);
        rightImageSize = typedArray.getDimension(R.styleable.ItemView_right_image_size, 60);
        textSize = typedArray.getDimension(R.styleable.ItemView_text_size,18);
        leftTextColor = typedArray.getColor(R.styleable.ItemView_left_text_color,Color.GRAY);
        ivLeftIcon = new ImageView(context);
        ivRightArrow = new ImageView(context);
        tvRightText = new TextView(context);
        tvLeftText = new TextView(context);
        tvRightText.setTextSize(textSize);
        tvLeftText.setTextSize(textSize);
        tvLeftText.setTextColor(leftTextColor);
        ivLeftIcon.setId(R.id.left_icon_id);
        ivRightArrow.setId(R.id.right_icon_id);

        ivLeftIcon.setImageResource(leftIcon);
        ivLeftIcon.setVisibility(showLeftIcon? View.VISIBLE:View.INVISIBLE);
        tvLeftText.setText(leftText);
        tvRightText.setText(rightText);
        ivRightArrow.setImageResource(R.mipmap.youjiantou);
        ivRightArrow.setVisibility(showRightArrow? View.VISIBLE:View.INVISIBLE);
        typedArray.recycle();

        ivLeftIconParams = new LayoutParams((int) LeftImageSize, (int) LeftImageSize);
        ivLeftIconParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
        ivLeftIconParams.addRule(RelativeLayout.CENTER_IN_PARENT);

        addView(ivLeftIcon, ivLeftIconParams);

        tvLeftTextParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        tvLeftTextParams.addRule(RelativeLayout.RIGHT_OF,R.id.left_icon_id);
        tvLeftTextParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        tvLeftTextParams.setMargins(20,0,0,0);
        addView(tvLeftText, tvLeftTextParams);


        ivRightArrowParams = new LayoutParams((int) rightImageSize, (int) rightImageSize);
        ivRightArrowParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
        ivRightArrowParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        addView(ivRightArrow, ivRightArrowParams);
        int o=ViewGroup.LayoutParams.WRAP_CONTENT;
        tvRightTextParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        tvRightTextParams.addRule(RelativeLayout.LEFT_OF,R.id.right_icon_id);
        tvRightTextParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        addView(tvRightText, tvRightTextParams);
    }

}
