package com.algorand.wallet.ui.splash;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;

import com.algorand.wallet.R;
import com.algorand.wallet.databinding.ActivityMainBinding;
import com.algorand.wallet.databinding.ActivitySplashBinding;
import com.algorand.wallet.databinding.FragmentStartBinding;


public class StartFragment extends Fragment {

    FragmentStartBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentStartBinding.inflate(getLayoutInflater());


        return binding.getRoot();
    }
}