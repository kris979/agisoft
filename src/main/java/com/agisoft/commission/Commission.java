package com.agisoft.commission;

import java.util.concurrent.Callable;

public class Commission implements Callable<Commission> {

	private final CommissionRequest request;
	private double commission;
	
	public Commission(CommissionRequest request) {
		this.request = request;
	}

	public double getCommission() {
		return commission;
	}
	
	public void setCommission(double commission) {
		this.commission = commission;
	}
	
	public CommissionRequest getRequest() {
		return request;
	}

	/* (non-Javadoc)
	 * @see java.util.concurrent.Callable#call()
	 */
	@Override
	public Commission call() throws Exception {
		System.out.println(Thread.currentThread().getName() + " Calculating commision for request " + request.getI());
				
		this.commission = calculateCommission();
		return this;
	}

	private double calculateCommission() throws InterruptedException {
		Thread.sleep(2*1000);
		request.getRate();
		return 2.0D;
	}


}
