package com.sharegogo.shopping.model;

import java.io.StringReader;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;

public class MainPosterData {

	static public MainPosterData fromJson(String response)
	{
		Gson gson = new Gson();
		
		JsonReader reader = new JsonReader(new StringReader(response));
		reader.setLenient(true);
		
		MainPosterData data = null;
		try
		{
			data = gson.fromJson(reader, MainPosterData.class);
		}
		catch(JsonSyntaxException e)
		{
			e.printStackTrace();
		}
		catch(JsonIOException e)
		{
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return data;
	}
	
	public static class AdvertiseItem{
		
	}
}
