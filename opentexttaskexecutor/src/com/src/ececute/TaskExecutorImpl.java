package com.src.ececute;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import com.src.main.Main.Task;
import com.src.main.Main.TaskExecutor;

public class TaskExecutorImpl implements TaskExecutor{
	
	ExecutorService service;

	public TaskExecutorImpl(ExecutorService service) {
		this.service = service;
	}


	@Override
	public <T> Future<T> submitTask(Task<T> task) {
		return service.submit(task.taskAction());
	}


	public void shutdown() {
		this.service.shutdown();
	}


}
