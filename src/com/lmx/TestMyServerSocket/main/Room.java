package com.lmx.TestMyServerSocket.main;

import java.net.Socket;
import java.util.ArrayList;

public class Room{
	Socket sockt;
	ArrayList<Socket> socList = new ArrayList<Socket>();
	public void getSocket(Socket socket) {
		this.sockt=socket;
	}

	public void chatting() {
		socList.add(sockt);
		ChatSocket cs = new ChatSocket(sockt);
		cs.start();
	}
}
