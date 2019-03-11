package com.example.horizon.components;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

public class DynamicListView extends ListView {

    public DynamicListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DynamicListView(Context context) {
        super(context);
    }

    public DynamicListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
