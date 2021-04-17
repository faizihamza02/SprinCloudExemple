package org.sid.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RefreshScope
public class CompanyRestService {
   @Value("${xParam}")
   private int xParam;
    @Value("${yParam}")
   private int yParam;
    @Value("${me}")
   private String me;

    @GetMapping("/myConfig")
   public Map<String,Object> myConfig(){
        Map<String,Object> m=new HashMap<>();
        m.put("xParam",xParam);
        m.put("yParam",yParam);
        m.put("me",me);
        m.put("threadName",Thread.currentThread().getName());
        return m;
   }

}

