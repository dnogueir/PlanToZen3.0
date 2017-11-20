package com.example.aluno.plantozen20.activity;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.aluno.plantozen20.R;
import com.example.aluno.plantozen20.adapter.newAnotation;

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

        Button Cancelar = (Button) findViewById(R.id.buttonCancelar);
        setOnClickCancelar(Cancelar, this);

        Button Salvar = (Button) findViewById(R.id.buttonSalvar);
        setOnClickSalvar(Salvar, this);

        TextView texto = (TextView)findViewById(R.id.editText_nomenota);

        Bundle b = getIntent().getExtras();
        // int value = b.getInt("key");
        String titulo = b.getString("titulo");
        //  System.out.println(value);
        texto.setText(titulo);
        //Log.d(""+value);
        //AQUI DEVE PROCURAR NO BANCO O CARD CLICADO E MOSTRAR NA TEXTBOX AS ANOTAÇÕES SALVAS


    }

    private void setOnClickCancelar(Button cancelar, final NoteActivity mainActivity){
        cancelar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
//                Intent intent = new Intent(NoteActivity.this, MainActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(intent);
                finish();

            }
        });
    }

    private void setOnClickSalvar(Button salvar, final NoteActivity mainActivity){
        salvar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
               //SALVAR NO BANCO DE DADOS AS ANOTAÇÕES ESCRITAS
            }
        });
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

