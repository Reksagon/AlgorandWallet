package com.algorand.wallet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;

import com.algorand.wallet.databinding.ActivitySplashBinding;
import com.algorand.wallet.databinding.FragmentStartBinding;
import com.algorand.wallet.ui.splash.SecondFragment;

import java.util.concurrent.TimeUnit;

public class SplashActivity extends AppCompatActivity {


    ActivitySplashBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        new AsyncTask<Void, Void, Void>()
        {
            @Override
            protected void onPostExecute(Void unused) {
                super.onPostExecute(unused);
                newFragment();
            }

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    TimeUnit.SECONDS.sleep(4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }

    private void newFragment()
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setReorderingAllowed(true);
        transaction.replace(binding.fragmentContainerView.getId(), new SecondFragment(), null);
        transaction.commit();
    }
}