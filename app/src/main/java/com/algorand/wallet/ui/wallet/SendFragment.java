package com.algorand.wallet.ui.wallet;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.MainThread;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.algorand.wallet.R;
import com.algorand.wallet.databinding.FragmentRecieveBinding;
import com.algorand.wallet.databinding.FragmentSendBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class SendFragment extends Fragment {

    FragmentSendBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSendBinding.inflate(inflater, container, false);
        getActivity().findViewById(R.id.nav_view).setVisibility(View.GONE);

        binding.numberTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length() == 0)
                    binding.warning.setVisibility(View.GONE);
                if (i1 == 0 && i2 == 1)
                    binding.warning.setVisibility(View.GONE);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        binding.btnRezerv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.warning.setVisibility(View.VISIBLE);
            }
        });

        binding.imgBack3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main);
                navController.navigate(R.id.navigation_wallet);
            }
        });

        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            @MainThread
            public void handleOnBackPressed() {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main);
                navController.navigate(R.id.navigation_wallet);
            }
        });
        return binding.getRoot();
    }
}