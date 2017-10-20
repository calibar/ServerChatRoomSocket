package com.lmx.TestMyServerSocket.main;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.ArrayList;

public class Room{
	private ArrayList<Socket> socList = new ArrayList<Socket>();
	private ArrayList<String> history = new ArrayList<String>();
	public void chatting(Socket sockt) {
		socList.add(sockt);
		for(int i=0; i<history.size();i++) {
			String out = history.get(i);
			try {
				sockt.getOutputStream().write(out.getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ChatSocket cs = new ChatSocket(sockt,socList,history);
		cs.start();
	}
}
