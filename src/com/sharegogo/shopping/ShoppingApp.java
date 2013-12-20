package com.sharegogo.shopping;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.MemoryCacheAware;
import com.nostra13.universalimageloader.cache.memory.impl.LRULimitedMemoryCache;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.decode.BaseImageDecoder;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;

public class ShoppingApp extends Application
{
  private static ShoppingApp instance = new ShoppingApp();
  
  public static ShoppingApp getInstance()
  {
    return instance;
  }

  public void onCreate()
  {
	  super.onCreate();
	  initImageLoader(this);
  }

  public void onTerminate()
  {
	  super.onTerminate();
  }
  
  public void initImageLoader(Context context) {
		int memoryCacheSize = (int) (Runtime.getRuntime().maxMemory() / 8);

		MemoryCacheAware<String, Bitmap> memoryCache;
		
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
			memoryCache = new LruMemoryCache(memoryCacheSize);
		} else {
			memoryCache = new LRULimitedMemoryCache(memoryCacheSize);
		}

		ImageLoaderConfiguration.Builder builder = new ImageLoaderConfiguration.Builder(
				context).threadPoolSize(5)
				.threadPriority(Thread.NORM_PRIORITY - 2)
				.memoryCache(memoryCache).denyCacheImageMultipleSizesInMemory()
				.discCacheFileNameGenerator(new Md5FileNameGenerator())
				.imageDecoder(new BaseImageDecoder(false))
				.tasksProcessingOrder(QueueProcessingType.LIFO);
		
		ImageLoaderConfiguration config = builder.build();
		
		ImageLoader.getInstance().init(config);
	}

}