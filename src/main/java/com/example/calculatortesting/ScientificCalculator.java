package com.example.calculatortesting;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ScientificCalculator {

    @RequestMapping(value = "/calculator",method = RequestMethod.GET)
    public double power(@RequestBody Map<String,Object> payload){
        String ops = (String) payload.get("ops");
        double res = 0;
        double input1;
        double input2;
        switch (ops){
            case "power":input1 = Double.parseDouble((String) payload.get("input1"));
                         input2 = Double.parseDouble((String) payload.get("input2"));
                         res = Math.pow(input1,input2);
                         break;

            case "sqrt":input1 = Double.parseDouble((String) payload.get("input1"));
                        res = Math.sqrt(input1);
                        break;

            case "fact":input1 = Double.parseDouble((String) payload.get("input1"));
                        res=1.0;
                        for(double i=1;i<=input1;i++)
                            res = res*i;
                        break;

            case "log":input1 = Double.parseDouble((String) payload.get("input1"));
                       res = Math.log10(input1);
                       break;
        }
        return res  ;
    }

}
