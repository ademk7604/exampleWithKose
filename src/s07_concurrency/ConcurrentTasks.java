package s07_concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class ConcurrentTasks {
	public static void main(String[] args) {
		Runnable run = () -> System.out.println("Ben bir runnable programim");
		Thread thread = new Thread(run);
		thread.start();
		
		//10 tane pararlelde gise acacak havuzda //newFixedThreadPool(10)
		//newCachedThreadPool ile thred sayisi kararini java birakiyoruz
		ExecutorService executor = Executors.newCachedThreadPool(); //newFixedThreadPool(10)
		// her isi biten Thread isi bittiginde tekrar kullanilabiliyor.
		List<Runnable> listOfRunnable = Arrays.asList(
				() -> System.out.println("Runnable 1"),
				() -> System.out.println("Runnable 2"),
				() -> System.out.println("Runnable 3"),
				() -> System.out.println("Runnable 4"),
				() -> System.out.println("Runnable 5"),
				() -> System.out.println("Runnable 6"),
				() -> System.out.println("Runnable 7"),
				() -> System.out.println("Runnable 8"),
				() -> System.out.println("Runnable 9"));	
		
		IntStream.range(0, 9).forEach(i -> executor.submit(listOfRunnable.get(i)));
		
		IntStream.range(0, 100).forEach(i -> executor.submit(() -> {
			System.out.println("Task "+i+" executed by"+Thread.currentThread().getName());
		}));
	/*
	 * Runnable birsey return etmiyor void method gibi dusunebiliriz
	 * Ama Callable bir sey return eden bir method
	 * Runnable listesini submit methodu ile calistiriken,
	 * Callable i invokeAll methodu ile calistirabiliyoruz
	 */
		List<Callable<Integer>> listOfCallable = Arrays.asList(
				() -> {int a=1; System.out.println("Callable 1"); return a;},
				() -> {int a=2; System.out.println("Callable 2"); return a;},
				() -> {int a=4; System.out.println("Callable 3"); return a;},
				() -> {int a=7; System.out.println("Callable 4"); return a;},
				() -> {int a=11; System.out.println("Callable 5"); return a;},
				() -> {int a=16; System.out.println("Callable 6"); return a;});
		
		//invokeAll, listOfCallable listesindeki her bir fonk bir paralele atip bunlari calistiracak
		try {
			List<Future<Integer>> results = executor.invokeAll(listOfCallable);
			results.forEach(r -> {
				try {
					System.out.println("Result: "+r.get());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	

}
