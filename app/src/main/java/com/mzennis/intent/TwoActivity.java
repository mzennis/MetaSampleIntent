package com.mzennis.intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by mzennis on 12/19/15.
 */
public class TwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        onViewCreated();
    }

    private void onViewCreated() {
        TextView resultTxt = (TextView) findViewById(R.id.result_txt);
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            if (extras.getString(MainActivity.KEY) != null)
                resultTxt.setText(extras.getString(MainActivity.KEY));
        } else {
            resultTxt.setText("Extra NULL");
        }
    }
}
