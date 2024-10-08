package com.src.main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.src.constant.Constants;
import com.src.ececute.TaskExecutorImpl;
import com.src.helper.TasksHelper;
import com.src.main.Main.Task;

public class Runner {

	/**
	 * To create a thread pool, it is recommended to determine the number of threads per below logic:
	 * If the thread operation is CPU intensive (like heavy computations) -
	 * 		thread count should be in sync with the number of CPU cores available
	 * If the thread operation is I/O intensive (like DB or URL calls) - 
	 * 		thread count should be high to avoid delay in picking up next set of tasks
	 * 
	 * For this practical demo, we are considering a small thread count = 5
	 * 
	 * */
	private static String taskNature  = Constants.DEFAULT;
	
	
	/**
	 * Main runner method to start the demo
	 */
	public static void main(String[] args) {
		
		int threadCount = getOptimumThreadCount(taskNature);

		/* Initializing executor service with the thread count decided 
		 * Internally LinkedBlockingQueue is used by default
		 * Advantages of LinkedBlockingQueue - 
		 * 		helps to store tasks in first in first out order
		 * 		has a thread-safe implementation, which helps in handling concurrent tasks pickup
		 **/
		ExecutorService service = Executors.newFixedThreadPool(threadCount);
		
		// Creating an implemented object per the given TaskExecutor design
		TaskExecutorImpl taskExecutorImpl = new TaskExecutorImpl(service);
		
		// Creating tasks for the practical demo
		List<Task<Integer>> tasks = TasksHelper.getTasksForExecution();
		
		// placeholder list to store the future responses for respective tasks
		List<Future<Integer>> futureList = new ArrayList<Future<Integer>>();
		
		for (Task<Integer> task : tasks) {
			futureList.add(taskExecutorImpl.submitTask(task));
		}
		
		for (Future<Integer> future : futureList) {
			try {
				System.out.println("Response from Future: " + future.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		
		// Shutting down the executor service after the ongoing tasks are completed
		taskExecutorImpl.shutdown();
		
	}

	/**
	 * Method to select thread counts per required scenario
	 * */
	private static int getOptimumThreadCount(String task) {

		int threadCount;
		if (task.equals(Constants.CPU_INTENSIVE)) {
			threadCount = Runtime.getRuntime().availableProcessors();
		} else if (task.equals(Constants.IO_INTENSIVE)) {
			threadCount = 100;
		} else {
			threadCount = 5;
		}
		
		System.out.println("Thread count selected: " + threadCount);
		
		return threadCount;
	}

}
