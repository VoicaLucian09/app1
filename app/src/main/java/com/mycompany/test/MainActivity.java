package com.mycompany.test;

import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.OverScroller;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ZoomControls;


public class MainActivity extends ActionBarActivity
        implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {
    public int contor=0;
    private TextView gestureText;
    ZoomControls zoom;
    ImageView img;
    private GestureDetectorCompat gDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        gestureText = (TextView) findViewById(R.id.gestureStatusText);

        img = (ImageView) findViewById(R.id.imageView);
        zoom = new ZoomControls(MainActivity.this);
        this.gDetector = new GestureDetectorCompat(this, this);
        gDetector.setOnDoubleTapListener(this);

    }


    @Override
    public boolean onDown(MotionEvent event) {
        gestureText.setText("onDown");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2,
                            float distanceX, float distanceY) {
        gestureText.setText("onScroll");
        return true;
    }
    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,
                           float velocityX, float velocityY) {
        gestureText.setText("onFling");
        return true;
    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        gestureText.setText("onSingleTapUp");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent event) {
        gestureText.setText("onShowPress");
    }

    @Override
    public void onLongPress(MotionEvent event) {
        gestureText.setText("onLongPress");
    }

    @Override
    public boolean onDoubleTap(MotionEvent event) {
        gestureText.setText("onDoubleTap");


        return true;
    }


    @Override
    public boolean onDoubleTapEvent(MotionEvent event) {
       // gestureText.setText("onDoubleTapEvent");
        if(contor==0) {
            float x = img.getScaleX();
            float y = img.getScaleY();
            float xt = event.getX();
            float yt = event.getY();

            img.setScaleX((float) (x + 0.5));
            img.setScaleY((float) (y + 0.5));
            img.setScrollX((int)xt);
            img.setScrollY((int)yt);


            gestureText.setText("X:"+xt+"Y:"+yt);


            contor++; }
        else {
            float x = img.getScaleX();
            float y = img.getScaleY();

            img.setScaleX((float) (x - 0.5));
            img.setScaleY((float) (y - 0.5));
            contor--; }

        return true;
    }


    @Override
    public boolean onSingleTapConfirmed(MotionEvent event) {
        gestureText.setText("onSingleTapConfirmed");
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gDetector.onTouchEvent(event);
        // Be sure to call the superclass implementation
        return super.onTouchEvent(event);

    }
}