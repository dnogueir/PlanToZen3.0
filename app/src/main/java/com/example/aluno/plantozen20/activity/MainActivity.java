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

        //Image Button nova anotação
        ImageButton novaAnotacao = (ImageButton) findViewById(R.id.menu_item2);
        novaAnotacao.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                newAnotation alertDialog = new newAnotation();

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.addToBackStack(null);

                alertDialog.show(getSupportFragmentManager(),"Dialog");
            }
        });

        //Image Button nova atividade
        ImageButton novaAtividade = (ImageButton) findViewById(R.id.menu_item);
        novaAtividade.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                newActivity alertDialog = new newActivity();

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.addToBackStack(null);

                alertDialog.show(getSupportFragmentManager(),"Dialog");
            }
        });

        // Iterate over all tabs and set the custom view
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(mSectionsPagerAdapter.getItem(i).getView());
        }



        // TODO: deletar e popular o BD. acho que aqui é um lugar bom

        // finaliza, reseta e reinicia o BD
         // descomente para resetar e popular o BD a cada inicialização
        Log.i("COMECOU A RESETAR O BD", "~~~~~~~~~~~~~~");
       // SugarContext.terminate();
        SchemaGenerator schemaGenerator = new SchemaGenerator(getApplicationContext());
        //schemaGenerator.deleteTables(new SugarDb(getApplicationContext()).getDB());
        SugarContext.init(getApplicationContext());
        schemaGenerator.createDatabase(new SugarDb(getApplicationContext()).getDB());
        Log.i("TERMINOU A RESETAR O BD", "~~~~~~~~~~~~~~");
       // popula o BD
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
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);


/*
            String str_do_textView = "aqui eu crio um novo texto na RAM <abc da RAM> e mostro;\n";
            str_do_textView += " daí mudo pra <abc do BD> e salvo no BD; daí mudo o texto da RAM, daí carrego o PRIMEIRO do BD pra RAM e mostro.\n\n\n";
            str_do_textView += getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)) + "\n\n\n";


            Tag tg = new Tag("<abc da RAM>", "simbolo", 0x000000);

            str_do_textView += tg.nome + "\n";

            tg.nome = "<abc do BD>";

            tg.save();
            tg.nome = "<abc DESCARTADO>";
            tg = Tag.findById(Tag.class, 1L); // 1L é 1 em long int 64 bits :|
            str_do_textView += tg.nome + "\n\n\n\n";

            str_do_textView += "agora eu vou carregar todos que tem no BD e mostrar na ordem:\n\n";
            Iterator<Tag> tags = Tag.findAll(Tag.class);
            while(tags.hasNext()) {
                tg = tags.next();
                str_do_textView += tg.nome + "\n";
            }





            textView.setText(str_do_textView);*/
         //   textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
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
                    return new AtividadesTMI();
                case 1:
                    return new Atividades();
                case 2:
                    return new Anotacoes();
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





