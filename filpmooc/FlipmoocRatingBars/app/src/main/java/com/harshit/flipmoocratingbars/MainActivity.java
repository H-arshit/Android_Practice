package com.harshit.flipmoocratingbars;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RatingBar.OnRatingBarChangeListener, View.OnClickListener {
    TextView ratingtext;
    Button button;
    RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ratingtext=(TextView)findViewById(R.id.ratingtext);
        ratingBar=(RatingBar)findViewById(R.id.ratingbar);
        button=(Button)findViewById(R.id.button);
        ratingBar.setOnRatingBarChangeListener(this);
        button.setOnClickListener(this);
    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser)
    {
        //ratingtext.setText(String.valueOf(ratingBar.getRating()));
        ratingtext.setText(String.valueOf(rating));
    }

    @Override
    public void onClick(View v)
    {
        Toast.makeText(this,String.valueOf(ratingBar.getRating()),Toast.LENGTH_SHORT).show();
    }
}
