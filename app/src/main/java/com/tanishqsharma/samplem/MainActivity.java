package com.tanishqsharma.samplem;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;

import com.tanishqsharma.marknish.NishParser;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NishParser nishParser = new NishParser(getApplicationContext());
        String content = "<n_image> http://via.placeholder.com/520x520 </n_image>";
        ConstraintLayout container = findViewById(R.id.container);
        container.addView(nishParser.ReturnView(content));
    }
}
