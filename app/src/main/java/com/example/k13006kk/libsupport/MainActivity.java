package com.example.k13006kk.libsupport;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.k13006kk.mylibrary.DBaccess;
import com.example.k13006kk.mylibrary.DbinfoHolder;
import com.example.k13006kk.mylibrary.UserColumns;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    String[] dbstr = new String[3];
    Handler _handler = new Handler();
    //ContentResolver resolver = getContentResolver();
    DBaccess dBaccess = new DBaccess();
    DbinfoHolder dbinfoHolder = DbinfoHolder.getInstance();
    Uri uri = UserColumns.CONTENT_URI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ContentResolver resolver = getContentResolver();

        //uri = ContentUris.withAppendedId(UserColumns.CONTENT_URI, 1);

        //dBaccess.monitoring(resolver);

        _handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //dbstr = dbinfoHolder.getdb();
                //Cursor c = resolver.query(uri, null, null, null, null);
                //startManagingCursor(c);
                //db(c);
                /*
                while (c.moveToNext()) {
                    for (int i = 0; i < c.getColumnCount(); i++) {
                        dbstr[i] = c.getString(i);
                    }
                }
                c.close();*/

                dbstr = dBaccess.monitoring(resolver);

                TextView tv = (TextView) findViewById(R.id.name);
                tv.setText(dbstr[1]);
                tv.setText(dbstr[1]);

                TextView tv2 = (TextView) findViewById(R.id.room);
                tv2.setText(dbstr[2]);
                tv2.setText(dbstr[2]);

                _handler.postDelayed(this, 500);
            }
        }, 0);

    }

    public void dbload(Cursor c){
        while (c.moveToNext()) {
            for (int i = 0; i < c.getColumnCount(); i++) {
                dbstr[i] = c.getString(i);
            }
        }
        c.close();

        TextView tv = (TextView) findViewById(R.id.name);
        tv.setText(dbstr[1]);

        TextView tv2 = (TextView) findViewById(R.id.room);
        tv2.setText(dbstr[2]);

        //c.close();
    }

}
