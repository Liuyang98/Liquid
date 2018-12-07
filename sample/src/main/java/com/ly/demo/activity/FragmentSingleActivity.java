package com.ly.demo.activity;

import android.os.Bundle;

import com.ly.demo.R;
import com.ly.demo.fragment.SingleFragment;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 单个Fragment
 */
public class FragmentSingleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);

        init();
    }

    private void init() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, new SingleFragment()).commit();
    }
}
