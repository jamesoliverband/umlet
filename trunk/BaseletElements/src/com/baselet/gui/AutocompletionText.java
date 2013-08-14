package com.baselet.gui;

public class AutocompletionText {
	private String text;
	private String info;
	private String base64Img;
	private boolean global;

	public AutocompletionText(String text, String info) {
		super();
		this.text = text;
		this.info = info;
	}
	
	public AutocompletionText(String text, String info, String base64Img) {
		super();
		this.text = text;
		this.info = info;
		this.base64Img = base64Img;
	}

	public String getText() {
		return text;
	}

	public String getInfo() {
		return info;
	}
	
	public void setGlobal(boolean global) {
		this.global = global;
	}

	public boolean isGlobal() {
		return global;
	}

	public String getHtmlInfo() {
		if (base64Img == null) {
			return getText() + " <span style='font-style:italic;color:gray'>" + getInfo() + "</span>";
		} else {
			return getText() + " <img src='data:image/gif;base64," + base64Img + "'>";
		}
	}
	
}