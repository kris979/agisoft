package com.agisoft.commission;

import java.util.concurrent.*;

/**
 * @author kris
 *
 */
public class CommissionCalculator {
	
	/**
	 * Creates new threads on demand.
	 */
	private Executor comissionExecutor = Executors.newCachedThreadPool();
	
	/**
	 * 
	 */
	private ExecutorCompletionService<Commission> commissionService = new ExecutorCompletionService<Commission>(comissionExecutor);

	
	public Future<Commission> submit(Commission commisionRequest) {
		return commissionService.submit(commisionRequest);
	}

	public Future<Commission> take() throws InterruptedException {
		return commissionService.take();
	}
	
}
