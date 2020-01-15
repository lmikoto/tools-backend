package io.github.lmikoto.tools.controller;

import com.google.common.collect.Lists;
import io.github.lmikoto.tools.request.NextCronExecTimeRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/cron")
@Slf4j
public class CronController {

    @GetMapping("/next")
    public List<Date> nextCronExecTime(@ModelAttribute NextCronExecTimeRequest request){
        try {
            List<Date> list = Lists.newArrayList();
            CronTrigger trigger = new CronTrigger(request.getCron());
            SimpleTriggerContext triggerContext = new SimpleTriggerContext();
            Date date = new Date();
            for(int i=0;i<request.getNum();i++){
                triggerContext.update(null, null, date);
                Date nextFireAt = trigger.nextExecutionTime(triggerContext);
                list.add(nextFireAt);
                date = nextFireAt;
            }
            return list;
        }catch (Exception e){
            return Collections.emptyList();
        }

    }
}
