package com.oks.fork;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CountTaskSum extends RecursiveTask<Integer>{

	private static final long serialVersionUID = 2642550928885644282L;
	
	private static final Integer MAX_COUNT=200;
	
	private int start;
	
	private int end;
	
	public CountTaskSum(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}


	@Override
	protected Integer compute() {
		
		int sum =0;
		
		//1. 查询TestDemo的个数
		if(end-start<MAX_COUNT) {
			for(int i=start;i<=end;i++) {
				sum +=i;
			}
		}
		//2.如果查询的个数>100则分任务进行
		else {
			// 分成4个任务
			ArrayList<CountTaskSum> subTasks = new ArrayList<>();
			int step = (0+end+start)/4;
			log.info("step:{}",step);
			int pos=0;
			for(int i=0;i<4;i++) {
				// 分解成分页查询
				int lastOne = pos+step;
				if(lastOne>end) 
					lastOne=end;
				    log.info("lastOne:{}",Thread.currentThread().getName()+"|"+lastOne);
				CountTaskSum subTask = new CountTaskSum(pos, lastOne);
				pos+=step+1;
				log.info("pos:{}",pos);
				subTasks.add(subTask);
				subTask.fork();
			}
			for(CountTaskSum t:subTasks) {
				log.info("分布结果:{}",Thread.currentThread().getName()+"->"+t.join());
				sum+=t.join();
			}
			
		}
		return sum;
	}
	
	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		CountTaskSum task = new CountTaskSum(0, 600);
		ForkJoinTask<Integer> result = forkJoinPool.submit(task);
		try {
			System.out.println(result.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		finally {
			forkJoinPool.shutdown();
		}
	}

}
