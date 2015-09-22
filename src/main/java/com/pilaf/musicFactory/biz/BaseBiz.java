package com.pilaf.musicFactory.biz;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;

public abstract class BaseBiz {
	
	@Resource(mappedName = "ConnectionFactory")
	protected ConnectionFactory factory;
	
	@Resource(mappedName = "Queue")
	protected Queue queue;
	
	
	
	

}
