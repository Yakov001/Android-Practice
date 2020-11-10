package com.example.recyclerviewtraining;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class ChoseCurrencyActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment(){
        return new CurrencyFragment();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
