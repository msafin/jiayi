package com.sharegogo.shopping.activity;

import com.sharegogo.shopping.R;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.Window;

public class SplashActivity extends FragmentActivity{
	private final int MSG_FINISH = 0;
	private final int DURATION = 2000;
	
	private Handler mHandler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			switch(msg.what){
				case MSG_FINISH:
					startMainActivity();
					break;
				}
			super.handleMessage(msg);
		}
	};
	
	@Override
	protected void onCreate(Bundle arg0) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(arg0);
		setContentView(R.layout.splash_activity);
		
		mHandler.sendEmptyMessageDelayed(MSG_FINISH, DURATION);
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
	
	private void startMainActivity(){
		Intent intent = new Intent(Intent.ACTION_MAIN);
		
		intent.setClass(this, MainActivity.class);
		startActivity(intent);
		finish();		
	}
}
