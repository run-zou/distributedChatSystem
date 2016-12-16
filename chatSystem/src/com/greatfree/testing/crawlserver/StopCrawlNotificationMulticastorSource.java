package com.greatfree.testing.crawlserver;

import com.greatfree.multicast.ChildMulticastorSource;
import com.greatfree.remote.FreeClientPool;
import com.greatfree.testing.message.StopCrawlMultiNotification;

/*
 * The sources that are needed to create an instance of ChildMulticastor are enclosed in the class. That is required by the pool to create children multicastors. 11/27/2014, Bing Li
 */

// Created: 11/27/2014, Bing Li
public class StopCrawlNotificationMulticastorSource extends ChildMulticastorSource<StopCrawlMultiNotification, StopCrawlMultiNotificationCreator>
{
	/*
	 * Initialize the source. 11/27/2014, Bing Li
	 */
	public StopCrawlNotificationMulticastorSource(FreeClientPool clientPool, int treeBranchCount, int serverPort, StopCrawlMultiNotificationCreator creator)
	{
		super(clientPool, treeBranchCount, serverPort, creator);
	}
}
