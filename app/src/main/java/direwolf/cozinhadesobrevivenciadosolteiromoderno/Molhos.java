package direwolf.cozinhadesobrevivenciadosolteiromoderno;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Molhos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_molhos);
        ListView listaDeMolhosEPastas;
        String[] receitasDeMolhos = {"Molho Branco","Molho de Tomate", "Pasta de cebola", "Molho Americano","Pasta de Galinha","Pasta de Atum","Pasta de Presunto"};
        ArrayAdapter<String> adapter;

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,receitasDeMolhos);
        listaDeMolhosEPastas = (ListView)findViewById(R.id.listViewMolhosEpastas);
        listaDeMolhosEPastas.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_molhos, menu);
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
