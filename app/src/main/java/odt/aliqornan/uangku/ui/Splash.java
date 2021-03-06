package odt.aliqornan.uangku.ui;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import odt.aliqornan.uangku.R;

/**
 * Created by Admin on 6/3/2016.
 */
public class Splash extends AppCompatActivity {

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }

    @Override
    protected void onPause() {
        overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
        super.onPause();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        StartAnimations();
        Thread splash = new Thread() {
            public void run() {
                try {
                    sleep(1500);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    startActivity(new Intent(getApplicationContext(), Introduction.class));
                    overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
                    finish();
                }
            }
        };
        splash.start();
    }

    private void StartAnimations() {

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.upup);
        anim.reset();
        ImageView iv = (ImageView) findViewById(R.id.logo);
        iv.clearAnimation();
        iv.startAnimation(anim);
    }
}