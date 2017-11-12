package com.example.aluno.plantozen20.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.TextView;

import com.example.aluno.plantozen20.R;

/**
 * Created by Danie on 07/11/2017.
 */

/**
 * Created by Aluno on 30/10/2017.
 */

public class NoteActivity extends AppCompatActivity {
    //   private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anotacao);

        // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        //  mSectionsPagerAdapter = new MainActivity.SectionsPagerAdapter(getSupportFragmentManager(), MainActivity.this);

        // Set up the ViewPager with the sections adapter.
        // mViewPager = (ViewPager) findViewById(R.id.container);
        TextView texto = (TextView)findViewById(R.id.editText_nomenota);

        Bundle b = getIntent().getExtras();
        // int value = b.getInt("key");
        String titulo = b.getString("titulo");
        //  System.out.println(value);
        texto.setText(titulo);
        //Log.d(""+value);


    }

    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}

