package direwolf.cozinhadesobrevivenciadosolteiromoderno.direwolf.cozinhadesobrevivenciadosolteiromoderno.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import direwolf.cozinhadesobrevivenciadosolteiromoderno.R;

public class FragmentBoloDeLeite extends Fragment {

    private Activity activity;
    @Override
    public void onAttach(Activity activity){

        super.onAttach(activity);
        this.activity = activity;

    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState){

        View view = layoutInflater.inflate(R.layout.activity_fragment_bolo_de_leite,container,false);

        WebView webView = (WebView)view.findViewById(R.id.webViewBoloDeLeite);
        WebSettings settings = webView.getSettings();
        settings.setSaveFormData(false);
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(false);
        webView.loadUrl("file:///android_asset/receitas_doces/bolo_de_leite.html");

        return view;
    }
}
