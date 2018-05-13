package com.test;

import com.service.QuartzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: XBlue
 * @Date: Create in 2018/5/139:21
 * @Description:
 * @Modified By:
 */
@Controller
public class TestController {
    @Autowired
    private QuartzService quartzService;

    @RequestMapping("/test")
    @ResponseBody
    public String test()
    {
        return "abc";
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add()
    {
        quartzService.addJob("jobName1","jobGroupName"
        ,"triggerName1","triggerGroupName1",MyJob.class,"0/2 * * * * ?");
        return "abc";
    }

    @RequestMapping("delete")
    @ResponseBody
    public String remove(){
        quartzService.removeJob("jobName1","jobGroupName",
                "triggerName1","triggerGroupName1");
        return "abc";
    }

    @RequestMapping("stop")
    @ResponseBody
    public String stop(){
        quartzService.pauseJob("jobName1","jobGroupName");
        return "abc";
    }

    @RequestMapping("restart")
    @ResponseBody
    public String restart(){
        quartzService.resumeJob("jobName1","jobGroupName");
        return "abc";
    }

    @RequestMapping("modify")
    @ResponseBody
    public String modify(){
        quartzService.modifyJobTime("jobName1","jobGroupName",
                "triggerName1","triggerGroupName1","jobName2","jobGroupName",
                "triggerName2","triggerGroupName1","0/5 * * * * ?");
        return "abc";
    }

    @RequestMapping("delete2")
    @ResponseBody
    public String delete2(){
        quartzService.removeJob("jobName2","jobGroupName",
                "triggerName2","triggerGroupName1");
        return "abc";
    }
}
