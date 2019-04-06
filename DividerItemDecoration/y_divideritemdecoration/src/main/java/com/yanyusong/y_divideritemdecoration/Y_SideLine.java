package com.yanyusong.y_divideritemdecoration;

import android.graphics.Color;
import android.support.annotation.ColorInt;

/**
 * Created by mac on 2017/5/17.
 */

public class Y_SideLine {

    public boolean isHave = false;
    /**
     * A single color value in the form 0xAARRGGBB.
     **/
    public int color;
    /**
     * background color
     */
    public int bgColor;
    /**
     * 单位dp
     */
    public float widthDp;
    /**
     * startPaddingDp,分割线起始的padding，水平方向左为start，垂直方向上为start
     * endPaddingDp,分割线尾部的padding，水平方向右为end，垂直方向下为end
     */
    public float startPaddingDp;
    public float endPaddingDp;

    public Y_SideLine(boolean isHave, @ColorInt int color, float widthDp, float startPaddingDp, float endPaddingDp) {
         this(isHave, color, Color.TRANSPARENT, widthDp, startPaddingDp, endPaddingDp);
    }

    public Y_SideLine(boolean isHave, @ColorInt int color, @ColorInt int bgColor, float widthDp, float startPaddingDp, float endPaddingDp) {
        this.isHave = isHave;
        this.color = color;
        this.bgColor = bgColor;
        this.widthDp = widthDp;
        this.startPaddingDp = startPaddingDp;
        this.endPaddingDp = endPaddingDp;
    }

    public float getStartPaddingDp() {
        return startPaddingDp;
    }

    public void setStartPaddingDp(float startPaddingDp) {
        this.startPaddingDp = startPaddingDp;
    }

    public float getEndPaddingDp() {
        return endPaddingDp;
    }

    public void setEndPaddingDp(float endPaddingDp) {
        this.endPaddingDp = endPaddingDp;
    }

    public boolean isHave() {
        return isHave;
    }

    public void setHave(boolean have) {
        isHave = have;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getBgColor() {
        return bgColor;
    }

    public void setBgColor(int bgColor) {
        this.bgColor = bgColor;
    }

    public float getWidthDp() {
        return widthDp;
    }

    public void setWidthDp(float widthDp) {
        this.widthDp = widthDp;
    }
}
