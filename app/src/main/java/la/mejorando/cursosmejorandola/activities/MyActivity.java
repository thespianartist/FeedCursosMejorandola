package la.mejorando.cursosmejorandola.activities;

import android.app.Activity;
import android.os.Bundle;

import la.mejorando.cursosmejorandola.R;
import la.mejorando.cursosmejorandola.fragments.CursosFragment;


public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new CursosFragment())
                    .commit();
        }
    }

}
