package com.greatfree.testing.message;

import java.io.ObjectOutputStream;
import java.util.concurrent.locks.Lock;

import com.greatfree.remote.OutMessageStream;

/*
 * The class is derived from OutMessageStream. It contains the received request, its associated output stream and the lock that keeps the responding operations atomic. 11/29/2014, Bing Li
 */

// Created: 11/29/2014, Bing Li
public class IsPublisherExistedStream extends OutMessageStream<IsPublisherExistedRequest>
{
	public IsPublisherExistedStream(ObjectOutputStream out, Lock lock, IsPublisherExistedRequest message)
	{
		super(out, lock, message);
	}
}
