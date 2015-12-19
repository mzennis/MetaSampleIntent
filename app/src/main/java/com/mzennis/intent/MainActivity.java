package com.mzennis.intent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String KEY = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onViewCreated();
    }

    private void onViewCreated() {
        final EditText sendTxt = (EditText) findViewById(R.id.send_txt);
        Button btnIntent1 = (Button) findViewById(R.id.btn_1);
        Button btnIntent2 = (Button) findViewById(R.id.btn_2);
        Button btnDial = (Button) findViewById(R.id.btn_dial);

        btnIntent1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, OneActivity.class);
                String pass = "Kirim Data : ";
                if (!isEmpty(sendTxt)) {
                    pass += sendTxt.getText().toString();
                }

                i.putExtra(KEY, pass);
                startActivity(i);
            }
        });

        btnIntent2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, TwoActivity.class);
                String pass = "Kirim Data : ";
                if (!isEmpty(sendTxt)) {
                    pass += sendTxt.getText().toString();
                }

                i.putExtra(KEY, pass);
                startActivity(i);
            }
        });

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:085773589031"));
                startActivity(i);
            }
        });

    }

    private boolean isEmpty(EditText editText) {
        return editText.getText().toString().equals("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
