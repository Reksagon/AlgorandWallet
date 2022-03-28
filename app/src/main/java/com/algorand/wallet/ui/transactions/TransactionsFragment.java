package com.algorand.wallet.ui.transactions;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.MainThread;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.algorand.wallet.R;
import com.algorand.wallet.databinding.FragmentTransactionsBinding;
import com.github.nikartm.button.FitButton;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class TransactionsFragment extends Fragment {


    FragmentTransactionsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentTransactionsBinding.inflate(inflater, container, false);

        binding.btnAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnAll.setButtonColor(getActivity().getColor(R.color.active));
                binding.btnAll.setTextColor(getActivity().getColor(R.color.white));
                binding.scrollAll.setVisibility(View.VISIBLE);
                binding.scrollRecieved.setVisibility(View.GONE);
                binding.scrollSend.setVisibility(View.GONE);
                binding.btnRecieved.setButtonColor(getActivity().getColor(R.color.white));
                binding.btnRecieved.setTextColor(getActivity().getColor(R.color.active));
                binding.btnSend.setButtonColor(getActivity().getColor(R.color.white));
                binding.btnSend.setTextColor(getActivity().getColor(R.color.active));
            }
        });

        binding.btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnSend.setButtonColor(getActivity().getColor(R.color.active));
                binding.btnSend.setTextColor(getActivity().getColor(R.color.white));

                binding.scrollSend.setVisibility(View.VISIBLE);
                binding.scrollAll.setVisibility(View.GONE);
                binding.scrollRecieved.setVisibility(View.GONE);

                binding.btnRecieved.setButtonColor(getActivity().getColor(R.color.white));
                binding.btnRecieved.setTextColor(getActivity().getColor(R.color.active));
                binding.btnAll.setButtonColor(getActivity().getColor(R.color.white));
                binding.btnAll.setTextColor(getActivity().getColor(R.color.active));
            }
        });

        binding.btnRecieved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnRecieved.setButtonColor(getActivity().getColor(R.color.active));
                binding.btnRecieved.setTextColor(getActivity().getColor(R.color.white));
                binding.scrollRecieved.setVisibility(View.VISIBLE);
                binding.scrollAll.setVisibility(View.GONE);
                binding.scrollSend.setVisibility(View.GONE);
                binding.btnAll.setButtonColor(getActivity().getColor(R.color.white));
                binding.btnAll.setTextColor(getActivity().getColor(R.color.active));
                binding.btnSend.setButtonColor(getActivity().getColor(R.color.white));
                binding.btnSend.setTextColor(getActivity().getColor(R.color.active));
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

        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main);
                navController.navigate(R.id.navigation_wallet);
            }
        });

        return binding.getRoot();
    }
}