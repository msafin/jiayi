package com.sharegogo.shopping.activity;

import com.sharegogo.shopping.R;
import com.sharegogo.shopping.adapter.MainPosterAdapter;
import com.sharegogo.shopping.manager.MainPosterManager;
import com.viewpagerindicator.PageIndicator;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity{
	private ViewPager mViewPager;
	private PagerAdapter mAdapter;
	private PageIndicator mIndicator;
	
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.main);
		
		mViewPager = (ViewPager)findViewById(R.id.poster_pager);
		mIndicator = (PageIndicator)findViewById(R.id.indicator);
		
		mAdapter = new MainPosterAdapter(getSupportFragmentManager(),this);
		mViewPager.setAdapter(mAdapter);
		mIndicator.setViewPager(mViewPager);
		
		MainPosterManager.getInstance().pullPoster();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

}
