package com.example.responsi;

import com.google.gson.annotations.SerializedName;

public class KasusResponse{

	@SerializedName("status_code")
	private int statusCode;

	@SerializedName("kasusData")
	private KasusData kasusData;

	public void setStatusCode(int statusCode){
		this.statusCode = statusCode;
	}

	public int getStatusCode(){
		return statusCode;
	}

	public void setKasusData(KasusData kasusData){
		this.kasusData = kasusData;
	}

	public KasusData getKasusData(){
		return kasusData;
	}

	@Override
 	public String toString(){
		return 
			"KasusResponse{" + 
			"status_code = '" + statusCode + '\'' + 
			",kasusData = '" + kasusData + '\'' +
			"}";
		}
}