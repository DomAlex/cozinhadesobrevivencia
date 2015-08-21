package direwolf.cozinhadesobrevivenciadosolteiromoderno;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import direwolf.cozinhadesobrevivenciadosolteiromoderno.R;
import direwolf.cozinhadesobrevivenciadosolteiromoderno.direwolf.cozinhadesobrevivenciadosolteiromoderno.fragments.FragmentBoloDeCaneca;
import direwolf.cozinhadesobrevivenciadosolteiromoderno.direwolf.cozinhadesobrevivenciadosolteiromoderno.fragments.FragmentBoloDeLeite;
import direwolf.cozinhadesobrevivenciadosolteiromoderno.direwolf.cozinhadesobrevivenciadosolteiromoderno.fragments.FragmentMousse;
import direwolf.cozinhadesobrevivenciadosolteiromoderno.direwolf.cozinhadesobrevivenciadosolteiromoderno.fragments.FragmentQueijadinha;
import direwolf.cozinhadesobrevivenciadosolteiromoderno.direwolf.cozinhadesobrevivenciadosolteiromoderno.fragments.FragmentTortaDeCoco;

public class FragmentLayoutReceitasDoces extends AppCompatActivity {
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;
    private ArrayAdapter<String> adapter;
    private ListView drawerList;
    private String tituloDaActivity;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_layout_receitas_doces);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayoutFragmentLayoutReceitasDoces);
        drawerList = (ListView) findViewById(R.id.navListFragmentLayoutReceitasDoces);
        tituloDaActivity = getTitle().toString();


        addDrawerItems();
        setUpDrawer();

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                id = bundle.getInt("id");
            }
        }
        switch (id) {
            case 0:
                FragmentBoloDeCaneca boloDeCaneca = new FragmentBoloDeCaneca();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragmentLayoutReceitasDoces, boloDeCaneca);
                getSupportActionBar().setTitle(R.string.title_activity_fragment_bolo_de_caneca);
                fragmentTransaction.commit();
                break;
            case 1:
                FragmentBoloDeLeite boloDeLeite = new FragmentBoloDeLeite();
                fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragmentLayoutReceitasDoces, boloDeLeite);
                getSupportActionBar().setTitle(R.string.title_activity_fragment_bolo_de_leite);
                fragmentTransaction.commit();
                break;
            case 2:
                FragmentMousse mousse = new FragmentMousse();
                fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragmentLayoutReceitasDoces, mousse);
                getSupportActionBar().setTitle(R.string.title_activity_fragment_mousse);
                fragmentTransaction.commit();
                break;
            case 3:
                FragmentQueijadinha queijadinha = new FragmentQueijadinha();
                fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragmentLayoutReceitasDoces, queijadinha);
                getSupportActionBar().setTitle(R.string.title_activity_fragment_queijadinha);
                fragmentTransaction.commit();
                break;
            case 4:
                FragmentTortaDeCoco tortaDeCoco = new FragmentTortaDeCoco();
                fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragmentLayoutReceitasDoces, tortaDeCoco);
                getSupportActionBar().setTitle(R.string.title_activity_fragment_torta_de_coco);
                fragmentTransaction.commit();
                break;
        }

    }

    protected void addDrawerItems() {
        String[] itemsDoNavigationDrawer = {"Inicio", "Receitas Salgadas", "Receitas Doces", "Aperitivos", "Molhos", "Sobre o app"};
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemsDoNavigationDrawer);
        drawerList.setAdapter(adapter);
        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it;
                switch (position) {
                    case 0:
                        it = new Intent(getApplicationContext(), MainActivity.class);
                        drawerLayout.closeDrawer(drawerList);
                        startActivity(it);
                        break;
                    case 1:
                        it = new Intent(getApplicationContext(), ReceitasSalgadas.class);
                        drawerLayout.closeDrawer(drawerList);
                        startActivity(it);
                        break;
                    case 2:
                        it = new Intent(getApplicationContext(), ReceitasDoces.class);
                        drawerLayout.closeDrawer(drawerList);
                        startActivity(it);
                        break;
                    case 3:
                        it = new Intent(getApplicationContext(), Aperitivos.class);
                        drawerLayout.closeDrawer(drawerList);
                        startActivity(it);
                        break;
                    case 4:
                        it = new Intent(getApplicationContext(), Molhos.class);
                        drawerLayout.closeDrawer(drawerList);
                        startActivity(it);
                        break;
                    case 5:
                        it = new Intent(getApplicationContext(), SobreOApp.class);
                        drawerLayout.closeDrawer(drawerList);
                        startActivity(it);
                        break;
                }
            }
        });

    }

    private void setUpDrawer() {
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open_drawer, R.string.close_drawer) {

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Navegação");
                invalidateOptionsMenu();

            }

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(tituloDaActivity);
                invalidateOptionsMenu();
            }

        };

        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        actionBarDrawerToggle.syncState();

    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fragment_layout_receitas_doces, menu);
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

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}