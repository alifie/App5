package com.example.plantatoru.app5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Activity2 extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);
        Intent intent = getIntent();

        TextView textView ;

        String mess = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        textView = (TextView) findViewById(R.id.textView);

        textView.setText(mess);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity2, menu);
        return true;
    }


    public void onClick(View v){

        TextView textView;

        textView = (TextView) findViewById(R.id.textView);

        Intent implicitIntent = new Intent(Intent.ACTION_SEND);
        implicitIntent.putExtra(Intent.EXTRA_TEXT, textView.getText().toString());
        implicitIntent.setType("text/plain");

        Intent chooserIntent = Intent.createChooser(implicitIntent, "Choose an app:");
        startActivity(chooserIntent);
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
