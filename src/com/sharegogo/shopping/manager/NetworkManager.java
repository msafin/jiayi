package com.sharegogo.shopping.manager;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.sharegogo.shopping.ShoppingApp;

public class NetworkManager {
	private static NetworkManager mInstance;
	private RequestQueue mRequestQueue;
	
	private NetworkManager(){
		mRequestQueue = Volley.newRequestQueue(ShoppingApp.getInstance());
	}
	
	public NetworkManager getInstance(){
		if(mInstance == null){
			synchronized(NetworkManager.class){
				if(mInstance == null){
					mInstance = new NetworkManager();
				}
			}
		}
		
		return mInstance;
	}
	
	public void enqueue(JsonObjectRequest request){
		mRequestQueue.add(request);
	}
	
	public void enqueue(StringRequest request){
		mRequestQueue.add(request);
	}
	
	public void cancel(Object tag){
		mRequestQueue.cancelAll(tag);
	}
}
