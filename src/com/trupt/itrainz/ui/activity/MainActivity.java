package com.trupt.itrainz.ui.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.trupt.itrainz.R;
import com.trupt.itrainz.ui.fragment.BaseFragment;
import com.trupt.itrainz.ui.fragment.MainFragment;

public class MainActivity extends BaseActivity {

	BaseFragment fragment;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		FragmentManager fragmentManager = getFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		this.fragment = new MainFragment();
		fragmentTransaction.replace(R.id.layoutMain, this.fragment);
		fragmentTransaction.commit();
	}
}
