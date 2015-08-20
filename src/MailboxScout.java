
//theworldisquiethere

import java.net.*;
import java.io.*;

public class MailboxScout implements Runnable {

	private DatagramSocket socket;

	public MailboxScout(DatagramSocket container2) {

		socket = container2;

	}

	public void run() {

		while (true) {

			DatagramPacket msg = new DatagramPacket(new byte[1000], 1000);
	
			try {

				socket.receive(msg);
		
			} catch (IOException e) {

			};

			String container = new String(msg.getData());
	
			if (container.substring(0, container.indexOf(' ')).equals("vfd"))

				CALM.box.mailAction(container.substring(container.indexOf(' ') + 1, container.length()));

		}

	}

}

