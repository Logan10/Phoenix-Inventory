package com.example.kanishk.phoenixinventory;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class ItemListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_item_list, menu);
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
            Intent emailIntent = new Intent(android.content.Intent.ACTION_SENDTO);
            emailIntent.setData(new Uri.Builder().scheme("mailto").build());
            //emailIntent.setType("message/rfc822");
            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[] {
                    "kanishksharma809@gmail.com" });
            emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Regarding Phoenix-Inventory-App");
            emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,"Hi Kanishk,\n\nThis app is showing a bug that -->\n\n");
            //emailIntent.setType("text/plain");
            if (emailIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(emailIntent);
                //Toast.makeText(MainActivity.this, "Mail Send, (^_^)", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(ItemListActivity.this, "Mail Sending failed (-_-)", Toast.LENGTH_SHORT).show();
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
