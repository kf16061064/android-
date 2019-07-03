package com.bytedance.clockapplication.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;
import android.view.View;


import java.util.Calendar;
import java.util.Locale;

public class Clock extends View {

    private final static String TAG = Clock.class.getSimpleName();

    private static final int FULL_ANGLE = 360;

    private static final int CUSTOM_ALPHA = 140;
    private static final int FULL_ALPHA = 255;

    private static final int DEFAULT_PRIMARY_COLOR = Color.WHITE;
    private static final int DEFAULT_SECONDARY_COLOR = Color.LTGRAY;

    private static final float DEFAULT_DEGREE_STROKE_WIDTH = 0.010f;

    public final static int AM = 0;

    private static final int RIGHT_ANGLE = 90;

    private int mWidth, mCenterX, mCenterY, mRadius;

    /**
     * properties
     */
    private int centerInnerColor;
    private int centerOuterColor;

    private int secondsNeedleColor;
    private int hoursNeedleColor;
    private int minutesNeedleColor;

    private int degreesColor;

    private int hoursValuesColor;

    private int numbersColor;

    private boolean mShowAnalog = true;

    public Clock(Context context) {
        super(context);
        init(context, null);
    }

    public Clock(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public Clock(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int size;
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        int widthWithoutPadding = width - getPaddingLeft() - getPaddingRight();
        int heightWithoutPadding = height - getPaddingTop() - getPaddingBottom();

        if (widthWithoutPadding > heightWithoutPadding) {
            size = heightWithoutPadding;
        } else {
            size = widthWithoutPadding;
        }

        setMeasuredDimension(size + getPaddingLeft() + getPaddingRight(), size + getPaddingTop() + getPaddingBottom());
    }

    private void init(Context context, AttributeSet attrs) {

        this.centerInnerColor = Color.LTGRAY;
        this.centerOuterColor = DEFAULT_PRIMARY_COLOR;

        this.secondsNeedleColor = DEFAULT_SECONDARY_COLOR;
        this.hoursNeedleColor = DEFAULT_PRIMARY_COLOR;
        this.minutesNeedleColor = DEFAULT_PRIMARY_COLOR;

        this.degreesColor = DEFAULT_PRIMARY_COLOR;

        this.hoursValuesColor = DEFAULT_PRIMARY_COLOR;

        numbersColor = Color.WHITE;
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);

        mWidth = getHeight() > getWidth() ? getWidth() : getHeight();

        int halfWidth = mWidth / 2;
        mCenterX = halfWidth;
        mCenterY = halfWidth;
        mRadius = halfWidth;

        if (mShowAnalog) {
            drawDegrees(canvas);
            drawHoursValues(canvas);
            drawNeedles(canvas);
            drawCenter(canvas);
            //postInvalidateDelayed(1000);
        } else {
            drawNumbers(canvas);
        }

    }

    private void drawDegrees(Canvas canvas) {

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(mWidth * DEFAULT_DEGREE_STROKE_WIDTH);
        paint.setColor(degreesColor);

        int rPadded = mCenterX - (int) (mWidth * 0.01f);
        int rEnd = mCenterX - (int) (mWidth * 0.05f);

        for (int i = 0; i < FULL_ANGLE; i += 6 /* Step */) {

            if ((i % RIGHT_ANGLE) != 0 && (i % 15) != 0)
                paint.setAlpha(CUSTOM_ALPHA);
            else {
                paint.setAlpha(FULL_ALPHA);
            }

            int startX = (int) (mCenterX + rPadded * Math.cos(Math.toRadians(i)));
            int startY = (int) (mCenterX - rPadded * Math.sin(Math.toRadians(i)));

            int stopX = (int) (mCenterX + rEnd * Math.cos(Math.toRadians(i)));
            int stopY = (int) (mCenterX - rEnd * Math.sin(Math.toRadians(i)));

            canvas.drawLine(startX, startY, stopX, stopY, paint);

        }
    }

