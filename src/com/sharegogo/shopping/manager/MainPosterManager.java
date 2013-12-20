package com.sharegogo.shopping.manager;

import com.android.volley.toolbox.JsonObjectRequest;
import com.sharegogo.shopping.HttpConfig;

public class MainPosterManager {
	private final String URL = "poster";
	
	private static MainPosterManager mInstance;
	
	private MainPosterManager(){
		
	}
	
	public static MainPosterManager getInstance(){
		if(mInstance == null){
			synchronized(MainPosterManager.class){
				if(mInstance == null){
					mInstance = new MainPosterManager();
				}
			}
		}
		
		return mInstance;
	}
	
	private String getUrl(){
		return HttpConfig.getHost() + URL;
	}
	
	public void pullPoster(){
		
	}
}
