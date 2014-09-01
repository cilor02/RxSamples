package com.milo.rx;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.functions.Action1;
import rx.functions.Func1;

public class RxSample1 implements Observer<Integer>{
	
	@Override
	public void onNext (Integer value)
	{
		System.out.println(value);
	}

	public void onCompleted ()
	{
		
	}
	
	
	public void onError (Throwable t)
	{
		
	}
	
	
	class StringObserver implements Observer<String> 
	{
		@Override
		public void onNext (String value)
		{
			System.out.println(value);
		}
		@Override
		public void onCompleted ()
		{
			
		}
		
		@Override
		public void onError (Throwable t)
		{
			
		}
		
	}
	
	
	class IntegerObserver implements Observer<Integer> 
	{
		@Override
		public void onNext (Integer value)
		{
			System.out.println(value);
		}
		@Override
		public void onCompleted ()
		{
			
		}
		
		@Override
		public void onError (Throwable t)
		{
			
		}
		
	}
	
	public static void numbers1(){
	     Observable<Integer> observable = Observable.from(1,2,3,4,5,6,7,8); 
	     observable.subscribe( new Action1<Integer>() {
	    	 
	    	 public void call(Integer i)
	    	 {
	    		 System.out.println(i * 2);
	    	 }
	    	 
		});
	}
	
	public static void numbers(){
	     Observable<Integer> observable = Observable.just(1,2,3,4,5,6,7,8); 
	     observable.subscribe( new RxSample1() );
	}
	
	public static void numbersMap(){
	     Observable<Integer> observable = Observable.just(1,2,3,4,5,6,7,8); 
	     observable.map(new Func1<Integer, Integer>() { @Override
	    public Integer call(Integer i) {
	    	// TODO Auto-generated method stub
	    	return i - 10;
	    }
		}).subscribe( new RxSample1() );
	}
	
	public static void numbersFilter(){
	     Observable<Integer> observable = Observable.just(1,2,3,4,5,6,7,8); 
	     observable.filter(new Func1<Integer, Boolean>() {@Override
	    public Boolean call(Integer i) {
	    	// TODO Auto-generated method stub
	    	return i % 2 == 0;
	    }
		}).subscribe( new RxSample1() );
	}
	
	
	public static void numbersComposeFilterAndMap(){
	     Observable<Integer> observable = Observable.just(1,2,3,4,5,6,7,8); 
	     observable.filter(new Func1<Integer, Boolean>() {@Override
	    public Boolean call(Integer i) {
	    	// TODO Auto-generated method stub
	    	return i % 2 == 0;
	    }
		}).map(new Func1<Integer, String>() { @Override
	    public String call(Integer i) {
	    	// TODO Auto-generated method stub
	    	return "even number " + i;
	    }
		}).subscribe(  new RxSample1().new StringObserver() );
	}
	
	public static void numbers2(){
	     Observable<Integer> observable = Observable.just(1,2,3,4,5,6,7,8); 
	     observable.groupBy(
	    		 new Func1<Integer, Boolean>() 
	    		 {
	    	      public Boolean call(Integer i)
	    	        {return i%2==0 ;}
	    	     }).subscribe();
	
	}
	
	public static void numbers3(){
	     Observable<Long> observable = Observable.interval(2,TimeUnit.SECONDS); 
	     observable.subscribe( new Action1<Long>() {
	    	 
	    	 public void call(Long i)
	    	 {
	    		 System.out.println(i * 2);
	    	 }
	    	 
		});
	}

	
	public static void main (String[] args) throws Exception
	{
		
     //numbers1();
     //hello("mike","shaz");
     //numbersMap();
     numbersFilter();
     
     numbersComposeFilterAndMap();
     //Thread.sleep(20000);
     }
     
	public static void hello(String... names) {
	    Observable.from(names).subscribe(new Action1<String>() {

	        @Override
	        public void call(String s) {
	            System.out.println("Hello " + s + "!");
	        }

	    });
	}

	
}
