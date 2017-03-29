package com.cx.timer;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configurable
@EnableScheduling
public class TimerTest {

	 @Scheduled(cron = "0/2 * * * * ?") // 每2秒执行一次
   public void scheduler() {
       System.out.println(">>>>>>>>> SchedulingConfig.scheduler()");
   }
}
