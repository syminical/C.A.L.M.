
//theworldisquiethere

import java.net.*;
import java.util.*;
import java.io.*;

public class Mailbox {

	private static DatagramSocket socket;
	private Thread mailScout;

	public Mailbox() {

		try {

			socket = new DatagramSocket(1498);

			socket.setBroadcast(true);

		} catch (SocketException e) {

		}

		MailboxScout ms = new MailboxScout(socket);

		mailScout = new Thread(ms);

		mailScout.start();

	}

	public void send(String container) {

		try {

			Enumeration interfaces = NetworkInterface.getNetworkInterfaces();

			while (interfaces.hasMoreElements()) {

				NetworkInterface iface = (NetworkInterface)interfaces.nextElement();

				if (iface.isLoopback() || !iface.isUp())

					continue;

				for (InterfaceAddress ifaceAdd : iface.getInterfaceAddresses()) {

					InetAddress broadcast = ifaceAdd.getBroadcast();

					if (broadcast == null)
	
						continue;

					try {

						DatagramPacket mail = new DatagramPacket(container.getBytes(), container.getBytes().length, broadcast, 1498);

						socket.send(mail);

					} catch (SocketException e) {

					} catch (IOException e) {

					}

				}

			}

		} catch (SocketException e) {

		}

	}	

}

