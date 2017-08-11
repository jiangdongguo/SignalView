package com.jiangdg.singalviewlib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

/** 自定义信号强弱显示控件
 *
 * Created by jianddongguo on 2017/8/10.
 */

public class SignalView extends View {
    private int rectOffset;
    private int signalValue;
    private String signalType;
    private Paint mPaint;
    private int mRectHeight;
    private int mRectWidth;
    private int mRectCount;
    private int mSignalLowColor;
    private int mSignalMiddleColor;
    private int mSignalHighColor;
    private int mRectBorderColor;
    private int mRectBorderWidth;
    private int mSignalTypeTextColor;
    private float mSignalTypeTextSize;

    // 在Java代码中实例化使用控件
    public SignalView(Context context) {
        super(context);
    }

    /** 在XML代码中使用控件自动回调
     *   获取XML中自定义属性
     */
    public SignalView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.SignalView);
        // 信号柱数目,默认5条
        mRectCount = ta.getInt(R.styleable.SignalView_signalCount,7);
        // 信号柱间隔，默认4dp
        rectOffset = ta.getInt(R.styleable.SignalView_signalRectInterval,4);
        // 信号柱宽度，默认1dp
        mRectBorderWidth = ta.getInt(R.styleable.SignalView_rectBorderWidth,1);
        // 信号柱边框颜色，默认黑色
        mRectBorderColor = ta.getColor(R.styleable.SignalView_rectBorderColor,getResources().getColor(R.color.colorBlack));
        // 弱信号颜色，默认红色
        mSignalLowColor = ta.getColor(R.styleable.SignalView_signalLowColor,getResources().getColor(R.color.colorRed));
        // 中等信号颜色，默认黄色
        mSignalMiddleColor = ta.getColor(R.styleable.SignalView_signalMiddleColor,getResources().getColor(R.color.colorYellow));
        // 强信号颜色，默认绿色
        mSignalHighColor = ta.getColor(R.styleable.SignalView_signalHighColor,getResources().getColor(R.color.colorGreen));

        // 信号类型文本字体颜色，默认黑色
        mSignalTypeTextColor = ta.getColor(R.styleable.SignalView_signalTypeTextColor,getResources().getColor(R.color.colorBlack));
        // 信号类型文本字体大小，默认12sp
        mSignalTypeTextSize = ta.getDimension(R.styleable.SignalView_signalTypeTextSize,14);
        ta.recycle();

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    public void setSignalValue(int signalValue){
        // 如果值大于信号柱，抛出异常
        if(signalValue > mRectCount){
            new Throwable("setSignalValue method value error,can not exceed settings value!");
        }
        this.signalValue = signalValue;
        // 更新值后，重新绘制SignalView
        this.invalidate();
    }

    public void setSignalTypeText(String signalType){
        this.signalType = signalType;
    }


    // 当View大小改变时，获取View相关属性，初始化
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mRectHeight = getHeight();
        mRectWidth = getWidth() / mRectCount;
    }

    /** 测量
     *  如果不覆写onMeasure方法，SignalView值支持EXACTY模式(具体值或match_parent)
     *  不支持AT_MOST模式，即wrap_content
     * */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureWidth(widthMeasureSpec),measureHeight(heightMeasureSpec));
    }

    private int measureHeight(int heightMeasureSpec) {
        int height = 0;
        // 测量模式，从xml可知
        int specMode = MeasureSpec.getMode(heightMeasureSpec);
        // 测量大小,从xml中获取
        int specSize = MeasureSpec.getSize(heightMeasureSpec);

        if(specMode == MeasureSpec.EXACTLY){
            height = specSize;
        }else{
            height = 50;
            // wrap_content模式，选择最小值
            if(specMode == MeasureSpec.AT_MOST){
                height = Math.min(height,specSize);
            }
        }
        mRectHeight = height;
        return height;
    }

    private int measureWidth(int widthMeasureSpec) {
        int width = 0;
        // 测量模式，从xml可知
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        // 测量大小,从xml中获取
        int specSize = MeasureSpec.getSize(widthMeasureSpec);

        if(specMode == MeasureSpec.EXACTLY){
            width = specSize;
        }else{
            width = 80;
            // wrap_content模式，选择最小值
            if(specMode == MeasureSpec.AT_MOST){
                width = Math.min(width,specSize);
            }
        }
        return width;
    }

    /**绘制
     * 绘制信号条，根据强弱显示不同颜色
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 绘制信号类型文字
        if(! TextUtils.isEmpty(signalType)){
            mPaint.setColor(mSignalTypeTextColor);
            mPaint.setTextSize(mSignalTypeTextSize);
            mPaint.setStrokeWidth(1);
            canvas.drawText(signalType,0,mSignalTypeTextSize,mPaint);
        }

        mPaint.setStrokeWidth(mRectBorderWidth);
        // 绘制信号条，根据强弱显示不同颜色
        for(int i = 0;i < mRectCount ; i++){
            // 前signalValue信号柱绘制实心颜色
            if(i < signalValue){
                if(signalValue <= mRectCount / 3){
                    mPaint.setColor(mSignalLowColor);
                }else if(signalValue <= mRectCount * 2 / 3){
                    mPaint.setColor(mSignalMiddleColor);
                }else{
                    mPaint.setColor(mSignalHighColor);
                }
                mPaint.setStyle(Paint.Style.FILL);
            }else{
                mPaint.setColor(mRectBorderColor);
                mPaint.setStyle(Paint.Style.STROKE);
            }
            // 绘制信号矩形柱
            canvas.drawRect(
                    (float) (mRectWidth * i + rectOffset),
                    (float)(mRectHeight * (mRectCount - i) * 0.1),
                    (float)(mRectWidth * (i + 1)),
                        mRectHeight,mPaint);
        }
    }
}
