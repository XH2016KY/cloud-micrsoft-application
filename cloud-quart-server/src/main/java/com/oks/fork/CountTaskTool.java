package com.oks.fork;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import com.oks.pojo.TestDemo;

public class CountTaskTool {
	
	
	public static List<TestDemo>selectTask(Integer start,Integer end) throws InterruptedException, ExecutionException{
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		CountTask task = new CountTask(start, end);
		try {
			ForkJoinTask<List<TestDemo>> result = forkJoinPool.submit(task);
			List<TestDemo> list = result.get();
			System.out.println(list.size());
			return list;
		} finally {
			forkJoinPool.shutdown();
		}
		
	}

}
