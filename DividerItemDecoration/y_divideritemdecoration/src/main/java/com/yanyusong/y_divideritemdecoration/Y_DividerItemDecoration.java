package com.yanyusong.y_divideritemdecoration;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class Y_DividerItemDecoration extends RecyclerView.ItemDecoration {

    private Paint mPaint;
    private Paint mBgPaint;

    private Context context;

    public Y_DividerItemDecoration(Context context) {
        this.context = context;
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);

        mBgPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBgPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        //left, top, right, bottom
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);

            int itemPosition = ((RecyclerView.LayoutParams) child.getLayoutParams()).getViewLayoutPosition();

            Y_Divider divider = getDivider(itemPosition);

            if (divider.getLeftSideLine().isHave()) {
                int lineWidthPx = Dp2Px.convert(context, divider.getLeftSideLine().getWidthDp());
                int startPaddingPx = Dp2Px.convert(context, divider.getLeftSideLine().getStartPaddingDp());
                int endPaddingPx = Dp2Px.convert(context, divider.getLeftSideLine().getEndPaddingDp());
                drawChildLeftVertical(child, c, parent, divider.leftSideLine.color, divider.getLeftSideLine().bgColor, lineWidthPx, startPaddingPx, endPaddingPx);
            }
            if (divider.getTopSideLine().isHave()) {
                int lineWidthPx = Dp2Px.convert(context, divider.getTopSideLine().getWidthDp());
                int startPaddingPx = Dp2Px.convert(context, divider.getTopSideLine().getStartPaddingDp());
                int endPaddingPx = Dp2Px.convert(context, divider.getTopSideLine().getEndPaddingDp());
                drawChildTopHorizontal(child, c, parent, divider.topSideLine.getColor(), divider.topSideLine.bgColor, lineWidthPx, startPaddingPx, endPaddingPx);
            }
            if (divider.getRightSideLine().isHave()) {
                int lineWidthPx = Dp2Px.convert(context, divider.getRightSideLine().getWidthDp());
                int startPaddingPx = Dp2Px.convert(context, divider.getRightSideLine().getStartPaddingDp());
                int endPaddingPx = Dp2Px.convert(context, divider.getRightSideLine().getEndPaddingDp());
                drawChildRightVertical(child, c, parent, divider.getRightSideLine().getColor(), divider.rightSideLine.bgColor, lineWidthPx, startPaddingPx, endPaddingPx);
            }
            if (divider.getBottomSideLine().isHave()) {
                int lineWidthPx = Dp2Px.convert(context, divider.getBottomSideLine().getWidthDp());
                int startPaddingPx = Dp2Px.convert(context, divider.getBottomSideLine().getStartPaddingDp());
                int endPaddingPx = Dp2Px.convert(context, divider.getBottomSideLine().getEndPaddingDp());
                drawChildBottomHorizontal(child, c, parent, divider.getBottomSideLine().getColor(), divider.bottomSideLine.bgColor, lineWidthPx, startPaddingPx, endPaddingPx);
            }
        }
    }

    private void drawChildBottomHorizontal(View child, Canvas c, RecyclerView parent, @ColorInt int color, @ColorInt int bgColor, int lineWidthPx, int startPaddingPx, int endPaddingPx) {

        int leftPadding = 0;
        int rightPadding = 0;

        if (startPaddingPx <= 0) {
            //padding<0当作==0处理
            //上下左右默认分割线的两头都出头一个分割线的宽度，避免十字交叉的时候，交叉点是空白
            leftPadding = -lineWidthPx;
        } else {
            leftPadding = startPaddingPx;
        }

        if (endPaddingPx <= 0) {
            rightPadding = lineWidthPx;
        } else {
            rightPadding = -endPaddingPx;
        }

        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                .getLayoutParams();

        int bgLeft = child.getLeft() - params.leftMargin;
        int bgRight = child.getRight() + params.rightMargin;
        int bgTop = child.getBottom() + params.bottomMargin;
        int bgBottom = bgTop + lineWidthPx;
        mBgPaint.setColor(bgColor);

        c.drawRect(bgLeft, bgTop, bgRight, bgBottom, mBgPaint);

        int left = child.getLeft() - params.leftMargin + leftPadding;
        int right = child.getRight() + params.rightMargin + rightPadding;
        int top = child.getBottom() + params.bottomMargin;
        int bottom = top + lineWidthPx;
        mPaint.setColor(color);

        c.drawRect(left, top, right, bottom, mPaint);

    }

    private void drawChildTopHorizontal(View child, Canvas c, RecyclerView parent, @ColorInt int color, @ColorInt int bgColor, int lineWidthPx, int startPaddingPx, int endPaddingPx) {
        int leftPadding = 0;
        int rightPadding = 0;

        if (startPaddingPx <= 0) {
            //padding<0当作==0处理
            //上下左右默认分割线的两头都出头一个分割线的宽度，避免十字交叉的时候，交叉点是空白
            leftPadding = -lineWidthPx;
        } else {
            leftPadding = startPaddingPx;
        }
        if (endPaddingPx <= 0) {
            rightPadding = lineWidthPx;
        } else {
            rightPadding = -endPaddingPx;
        }

        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                .getLayoutParams();

        int bgLeft = child.getLeft() - params.leftMargin;
        int bgRight = child.getRight() + params.rightMargin;
        int bgTop = child.getBottom() + params.bottomMargin;
        int bgBottom = bgTop + lineWidthPx;
        mBgPaint.setColor(bgColor);

        c.drawRect(bgLeft, bgTop, bgRight, bgBottom, mBgPaint);

        int left = child.getLeft() - params.leftMargin + leftPadding;
        int right = child.getRight() + params.rightMargin + rightPadding;
        int bottom = child.getTop() - params.topMargin;
        int top = bottom - lineWidthPx;
        mPaint.setColor(color);

        c.drawRect(left, top, right, bottom, mPaint);

    }

    private void drawChildLeftVertical(View child, Canvas c, RecyclerView parent, @ColorInt int color, @ColorInt int bgColor, int lineWidthPx, int startPaddingPx, int endPaddingPx) {
        int topPadding = 0;
        int bottomPadding = 0;

        if (startPaddingPx <= 0) {
            //padding<0当作==0处理
            //上下左右默认分割线的两头都出头一个分割线的宽度，避免十字交叉的时候，交叉点是空白
            topPadding = -lineWidthPx;
        } else {
            topPadding = startPaddingPx;
        }
        if (endPaddingPx <= 0) {
            bottomPadding = lineWidthPx;
        } else {
            bottomPadding = -endPaddingPx;
        }

        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                .getLayoutParams();

        int bgTop = child.getTop() - params.topMargin;
        int bgBottom = child.getBottom() + params.bottomMargin;
        int bgRight = child.getLeft() - params.leftMargin;
        int bgLeft = bgRight - lineWidthPx;
        mBgPaint.setColor(bgColor);

        c.drawRect(bgLeft, bgTop, bgRight, bgBottom, mBgPaint);

        int top = child.getTop() - params.topMargin + topPadding;
        int bottom = child.getBottom() + params.bottomMargin + bottomPadding;
        int right = child.getLeft() - params.leftMargin;
        int left = right - lineWidthPx;
        mPaint.setColor(color);

        c.drawRect(left, top, right, bottom, mPaint);

    }

    private void drawChildRightVertical(View child, Canvas c, RecyclerView parent, @ColorInt int color, @ColorInt int bgColor, int lineWidthPx, int startPaddingPx, int endPaddingPx) {

        int topPadding = 0;
        int bottomPadding = 0;

        if (startPaddingPx <= 0) {
            //padding<0当作==0处理
            //上下左右默认分割线的两头都出头一个分割线的宽度，避免十字交叉的时候，交叉点是空白
            topPadding = -lineWidthPx;
        } else {
            topPadding = startPaddingPx;
        }
        if (endPaddingPx <= 0) {
            bottomPadding = lineWidthPx;
        } else {
            bottomPadding = -endPaddingPx;
        }

        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                .getLayoutParams();

        int bgTop = child.getTop() - params.topMargin;
        int bgBottom = child.getBottom() + params.bottomMargin;
        int bgRight = child.getLeft() - params.leftMargin;
        int bgLeft = bgRight - lineWidthPx;
        mBgPaint.setColor(bgColor);

        c.drawRect(bgLeft, bgTop, bgRight, bgBottom, mBgPaint);

        int top = child.getTop() - params.topMargin + topPadding;
        int bottom = child.getBottom() + params.bottomMargin + bottomPadding;
        int left = child.getRight() + params.rightMargin;
        int right = left + lineWidthPx;
        mPaint.setColor(color);

        c.drawRect(left, top, right, bottom, mPaint);

    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        //outRect 看源码可知这里只是把Rect类型的outRect作为一个封装了left,right,top,bottom的数据结构,
        //作为传递left,right,top,bottom的偏移值来用的

        int itemPosition = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition();

        Y_Divider divider = getDivider(itemPosition);

        if (divider == null) {
            divider = new Y_DividerBuilder().create();
        }

        int left = divider.getLeftSideLine().isHave() ? Dp2Px.convert(context, divider.getLeftSideLine().getWidthDp()) : 0;
        int top = divider.getTopSideLine().isHave() ? Dp2Px.convert(context, divider.getTopSideLine().getWidthDp()) : 0;
        int right = divider.getRightSideLine().isHave() ? Dp2Px.convert(context, divider.getRightSideLine().getWidthDp()) : 0;
        int bottom = divider.getBottomSideLine().isHave() ? Dp2Px.convert(context, divider.getBottomSideLine().getWidthDp()) : 0;

        outRect.set(left, top, right, bottom);
    }


    public abstract @Nullable Y_Divider getDivider(int itemPosition);


}

















