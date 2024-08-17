package com.src.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.src.main.Main.Task;
import com.src.main.Main.TaskGroup;
import com.src.main.Main.TaskType;

public class TasksHelper {
	
	private static UUID taskGroupOneUUID   = UUID.randomUUID();
	private static UUID taskGroupTwoUUID   = UUID.randomUUID();
	private static UUID taskGroupThreeUUID = UUID.randomUUID();
	
	/**
	 * Method to create random tasks per the requirement:
	 * 		tasks are created under respective task groups
	 * 		tasks are of either Read or Write, 2 types only
	 * 		
	 * For this practical demo, 3 task groups are considered, with respective already created UUIDs
	 * */
	public static List<Task<Integer>> getTasksForExecution() {
		
		TaskGroup taskGroupOne             = new TaskGroup(taskGroupOneUUID);
		TaskGroup taskGroupTwo             = new TaskGroup(taskGroupTwoUUID);
		TaskGroup taskGroupThree           = new TaskGroup(taskGroupThreeUUID);
		
		List<Task<Integer>> tasksList = new ArrayList<Task<Integer>>();
		
		int taskCounter = 1;
		
		tasksList.add(new Task<Integer>(taskGroupOne.groupUUID()  , taskGroupOne  , TaskType.READ , new CallableTask(taskCounter++)));
		tasksList.add(new Task<Integer>(taskGroupTwo.groupUUID()  , taskGroupTwo  , TaskType.WRITE, new CallableTask(taskCounter++)));
		tasksList.add(new Task<Integer>(taskGroupThree.groupUUID(), taskGroupThree, TaskType.READ , new CallableTask(taskCounter++)));
		tasksList.add(new Task<Integer>(taskGroupThree.groupUUID(), taskGroupThree, TaskType.WRITE , new CallableTask(taskCounter++)));
		tasksList.add(new Task<Integer>(taskGroupOne.groupUUID()  , taskGroupOne  , TaskType.READ , new CallableTask(taskCounter++)));
		
		tasksList.add(new Task<Integer>(taskGroupOne.groupUUID()  , taskGroupOne  , TaskType.READ , new CallableTask(taskCounter++)));
		tasksList.add(new Task<Integer>(taskGroupTwo.groupUUID()  , taskGroupTwo  , TaskType.WRITE, new CallableTask(taskCounter++)));
		tasksList.add(new Task<Integer>(taskGroupThree.groupUUID(), taskGroupThree, TaskType.READ , new CallableTask(taskCounter++)));
		tasksList.add(new Task<Integer>(taskGroupOne.groupUUID()  , taskGroupOne  , TaskType.READ , new CallableTask(taskCounter++)));
		tasksList.add(new Task<Integer>(taskGroupTwo.groupUUID()  , taskGroupTwo  , TaskType.WRITE, new CallableTask(taskCounter++)));
		
		tasksList.add(new Task<Integer>(taskGroupThree.groupUUID(), taskGroupThree, TaskType.READ , new CallableTask(taskCounter++)));
		tasksList.add(new Task<Integer>(taskGroupTwo.groupUUID()  , taskGroupTwo  , TaskType.WRITE, new CallableTask(taskCounter++)));
		tasksList.add(new Task<Integer>(taskGroupTwo.groupUUID()  , taskGroupTwo  , TaskType.WRITE, new CallableTask(taskCounter++)));
		tasksList.add(new Task<Integer>(taskGroupTwo.groupUUID()  , taskGroupTwo  , TaskType.READ, new CallableTask(taskCounter++)));
		tasksList.add(new Task<Integer>(taskGroupTwo.groupUUID()  , taskGroupTwo  , TaskType.WRITE, new CallableTask(taskCounter++)));
		
		return tasksList;
	}

}
