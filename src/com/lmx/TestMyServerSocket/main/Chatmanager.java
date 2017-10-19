package com.lmx.TestMyServerSocket.main;

import java.util.Vector;

public class Chatmanager {

		private Chatmanager() {}
		private static final Chatmanager cm=new Chatmanager();
		public static Chatmanager getChatmanager() {
			return cm;
		}
		Vector<ChatSocket> vector =new Vector<ChatSocket>();
		
		public void add(ChatSocket cs) {
			vector.add(cs);
		}
		
		public void publish(ChatSocket cs, String out) {
			for (int i=0; i<vector.size();i++) {
				ChatSocket csChatSocket =vector.get(i);
				if(!cs.equals(csChatSocket)){
					csChatSocket.out(out+"\n");
					
				}
			}
		}
		
}
