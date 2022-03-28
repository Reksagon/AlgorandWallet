package com.algorand.wallet.ui.splash;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.algorand.wallet.R;
import com.algorand.wallet.databinding.FragmentStartBinding;
import com.algorand.wallet.databinding.FragmentTwoSecondBinding;


public class TwoSecondFragment extends Fragment {

    FragmentTwoSecondBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTwoSecondBinding.inflate(getLayoutInflater());

        binding.imgClick.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                binding.imgClick.setImageDrawable(getActivity().getDrawable(R.drawable.ic_group_33546__1_));
                binding.bttnLog.setEnabled(true);
            }
        });

        binding.bttnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.fragmentContainerView, new LogInFragment(), null);
                transaction.commit();
            }
        });

        return binding.getRoot();
    }


}