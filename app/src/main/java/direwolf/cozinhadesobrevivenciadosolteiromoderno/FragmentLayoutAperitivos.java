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
import android.widget.Toast;

import direwolf.cozinhadesobrevivenciadosolteiromoderno.R;
import direwolf.cozinhadesobrevivenciadosolteiromoderno.direwolf.cozinhadesobrevivenciadosolteiromoderno.fragments.FragmentPacocaCaseira;
import direwolf.cozinhadesobrevivenciadosolteiromoderno.direwolf.cozinhadesobrevivenciadosolteiromoderno.fragments.FragmentQueijoDePipoqueiro;
import direwolf.cozinhadesobrevivenciadosolteiromoderno.direwolf.cozinhadesobrevivenciadosolteiromoderno.fragments.FragmentRolinhoEmpanadoDeFrios;

public class
        FragmentLayoutAperitivos extends AppCompatActivity {

    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;
    private ArrayAdapter<String> adapter;
    private ListView drawerList;
    private String tituloDaActivity;
    private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_layout_aperitivos);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayoutFragmentLayoutAperitivos);
        drawerList = (ListView) findViewById(R.id.navListFragmentLayoutAperitivos);
        tituloDaActivity = getTitle().toString();


        addDrawerItems();
        setUpDrawer();

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Intent intent = getIntent();
        if(intent != null){
            Bundle bundle = intent.getExtras();
            if(bundle != null){
                id = bundle.getInt("id");
            }
        }
        switch (id) {
            case 0:
                FragmentPacocaCaseira pacocaCaseira = new FragmentPacocaCaseira();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragmentLayoutAperitivos, pacocaCaseira);
                getSupportActionBar().setTitle(R.string.title_activity_fragment_pacoca_caseira);
                fragmentTransaction.commit();
                break;
            case 1:
                FragmentQueijoDePipoqueiro queijoDePipoqueiro = new FragmentQueijoDePipoqueiro();
                fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragmentLayoutAperitivos, queijoDePipoqueiro);
                getSupportActionBar().setTitle(R.string.title_activity_fragment_queijo_de_pipoqueiro);
                fragmentTransaction.commit();
                break;
            case 2:
                FragmentRolinhoEmpanadoDeFrios rolinhoEmpanadoDeFrios = new FragmentRolinhoEmpanadoDeFrios();
                fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragmentLayoutAperitivos, rolinhoEmpanadoDeFrios);
                getSupportActionBar().setTitle(R.string.title_activity_fragment_rolinho_empanado_de_frios);
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
        getMenuInflater().inflate(R.menu.menu_fragment_layout_aperitivos, menu);
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

        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0 ){
            getFragmentManager().popBackStack();
        } else {

            super.onBackPressed();
        }
    }
}