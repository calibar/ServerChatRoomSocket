package com.lmx.TestMyServerSocket.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.ArrayList;

public class ChatSocket extends Thread {
		Socket socket;
		ArrayList<Socket> SkList;
		ArrayList<String> Hty;
	public ChatSocket(Socket s,ArrayList<Socket> slist,ArrayList<String> hstry) {
		this.socket =s;
		this.SkList =slist;
		this.Hty =hstry;
	}
	

	public void out(String out) {
		try {
			socket.getOutputStream().write(out.getBytes("UTF-8"));

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void broadcast() {
		
	}
	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(
							socket.getInputStream(),"UTF-8"));
			String line = null;
			while ((line = br.readLine())!=null) {
				String line1= "\n"+line+"\n";
				Hty.add(line1);
				for (int i=0; i<SkList.size();i++) {
					Socket csChatSocket =SkList.get(i);
					if(!socket.equals(csChatSocket)){
						csChatSocket.getOutputStream().write(line1.getBytes("UTF-8"));
						
					}
				}
			}
			br.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
