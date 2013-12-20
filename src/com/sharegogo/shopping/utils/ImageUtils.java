package com.sharegogo.shopping.utils;

import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.sharegogo.shopping.R;

public class ImageUtils{
	
	public static DisplayImageOptions getOptions(int defaultRes){
		DisplayImageOptions options = new DisplayImageOptions.Builder()
		.displayer(new FadeInBitmapDisplayer(500))
		.imageScaleType(ImageScaleType.EXACTLY).cacheInMemory(true)
		.showStubImage(defaultRes)
		.showImageForEmptyUri(defaultRes)
		.cacheOnDisc(true).build();
		
		return options;
	}
	
	public static void displayImage(String uri, ImageView imageView,int defaultRes) {
		DisplayImageOptions options = getOptions(defaultRes);
		
		displayImage(uri, imageView, options, null);
	}
	
	public static void displayImage(String uri, ImageView imageView,
			DisplayImageOptions options) {
		
		if(options == null){
			options = getOptions(R.drawable.logo);
		}
		
		displayImage(uri, imageView, options, null);
	}

	public static void displayImage(String uri, ImageView imageView,
			DisplayImageOptions options, ImageLoadingListener listener) {
		
		if(options == null){
			options = getOptions(R.drawable.logo);
		}
		
		try {

			String imageUri = uri;
			if (uri != null && uri.length() > 0) {
				if (uri.startsWith("/"))
					imageUri = "file://" + uri;

			}

			if (listener == null) {
				ImageLoader.getInstance().displayImage(imageUri, imageView,
						options);
			} else {
				ImageLoader.getInstance().displayImage(imageUri, imageView,
						options, listener);
			}
		} catch (OutOfMemoryError e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}