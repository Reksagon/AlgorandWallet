package com.algorand.wallet.ui.swap;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.algorand.wallet.databinding.FragmentSwapBinding;


public class SwapFragment extends Fragment {

    private FragmentSwapBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentSwapBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

}