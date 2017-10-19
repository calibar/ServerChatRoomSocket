package com.lmx.TestMyServerSocket.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class ServerListener extends Thread {
	@Override
	public void run() {
		try {
			Room r1 = new Room();
			Room r2 = new Room();
			RoomTable.Rtable.put("Default1", r1);
			RoomTable.Rtable.put("Default2", r2);
			ServerSocket severSocket= new ServerSocket(12345);
			//block
			while (true) {
				Socket socket= severSocket.accept();
				//establish linkage
				/*JOptionPane.showMessageDialog(null , "hello world");	*/
				String connectinfo = new String("Connected to Server\n");
				socket.getOutputStream().write(connectinfo.getBytes("UTF-8"));
				Enumeration<String> e= RoomTable.Rtable.keys();
				String exrooms = new String("Existed Rooms :\n");
				socket.getOutputStream().write(exrooms.getBytes("UTF-8"));
				while (e.hasMoreElements()) {
					String key = "["+e.nextElement()+"] ";
					socket.getOutputStream().write(key.getBytes("UTF-8"));
				}
				Enumeration<Room> e1 =RoomTable.Rtable.elements();
				while (e1.hasMoreElements()) {
					Room rm = e1.nextElement();	
				}
				boolean flag=true;
				while (flag) {
					String instrument = new String("\nInstrument: Press 1 for choosing room  Press 2 for creating room\n");
					socket.getOutputStream().write(instrument.getBytes("UTF-8"));
					BufferedReader br = new BufferedReader(
							new InputStreamReader(
									socket.getInputStream(),"UTF-8"));
					String line = br.readLine();
					if(line.equals("choose")) {
						String notion1 = new String("Please input the name of the room you want to join:");
						socket.getOutputStream().write(notion1.getBytes("UTF-8"));
						BufferedReader br1 = new BufferedReader(
								new InputStreamReader(
										socket.getInputStream(),"UTF-8"));
						String line1 = br1.readLine();
						if(RoomTable.Rtable.containsKey(line1)) {
							Room eroom = RoomTable.Rtable.get(line1);
							eroom.getSocket(socket);
							String notion2 = "Welcome to room : "+"["+line1+"]\n";
							socket.getOutputStream().write(notion2.getBytes("UTF-8"));
							flag = false;
						}else {
							socket.getOutputStream().write("There's no such a room, try again!\n".getBytes("UTF-8"));
						}

					}else if (line.equals("creat")) {
						socket.getOutputStream().write("Please name the new room\n".getBytes("UTF-8"));
						BufferedReader br2 = new BufferedReader(
								new InputStreamReader(
										socket.getInputStream(),"UTF-8"));
						String line2 = br2.readLine();
						Room nroom = new Room();
						RoomTable.Rtable.put(line2,nroom);
						nroom.getSocket(socket);
						String notion3 = "Welcome to room : "+"["+line2+"]\n";
						socket.getOutputStream().write(notion3.getBytes("UTF-8"));
						flag=false;
					}
				}

				/*ChatSocket cs = new ChatSocket(socket);
				cs.start();		
				Chatmanager.getChatmanager().add(cs);*/	}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
