package com.ly.demo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ly.demo.R;
import com.ly.demo.fragment.SingleFragment;
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
