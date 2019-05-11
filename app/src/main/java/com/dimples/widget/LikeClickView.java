package com.dimples.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.dimples.R;
import com.dimples.ui.index.tools.SystemUtil;

/**
 * 自定义点赞效果View
 *
 * @author zhongyj
 * @date 2019/5/11
 */
public class LikeClickView extends View {

    /**
     * 点赞按钮是否被选中
     */
    private boolean mIsLike;
    private Bitmap mLikeBitmap;
    private Bitmap mUnLikeBitmap;
    private Bitmap mShiningLikeBitmap;
    private Paint mBitmapPaint;
    private int mLeft;
    private int mTop;

    public LikeClickView(Context context) {
        this(context, null, 0);
        init();
    }

    public LikeClickView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
        init();
    }

    public LikeClickView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //获取自定义属性文件值
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.LikeClickView);
        mIsLike = typedArray.getBoolean(R.styleable.LikeClickView_like, false);
        typedArray.recycle();
        init();
    }

    private void init() {
        Resources resources = getResources();
        mLikeBitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_message_like);
        mUnLikeBitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_message_unlike);
        mShiningLikeBitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_message_like_shining);
        //创建画笔
        mBitmapPaint = new Paint();
    }

    /**
     * 测量方法
     *
     * @param widthMeasureSpec  包括测量模式和大小
     * @param heightMeasureSpec 包括测量模式和大小
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //测绘最终的控件宽度
        int measureWidth;
        //测绘最终的控件高度
        int measureHeight;
        //控件的最大高度
        int maxHeight = mUnLikeBitmap.getHeight() + SystemUtil.dp2px(getContext(), 20);
        //控件的最大宽度
        int maxWidth = mUnLikeBitmap.getWidth() + SystemUtil.dp2px(getContext(), 30);
        //拿到当前控件的测量模式
        int mode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        if (mode != MeasureSpec.EXACTLY) {
            //未指定测量模式  如果有背景，背景多大，控件就有多大
            int suggestedMinimumWidth = getSuggestedMinimumWidth();
            int suggestedMinimumHeight = getSuggestedMinimumHeight();
            //如果没有背景
            if (suggestedMinimumWidth == 0) {
                measureWidth = maxWidth;
            } else {
                measureWidth = Math.min(suggestedMinimumWidth, maxWidth);
            }
            //如果没有背景
            if (suggestedMinimumHeight == 0) {
                measureHeight = maxHeight;
            } else {
                measureHeight = Math.min(suggestedMinimumHeight, maxHeight);
            }
        } else {
            //测量模式指定  根据用户定义的大小来判断
            measureWidth = Math.min(maxWidth, widthSize);
            measureHeight = Math.min(maxHeight, heightSize);
        }
        //完成测量
        setMeasuredDimension(measureWidth, measureHeight);
        //设置控件的left和top
        setPadding(measureWidth, measureHeight);
    }

    /**
     * 系统会反复调用
     *
     * @param canvas Canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Bitmap handBitmap = mIsLike ? mLikeBitmap : mUnLikeBitmap;
        //根据图片在画布上画出图形
        canvas.drawBitmap(handBitmap, mLeft, mTop, mBitmapPaint);
        if (mIsLike) {
            canvas.drawBitmap(mShiningLikeBitmap, mLeft + 10, 0, mBitmapPaint);
        }
    }

    /**
     * 设置控件的left和top
     *
     * @param measureWidth  int
     * @param measureHeight int
     */
    private void setPadding(int measureWidth, int measureHeight) {
        int bitmapWidth = mUnLikeBitmap.getWidth();
        int bitmapHeight = mUnLikeBitmap.getHeight();
        mLeft = (measureWidth - bitmapWidth) / 2;
        mTop = (measureHeight - bitmapHeight) / 2;
    }

    /**
     * 当这个自定义View从界面中脱离消失的时候
     */
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mLikeBitmap.recycle();
        mShiningLikeBitmap.recycle();
        mUnLikeBitmap.recycle();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                onClick();
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
            default:
                break;
        }
        performClick();
        return super.onTouchEvent(event);
    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }

    // TODO: 2019/5/11 待完善 动画的处理

    /**
     * 点击事件
     */
    private void onClick() {
        mIsLike = !mIsLike;
        //重绘
        invalidate();
    }
}


























