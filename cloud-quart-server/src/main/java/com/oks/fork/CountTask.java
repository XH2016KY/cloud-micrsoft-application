package com.oks.fork;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import com.oks.pojo.TestDemo;
import com.oks.utils.TestDemoJDBC;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * 注释: 使用JDBC、Fork/Join分任务查询所有数据
 * @author happy everyday
 * 2019年3月3日上午10:18:27
 */
@Slf4j
public class CountTask extends RecursiveTask<List<TestDemo>>{

	private static final long serialVersionUID = 2642550928885644282L;
	
	private static final Integer MAX_COUNT=100;
	
	private int start;
	
	private int end;
	
	public CountTask(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}


	@Override
	protected List<TestDemo> compute() {
		
		List<TestDemo> total = new ArrayList<>();
		int step = end-start;
		//1. 查询TestDemo的个数
		if(end-start<MAX_COUNT) {
			
			return TestDemoJDBC.page(start,end-start);
		}
		//2.如果查询的个数>100则分任务进行
		else {
			// 分成4个任务
			step = (0+end+start)/4;
			log.info("step:{}",step);
			ArrayList<CountTask> subTasks = new ArrayList<>();
			int pos=0;
			for(int i=0;i<4;i++) {
				// 分解成分页查询
				int lastOne = pos+step;
				if(lastOne>end) 
					lastOne=end;
				    log.info("lastOne:{}",lastOne);
				CountTask subTask = new CountTask(pos, lastOne);
				pos+=step;
				log.info("pos:{}",pos);
				subTasks.add(subTask);
				subTask.fork();
				
			}
			for(CountTask t:subTasks) {
				total.addAll(t.join());
			}
			
		}
		return total;
	}
	
	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		CountTask task = new CountTask(0, 122);
		ForkJoinTask<List<TestDemo>> result = forkJoinPool.submit(task);
		try {
			System.out.println(result.get());
			log.info("集合大小:{}",result.get().size());
			int a =0;
			for(TestDemo t:result.get()) {
				System.out.println(t+"---->"+a);
				a++;
			}
			System.out.println(a);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

}
