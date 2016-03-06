package in.grappes.sampleapp.CustomClass;

/**
 * Created by GunjitDhawan on 2/27/2016.
 */

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;


public class CustomTextView extends TextView {

    public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        createFont();
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        createFont();
    }

    public CustomTextView(Context context) {
        super(context);
        createFont();
    }

    public void createFont() {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/dejavu.ttf");
        setTypeface(font);
    }

}
