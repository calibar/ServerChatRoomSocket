package com.lmx.TestMyServerSocket.main;

import java.net.Socket;

public class Chatroom extends Thread{
		int roomID;
		Socket Sok;
		public void getSocket(Socket socket){
			this.Sok =socket;
		}
		@Override
		public void run() {
			ChatSocket cs = new ChatSocket(Sok);
			cs.start();		
			Chatmanager.getChatmanager().add(cs);
		}
}
