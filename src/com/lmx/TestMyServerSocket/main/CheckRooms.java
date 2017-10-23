package com.lmx.TestMyServerSocket.main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;

public class CheckRooms extends Thread {
	@Override
	public void run() {
		
		while (true) {
			Date today = new Date();
			Enumeration<String> e= RoomTable.Rtable.keys();
			while (e.hasMoreElements()) {
			String roomKey = (String) e.nextElement();
			Room room = RoomTable.Rtable.get(roomKey);
			if(room.getHistory().size()>0) {
				int i = room.getHistory().size()-1;
				History h= room.getHistory().get(i);
				Date a = h.getDate();
				/*DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time =format.format(a);*/
				/*System.out.println(time);*/
				long checkTime= today.getTime()-a.getTime();
				if(checkTime>=(1000*60)) {
					RoomTable.Rtable.remove(roomKey);
				}
			}
			}
		}
	}
}
