package com.src.helper;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<Integer>{

	int taskNum;
	
	public CallableTask(int i) {
		this.taskNum = i;
	}

	@Override
	public Integer call() throws Exception {
		Thread.sleep(100);
		return taskNum;
	}

}
