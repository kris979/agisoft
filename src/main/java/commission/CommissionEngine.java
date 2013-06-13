package commission;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CommissionEngine {
	
	private static CommissionCalculator calculator = new CommissionCalculator();
	
//	public void produceAndSubmitRequests() {
//		
//		CommissionRequest request = new CommissionRequest();
//		Commission c = new Commission(request);
//		Future<Double> submit = calculator.submit(c);
//	}
//
//	
//	public void consumeCommision() throws InterruptedException, ExecutionException {
//		Future<Double> take = calculator.take();
//		System.out.println("IsDone: " + take.isDone());
//		System.out.println("Commission: " + take.get());
//	}
	
	public static void main(String[] args) {
		CommissionEngine engine = new CommissionEngine();
		
		Runnable r1 = new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					CommissionRequest request = new CommissionRequest(i);
					Commission c = new Commission(request);
					Future<Commission> submit = calculator.submit(c);
				}
			}
		};
		
		Thread t1 = new Thread(r1);
		t1.start();
		
		Runnable r2 = new Runnable() {
			
			@Override
			public void run() {
				while (true) {
					try {
						Future<Commission> take = calculator.take();
						System.out.println("IsDone: " + take.isDone() + " Commission: " + take.get().getRequest().getI());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ExecutionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		Thread t2 = new Thread(r2);
		t2.start();
		
	}
}
