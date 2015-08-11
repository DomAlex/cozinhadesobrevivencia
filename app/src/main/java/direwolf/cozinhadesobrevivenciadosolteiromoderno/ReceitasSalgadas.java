package direwolf.cozinhadesobrevivenciadosolteiromoderno;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ReceitasSalgadas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receitas_salgadas);
        String[] receitasSalgadas = {"Bolo de Pão de Queijo", "Sopa Paraguaia", "Torta de Palmito", "Torta de Pizza"};

        ListView listaDeReceitasSalgadas;
        ArrayAdapter<String> adapter;


        listaDeReceitasSalgadas = (ListView)findViewById(R.id.listViewReceitasSalgadas);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,receitasSalgadas);
        listaDeReceitasSalgadas.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_receitas_salgadas, menu);
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
