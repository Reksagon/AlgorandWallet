package com.algorand.wallet.ui.splash;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.algorand.wallet.R;
import com.algorand.wallet.databinding.FragmentSecondBinding;
import com.algorand.wallet.databinding.FragmentStartBinding;

public class SecondFragment extends Fragment {

    FragmentSecondBinding binding;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(getLayoutInflater());

        binding.btnRezerv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newFragment();
            }
        });

        return binding.getRoot();
    }

    private void newFragment()
    {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setReorderingAllowed(true);
        transaction.replace(R.id.fragmentContainerView, new LogInFragment(), null);
        transaction.commit();
    }
}