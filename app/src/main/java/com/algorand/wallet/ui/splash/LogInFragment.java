package com.algorand.wallet.ui.splash;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.algorand.wallet.MainActivity;
import com.algorand.wallet.R;
import com.algorand.wallet.databinding.FragmentLogInBinding;
import com.algorand.wallet.databinding.FragmentSecondBinding;


public class LogInFragment extends Fragment {

    private boolean error = false;

    public LogInFragment() {
        // Required empty public constructor
    }


    public static LogInFragment newInstance(String param1, String param2) {
        LogInFragment fragment = new LogInFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    FragmentLogInBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLogInBinding.inflate(getLayoutInflater());

        binding.editTextTextMultiLine.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length() >= 30)
                    binding.logInBttn.setEnabled(true);
                else
                    binding.logInBttn.setEnabled(false);

                if(error)
                {
                    binding.editTextTextMultiLine.setBackground(getActivity().getDrawable(R.drawable.edittext_bg));
                    binding.editTextTextMultiLine.setTextColor(getActivity().getColor(R.color.black));
                    binding.textViewLog.setText(getActivity().getString(R.string.log_in_txt));
                    error = false;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        binding.logInBttn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                binding.editTextTextMultiLine.setBackground(getActivity().getDrawable(R.drawable.edittext_bg_red));
                binding.editTextTextMultiLine.setTextColor(getActivity().getColor(R.color.red));
                error = true;
                binding.logInBttn.setEnabled(false);
                binding.textViewLog.setText(getActivity().getString(R.string.log_error));

                startActivity(new Intent(getActivity(), MainActivity.class));
            }
        });

        return binding.getRoot();
    }
}