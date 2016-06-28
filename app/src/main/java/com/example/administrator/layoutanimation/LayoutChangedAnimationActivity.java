package com.example.administrator.layoutanimation;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.administrator.layoutanimation.databinding.LayoutchangedanimationBinding;

/**
 * Created by Administrator on 2016/6/28.
 */
public class LayoutChangedAnimationActivity extends AppCompatActivity
{

    private LayoutchangedanimationBinding mLayoutchangedanimationBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mLayoutchangedanimationBinding = DataBindingUtil.setContentView(this, R.layout.layoutchangedanimation);
        setSupportActionBar(mLayoutchangedanimationBinding.toolbar);

        Animation scaleAnimation=new ScaleAnimation(0,1,0,1);
        scaleAnimation.setDuration(3000);
        Animation alphaAnimation=new AlphaAnimation(0,1);
        alphaAnimation.setDuration(3000);

        AnimationSet animationSet= new AnimationSet(true);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);

        LayoutAnimationController controller=new LayoutAnimationController(animationSet,1);
        mLayoutchangedanimationBinding.linear.setLayoutAnimation(controller);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menus,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.add:
                Button button=new Button(this);
                button.setText("delete me");
                button.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        mLayoutchangedanimationBinding.linear.removeView(v);
                    }
                });
                LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(LinearLayoutCompat.LayoutParams.WRAP_CONTENT, LinearLayoutCompat.LayoutParams.WRAP_CONTENT);
                int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.activity_horizontal_margin);
                layoutParams.topMargin=dimensionPixelSize;
                layoutParams.bottomMargin=dimensionPixelSize;

                mLayoutchangedanimationBinding.linear.addView(button,layoutParams);
        }
        return true;
    }
}
