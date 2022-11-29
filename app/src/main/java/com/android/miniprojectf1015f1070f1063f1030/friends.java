package com.android.miniprojectf1015f1070f1063f1030;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

public class friends extends AppCompatActivity {
    private ViewFlipper viewFlipper;
    private float lastX;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        //call variable
        viewFlipper = (ViewFlipper) findViewById(R.id.viewflipper);
        button = findViewById(R.id.btnBack1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openActivity1(); //activity intent method run
            }
            private void openActivity1(){
                Intent intent1 = new Intent(friends.this, homepage.class);
                startActivity(intent1);

            }
        });

    }

    //using the following method, we will handle all screen swaps.
    @Override
    public boolean onTouchEvent(MotionEvent touchevent)
    {
        switch(touchevent.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                lastX = touchevent.getX();
                break;

            case MotionEvent.ACTION_UP:
                float currentX = touchevent.getX();

                //handling left to right screen swap
                if(lastX < currentX)
                {
                    //if there aren't any other chidren, just break.
                    if(viewFlipper.getDisplayedChild() == 0)
                        break;

                    //next screen comes in from left
                    viewFlipper.setInAnimation(this,R.anim.slide_in_from_left);

                    //currrent screen goes out from right
                    viewFlipper.setOutAnimation(this, R.anim.slide_out_to_right);

                    //Display next screen
                    viewFlipper.showNext();
                }
                //handling right to left screen swap
                if(lastX > currentX)
                {
                    //if there is a child(to the left), just break
                    if(viewFlipper.getDisplayedChild() == 1)
                        break;
                    //next screen come in from right
                    viewFlipper.setOutAnimation(this, R.anim.slide_out_to_right);

                    //currrent screen goes out from right
                    viewFlipper.setOutAnimation(this, R.anim.slide_out_to_left);

                    //Display next screen
                    viewFlipper.showPrevious();
                }break;
        }return false;
    }
}