package concurrency;

public class ThreadLocalId {

	ThreadLocal<Integer> local = new ThreadLocal<Integer>() {
		@Override
		protected Integer initialValue() {
			return 10;
		};
	};
	
	
	public ThreadLocalId() {
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ThreadLocalId().print();
	}
	
	private void print() {
		System.out.println(local.get());
	}

}
