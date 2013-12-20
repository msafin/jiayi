package com.sharegogo.shopping;

import android.app.Application;

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
   
  }

  public void onTerminate()
  {
    super.onTerminate();
  }
}