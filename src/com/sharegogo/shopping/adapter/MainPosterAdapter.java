package com.sharegogo.shopping.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.sharegogo.shopping.fragment.MainPosterFragment;
import com.sharegogo.shopping.model.MainPosterData.AdvertiseItem;

public class MainPosterAdapter extends FragmentStatePagerAdapter{
	private ArrayList<AdvertiseItem> mData;
	private Context mContext;
	
	public MainPosterAdapter(FragmentManager fm,Context context) {
		super(fm);
		
		mContext = context;
		mData = new ArrayList<AdvertiseItem>();
		
		mData.add(new AdvertiseItem());
		mData.add(new AdvertiseItem());
		mData.add(new AdvertiseItem());
		
	}

	@Override
	public Fragment getItem(int position) {
		Bundle bundle = new Bundle();
		
		return Fragment.instantiate(mContext, MainPosterFragment.class.getName(),bundle);
	}

	@Override
	public int getCount() {
		
		return mData.size();
	}

}
