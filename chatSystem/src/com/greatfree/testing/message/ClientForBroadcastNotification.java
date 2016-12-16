package com.greatfree.testing.message;

import com.greatfree.multicast.ServerMessage;

/*
 * The notification contains the data of a message. It is sent to a server such that the data on the server can be broadcast. 02/06/2016, Bing Li
 */

// Created: 11/21/2016, Bing Li
public class ClientForBroadcastNotification extends ServerMessage
{
	private static final long serialVersionUID = 8076467521111214177L;
	
	private String message;

	public ClientForBroadcastNotification(String message)
	{
		super(MessageType.CLIENT_FOR_BROADCAST_NOTIFICATION);
		this.message = message;
	}

	public String getMessage()
	{
		return this.message;
	}
}
