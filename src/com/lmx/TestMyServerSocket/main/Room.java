package com.lmx.TestMyServerSocket.main;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class Room{
	private ArrayList<Socket> socList = new ArrayList<Socket>();
	private LinkedList<History> history = new LinkedList<History>();
	public LinkedList<History> getHistory(){
		return history;
	}
 	public void chatting(Socket sockt,String name) {
		socList.add(sockt);
		for(int i=0; i<history.size();i++) {
			History hsout = history.get(i);
			String lineout = hsout.getLine();
			/*Date date = hsout.getDate();
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time =format.format(date);*/
			String out = lineout;
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
		ChatSocket cs = new ChatSocket(sockt,socList,history,name);
		cs.start();
	}
}
