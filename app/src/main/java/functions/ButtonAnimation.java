package functions;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import nsit.app.com.nsitapp.R;

/**
 * Created by Sidharth Patro on 21-Jul-15.
 */
public class ButtonAnimation {
    public void animateButton(View v, Context context){
        Animation pressAnim = AnimationUtils.loadAnimation(context, R.anim.button_press_anim);
        v.startAnimation(pressAnim);
    }
}
