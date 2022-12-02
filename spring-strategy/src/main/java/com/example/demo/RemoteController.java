package com.example.demo;

public class RemoteController {
	
	private ChangeChannel changeChannel;
	
	public RemoteController(ChangeChannel changeChannel) {
		this.changeChannel = changeChannel;
	}
	
	// 기능
	public String  change() {
		return changeChannel.channelName();
	}

}