    /**
     * @param canvas
     */
    private void drawNumbers(Canvas canvas) {

        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(mWidth * 0.2f);
        textPaint.setColor(numbersColor);
        textPaint.setColor(numbersColor);
        textPaint.setAntiAlias(true);

        Calendar calendar = Calendar.getInstance();

        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        int amPm = calendar.get(Calendar.AM_PM);

        String time = String.format("%s:%s:%s%s",
                String.format(Locale.getDefault(), "%02d", hour),
                String.format(Locale.getDefault(), "%02d", minute),
                String.format(Locale.getDefault(), "%02d", second),
                amPm == AM ? "AM" : "PM");

        SpannableStringBuilder spannableString = new SpannableStringBuilder(time);
        spannableString.setSpan(new RelativeSizeSpan(0.3f), spannableString.toString().length() - 2, spannableString.toString().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // se superscript percent

        StaticLayout layout = new StaticLayout(spannableString, textPaint, canvas.getWidth(), Layout.Alignment.ALIGN_CENTER, 1, 1, true);
        canvas.translate(mCenterX - layout.getWidth() / 2f, mCenterY - layout.getHeight() / 2f);
        layout.draw(canvas);
    }

    /**
     * Draw Hour Text Values, such as 1 2 3 ...
     *
     * @param canvas
     */
    private void drawHoursValues(Canvas canvas) {
        // Default Color:
        // - hoursValuesColor

        Paint valuesPaint = new Paint();
        valuesPaint.setColor(hoursValuesColor);
        valuesPaint.setTextSize(100);
        valuesPaint.setStyle(Paint.Style.FILL);
        valuesPaint.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetrics fontMetrics = valuesPaint.getFontMetrics();
        float top = fontMetrics.top;
        float bottom = fontMetrics.bottom;

        int rPadded = mCenterX - (int) (mRadius * 0.2f);

        for (int i = 0; i < FULL_ANGLE; i += 30 /* Step */) {

            int value = (i==0)?12:(i/30);
            int baseLineY = (int)(mCenterY - rPadded*Math.cos(Math.toRadians(i)) - top/2 - bottom/2);
            int valuesCenterX = (int)(mCenterX + rPadded*Math.sin(Math.toRadians(i)));

            canvas.drawText(String.valueOf(value),valuesCenterX, baseLineY, valuesPaint);
        }

    }


/**
 * 根据角度和长度计算线段的起点和终点的坐标
 * @param angle
 * @param length
 * @return
 */


    /**
     * Draw hours, minutes needles
     * Draw progress that indicates hours needle disposition.
     *
     * @param canvas
     */
    private void drawNeedles(final Canvas canvas) {
        // Default Color:
        // - secondsNeedleColor
        // - hoursNeedleColor
        // - minutesNeedleColor
        Paint needlepaint= new Paint();
        //needlepaint.setAntiAlias(true);

        Calendar now = Calendar.getInstance();

        needlepaint.setStyle(Paint.Style.FILL);
        needlepaint.setStrokeWidth(5);
        needlepaint.setColor(secondsNeedleColor);


        int sdegree=(int) (now.get(Calendar.SECOND)*6);
        int secondX=(int)(mCenterX+mRadius*0.7f*Math.sin(Math.toRadians(sdegree)));
        int secondY=(int)(mCenterY-mRadius*0.7f*Math.cos(Math.toRadians(sdegree)));
        canvas.drawLine(mCenterX, mCenterY,secondX,secondY,needlepaint);

        needlepaint.setStrokeWidth(10);
        needlepaint.setColor(minutesNeedleColor);
        int mdegree=(int) (now.get(Calendar.SECOND)/60f+now.get(Calendar.MINUTE)*6);
        int minuteX=(int)(mCenterX+mRadius*0.6f*Math.sin(Math.toRadians(mdegree)));
        int minuteY=(int)(mCenterY-mRadius*0.6f*Math.cos(Math.toRadians(mdegree)));
        canvas.drawLine(mCenterX, mCenterY,minuteX,minuteY,needlepaint);

        needlepaint.setStrokeWidth(15);
        needlepaint.setColor(hoursNeedleColor);
        int hdegree=(int) (now.get(Calendar.SECOND)/120f+now.get(Calendar.MINUTE)/2f+(now.get(Calendar.HOUR)%12)*30);
        int hourX=(int)(mCenterX+mRadius*0.4f*Math.sin(Math.toRadians(hdegree)));
        int hourY=(int)(mCenterY-mRadius*0.4f*Math.cos(Math.toRadians(hdegree)));
        canvas.drawLine(mCenterX, mCenterY,hourX,hourY,needlepaint);




    }

    /**
     * Draw Center Dot
     *
     * @param canvas
     */
    private void drawCenter(Canvas canvas) {
        // Default Color:
        // - centerInnerColor
        // - centerOuterColor
        //画圆心
        Paint paintCenter = new Paint();
        paintCenter.setColor(Color.WHITE);
        canvas.drawCircle(0, 0, 2, paintCenter);


    }

    public void setShowAnalog(boolean showAnalog) {
        mShowAnalog = showAnalog;
        invalidate();
    }

    public boolean isShowAnalog() {
        return mShowAnalog;
    }

}