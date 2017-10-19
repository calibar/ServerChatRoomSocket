package com.lmx.TestMyServerSocket.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.ArrayList;

public class ShowRooms {
	ArrayList<Chatroom> ChatRoom;
	Socket Soc;
	public ShowRooms(Socket socket,ArrayList<Chatroom> chatroom){
		this.ChatRoom=chatroom;
		this.Soc=socket;
	}
	public void show(){
		for(int i=0;i<this.ChatRoom.size();i++){
			Chatroom room = this.ChatRoom.get(i);
			String Chatroom = "Chatroom"+room.roomID+"\n";
			try {
				Soc.getOutputStream().write(Chatroom.getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/*public ArrayList<Chatroom> Select() {
		/*String notion = "Existed Chatrooms :\n";
		try {
			this.Soc.getOutputStream().write(notion.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}*/

}
