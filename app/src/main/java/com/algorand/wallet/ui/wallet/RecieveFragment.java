package com.algorand.wallet.ui.wallet;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.MainThread;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.algorand.wallet.R;
import com.algorand.wallet.databinding.FragmentRecieveBinding;
import com.algorand.wallet.databinding.FragmentWalletBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.concurrent.TimeUnit;


public class RecieveFragment extends Fragment {


    FragmentRecieveBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentRecieveBinding.inflate(inflater, container, false);
        getActivity().findViewById(R.id.nav_view).setVisibility(View.GONE);
        binding.imgBack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.nav_view);
                bottomNavigationView.setSelectedItemId(R.id.navigation_wallet);
                bottomNavigationView.setVisibility(View.VISIBLE);
            }
        });

        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            @MainThread
            public void handleOnBackPressed() {
                BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.nav_view);
                bottomNavigationView.setSelectedItemId(R.id.navigation_wallet);
                bottomNavigationView.setVisibility(View.VISIBLE);
            }
        });

        binding.btnCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.copied.setVisibility(View.VISIBLE);
                ClipboardManager clipboard = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("", "RF7WNLCHCBUNWC6CF65OXZZO554IGJSREAEWDNAJ54ALLM");
                clipboard.setPrimaryClip(clip);
                new AsyncTask<Void,Void, Void>(){
                    @Override
                    protected void onPostExecute(Void unused) {
                        super.onPostExecute(unused);
                        binding.copied.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    protected Void doInBackground(Void... voids) {
                        try {
                            TimeUnit.SECONDS.sleep(3);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }
                }.execute();
            }
        });

        return binding.getRoot();
    }
}