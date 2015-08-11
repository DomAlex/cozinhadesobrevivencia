package direwolf.cozinhadesobrevivenciadosolteiromoderno;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ReceitasDoces extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receitas_doces);

        ListView listaDeReceitasDoces;
        String[] receitasDoces = {"Bolo de Caneca", "Bolo de Leite","Mousse de Maracujá","Queijadinha","Torta de Coco"};
        ArrayAdapter<String> adapter;

        listaDeReceitasDoces = (ListView)findViewById(R.id.listViewReceitasDoces);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,receitasDoces);
        listaDeReceitasDoces.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_receitas_doces, menu);
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
