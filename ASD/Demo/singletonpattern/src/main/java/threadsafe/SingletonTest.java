package threadsafe;

public class SingletonTest {
	public static void main(String[] args) {
        //Thread 1
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
            	ConnectionPool instance1 = ConnectionPool.getPool();
                System.out.println("Instance 1 hash:" + instance1.hashCode());
            }
        });

        //Thread 2
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
            	ConnectionPool instance2 = ConnectionPool.getPool();
                System.out.println("Instance 2 hash:" + instance2.hashCode());
            }
        });

        //start both the threads
        t1.start();
        t2.start();
   }
}
