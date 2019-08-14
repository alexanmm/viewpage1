package br.com.digitalhouse.viewpage1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicia o container com event fragment
        initFirstFragment();


    }

    private void initFirstFragment() {

        replaceFragment(new HomeFragment());

    }


    public void replaceFragment(Fragment fragment) {

        try {

            String TAG = fragment.getClass().toString();
            String backStackName = fragment.getClass().getName();

            FragmentManager manager = getSupportFragmentManager();

            boolean fragmentPopped = manager.popBackStackImmediate(backStackName, 0);

            if (!fragmentPopped && getSupportFragmentManager().findFragmentByTag(TAG) == null) {
                final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, fragment, TAG);
                ft.addToBackStack(backStackName);
                ft.commit();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
