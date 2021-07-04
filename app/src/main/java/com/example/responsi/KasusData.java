package com.example.responsi;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class KasusData {

	@SerializedName("metadata")
	private Metadata metadata;

	@SerializedName("content")
	private ArrayList<KasusContentItem> content;

	public void setMetadata(Metadata metadata){
		this.metadata = metadata;
	}

	public Metadata getMetadata(){
		return metadata;
	}

	public void setContent(ArrayList<KasusContentItem> content){
		this.content = content;
	}

	public ArrayList<KasusContentItem> getContent(){
		return content;
	}

	@Override
 	public String toString(){
		return 
			"KasusData{" +
			"metadata = '" + metadata + '\'' + 
			",content = '" + content + '\'' + 
			"}";
		}
}