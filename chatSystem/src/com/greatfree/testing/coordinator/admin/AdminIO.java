package com.greatfree.testing.coordinator.admin;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

import com.greatfree.concurrency.Sync;
import com.greatfree.multicast.ServerMessage;
import com.greatfree.remote.OutMessageStream;
import com.greatfree.remote.ServerIO;
import com.greatfree.testing.coordinator.CoordinatorMessageProducer;

/*
 * The class is actually an implementation of ServerIO, which serves for the administrator which interacts with the coordinator. 11/27/2014, Bing Li
 */

// Created: 11/27/2014, Bing Li
public class AdminIO extends ServerIO
{
	/*
	 * Initialize the server IO. The socket is the connection between the administrator and the coordinator. The collaborator is shared with other IOs to control the count of ServerIOs instances. 11/27/2014, Bing Li
	 */
	public AdminIO(Socket clientSocket, Sync collaborator, int remoteServerPort)
	{
		super(clientSocket, collaborator, remoteServerPort);
	}
	
	/*
	 * A concurrent method to respond the received messages asynchronously. 11/27/2014, Bing Li
	 */
	public void run()
	{
		ServerMessage message;
		while (!super.isShutdown())
		{
			try
			{
				// Wait and read messages from the administrator. 11/27/2014, Bing Li
				message = (ServerMessage)super.read();
				// Convert the received message to OutMessageStream and put it into the relevant dispatcher for concurrent processing. 11/27/2014, Bing Li
				CoordinatorMessageProducer.SERVER().produceAdminMessage(new OutMessageStream<ServerMessage>(super.getOutStream(), super.getLock(), message));
			}
			catch (SocketException e)
			{
				e.printStackTrace();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}
		}
	}
}
