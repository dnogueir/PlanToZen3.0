package com.example.aluno.plantozen20.activity;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.app.FragmentTransaction;


import com.example.aluno.plantozen20.model_classes.Anexo;
import com.example.aluno.plantozen20.model_classes.Nota;
import com.example.aluno.plantozen20.model_classes.Tag;
import com.example.aluno.plantozen20.model_classes.Tarefa;
import com.example.aluno.plantozen20.model.Anotacoes;
import com.example.aluno.plantozen20.model.Atividades;
import com.example.aluno.plantozen20.model.AtividadesTMI;
import com.example.aluno.plantozen20.adapter.newAnotation;
import com.example.aluno.plantozen20.adapter.newActivity;


import android.widget.TextView;

import com.example.aluno.plantozen20.R;
import com.orm.SchemaGenerator;
import com.orm.SugarContext;
import com.orm.SugarDb;


public class MainActivity extends AppCompatActivity {

    public Anotacoes aba_anotacoes;
    public Atividades aba_atividades;
    public AtividadesTMI aba_atividades_tmi;

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), MainActivity.this);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        //Image Button nova anotação e atividade
        ImageButton novaAnotacao = (ImageButton) findViewById(R.id.menu_item2);
        setOnClickAnotacao(novaAnotacao, this);

        ImageButton novaAtividade = (ImageButton) findViewById(R.id.menu_item);
        setOnClickAtividade(novaAtividade, this);


        // Iterate over all tabs and set the custom view
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(mSectionsPagerAdapter.getItem(i).getView());
        }

        // finaliza, reseta e reinicia o BD
        resetBD();
        // popula o BD
        populaBD();
    }

    private void setOnClickAnotacao(ImageButton novaAnotacao, final MainActivity mainActivity){
        novaAnotacao.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                newAnotation alertDialog = new newAnotation();
                alertDialog.rootRef(mainActivity);

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.addToBackStack(null);

                alertDialog.show(getSupportFragmentManager(),"Dialog");
            }
        });
    }


    private void setOnClickAtividade(ImageButton novaAtividade, final MainActivity mainActivity) {
        novaAtividade.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                newActivity alertDialog = new newActivity();
                alertDialog.rootRef(mainActivity);

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.addToBackStack(null);

                alertDialog.show(getSupportFragmentManager(), "Dialog");
            }
        });
    }

    private void resetBD() {
        Log.i("COMECOU A RESETAR O BD", "");
        SugarContext.terminate();
        SchemaGenerator schemaGenerator = new SchemaGenerator(getApplicationContext());
        schemaGenerator.deleteTables(new SugarDb(getApplicationContext()).getDB());
        SugarContext.init(getApplicationContext());
        schemaGenerator.createDatabase(new SugarDb(getApplicationContext()).getDB());
        Log.i("TERMINOU A RESETAR O BD", "");
    }

    private void populaBD() {
        Log.i("COMECOU A POPULAR O BD", "~~~~~~~~~~~~~~");
        // cria a tag TMI
        Tag tmi = new Tag("TMI", "", 0);
        tmi.save();
        // cria duas tarefas com a TAG TMI
        Tarefa ta = new Tarefa();
        ta.save();
        ta.addTituloDescr("Tarefa A", "Descr Tarefa A (TMI)");
        ta.addAnexo(new Anexo(tmi));
        //
        Tarefa tb = new Tarefa();
        tb.save();
        tb.addTituloDescr("Tarefa B", "Descr Tarefa B (TMI)");
        tb.addAnexo(new Anexo(tmi));
        // cria uma tarefa sem a TAG TMI
        Tarefa tc = new Tarefa();
        tc.save();
        tc.addTituloDescr("Tarefa C", "Descr Tarefa C");
        // Cria duas notas
        Nota nota = new Nota();
        nota.save();
        nota.addTituloDescr("Nota A", "Descr Nota A");
        //
        nota = new Nota();
        nota.save();
        nota.addTituloDescr("Nota B", "Descr Nota B");

        //
        Log.i("TERMINOU A POPULAR O BD", "~~~~~~~~~~~~~~");
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            //TextView textView = (TextView) rootView.findViewById(R.id.section_label);

            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        String tabTitles[] = new String[] { "TMI's", "Tarefas", "Anotações" };
        Context context;

        public SectionsPagerAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    aba_atividades_tmi = new AtividadesTMI();
                    return aba_atividades_tmi;
                case 1:
                    aba_atividades = new Atividades();
                    return aba_atividades;
                case 2:
                    aba_anotacoes = new Anotacoes();
                    return aba_anotacoes;
            }
            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            // Generate title based on item position
            return tabTitles[position];
        }
    }
}





