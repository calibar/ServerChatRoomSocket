package com.lmx.TestMyServerSocket.main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ServerListener extends Thread {
	@Override
	public void run() {
		try {
			ServerSocket severSocket= new ServerSocket(12345);
			//block
			while (true) {
				Socket socket= severSocket.accept();
				//establish linkage
				JOptionPane.showMessageDialog(null , "hellow world");	
				ChatSocket cs = new ChatSocket(socket);
				cs.start();
				Chatmanager.getChatmanager().add(cs);			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
