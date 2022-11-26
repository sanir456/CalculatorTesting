package com.example.calculatortesting;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ScientificCalculatorTest {
    ScientificCalculator calculator = new ScientificCalculator();

    @Test
    public void areaCalculatorTruePositive(){

        //[1,6]
        Map<String,Object> payload0 = new HashMap();
        payload0.put("shape",(Object) new String("polynomial"));
        payload0.put("input1",(Object) new String("2"));
        payload0.put("input2",(Object) new String("5"));
        assertEquals("testpath0",new ResponseEntity(HttpStatus.BAD_REQUEST),calculator.areaCalculator(payload0));

        //[1,3,8,11]
        Map<String,Object> payload1 = new HashMap();
        payload1.put("shape",(Object) new String("square"));
        payload1.put("input1",(Object) new String("4"));
        double output1 = 16.0;
        assertEquals("testpath1",ResponseEntity.ok(output1),calculator.areaCalculator(payload1));

        //[1,2,7,11]
        Map<String,Object> payload2 = new HashMap();
        payload2.put("shape",(Object) new String("circle"));
        payload2.put("input1",(Object) new String("4"));
        double output2 = 50.26548245743669;
        assertEquals("testpath2",ResponseEntity.ok(output2),calculator.areaCalculator(payload2));


        //[1,4,9,11]
        Map<String,Object> payload3 = new HashMap();
        payload3.put("shape",(Object) new String("rectangle"));
        payload3.put("input1",(Object) new String("4"));
        payload3.put("input2",(Object) new String("2"));
        double output3 = 8.0;
        assertEquals("testpath3",ResponseEntity.ok(output3),calculator.areaCalculator(payload3));

        //[1,5,10,11]
        Map<String,Object> payload4 = new HashMap();
        payload4.put("shape",(Object) new String("triangle"));
        payload4.put("input1",(Object) new String("4"));
        payload4.put("input2",(Object) new String("3"));
        double output4 = 6.0;
        assertEquals("testpath4",ResponseEntity.ok(output4),calculator.areaCalculator(payload4));
    }

    @Test
    public void mathCalculatorTruePositive(){
        //[1,6]
        Map<String,Object> payload0 = new HashMap();
        payload0.put("ops",(Object) new String("percentage"));
        payload0.put("input1",(Object) new String("2"));
        payload0.put("input2",(Object) new String("5"));
        assertEquals("testpath0",new ResponseEntity(HttpStatus.BAD_REQUEST),calculator.calculator(payload0));

        //[1,5,10,11,12,15,16,12,15,16,12,15,16,12,13,14]
        Map<String,Object> payload1 = new HashMap();
        payload1.put("ops",(Object) new String("fact"));
        payload1.put("input1",(Object) new String("3"));
        double output1 = 6.0;
        assertEquals("testpath1",ResponseEntity.ok(output1),calculator.calculator(payload1));

        //[1,2,7,14]
        Map<String,Object> payload2 = new HashMap();
        payload2.put("ops",(Object) new String("power"));
        payload2.put("input1",(Object) new String("4"));
        payload2.put("input2",(Object) new String("3"));
        double output2 = 64.0;
        assertEquals("testpath2",ResponseEntity.ok(output2),calculator.calculator(payload2));

        //[1,3,8,14]
        Map<String,Object> payload3 = new HashMap();
        payload3.put("ops",(Object) new String("sqrt"));
        payload3.put("input1",(Object) new String("14"));
        double output3 = 3.7416573867739413;
        assertEquals("testpath3",ResponseEntity.ok(output3),calculator.calculator(payload3));

        //[1,4,9,14]
        Map<String,Object> payload4 = new HashMap();
        payload4.put("ops",(Object) new String("log"));
        payload4.put("input1",(Object) new String("123"));
        double output4 = 2.089905111439398;
        assertEquals("testpath4",ResponseEntity.ok(output4),calculator.calculator(payload4));

        //[1,5,10,11,12,15,16,12,13,14]
        Map<String,Object> payload5 = new HashMap();
        payload5.put("ops",(Object) new String("fact"));
        payload5.put("input1",(Object) new String("1"));
        double output5 = 1.0;
        assertEquals("testpath5",ResponseEntity.ok(output5),calculator.calculator(payload5));

        //[1,5,10,11,12,13,14]
        Map<String,Object> payload6 = new HashMap();
        payload6.put("ops",(Object) new String("fact"));
        payload6.put("input1",(Object) new String("0"));
        double output6 = 1.0;
        assertEquals("testpath6",ResponseEntity.ok(output6),calculator.calculator(payload6));

    }

    @Test
    public void quadraticCalculatorTruePositive(){
        //[1,2,3,5,7,10]
        Map<String,Object> payload0 = new HashMap();
        payload0.put("input1",(Object) new String("1"));
        payload0.put("input2",(Object) new String("2"));
        payload0.put("input3",(Object) new String("1"));
        Map<String,Double> output0 = new HashMap<String,Double>();
        output0.put("root1",-1.0);
        output0.put("root2",-1.0);
        assertEquals("testpath0",ResponseEntity.ok(output0),calculator.quadraticEquation(payload0));

        //[1,2,3,4,6,10]
        Map<String,Object> payload1 = new HashMap();
        payload1.put("input1",(Object) new String("1"));
        payload1.put("input2",(Object) new String("-5"));
        payload1.put("input3",(Object) new String("2"));
        Map<String,Double> output1 = new HashMap<String,Double>();
        output1.put("root1", 4.561552812808831);
        output1.put("root2", 0.4384471871911697);
        assertEquals("testpath1",ResponseEntity.ok(output1),calculator.quadraticEquation(payload1));

        //[1,2,3,5,8,9,10]
        Map<String,Object> payload2 = new HashMap();
        payload2.put("input1",(Object) new String("3"));
        payload2.put("input2",(Object) new String("2"));
        payload2.put("input3",(Object) new String("1"));
        Map<String,Double> output2 = new HashMap<String,Double>();
        output2.put("root1", -0.3333333333333333);
        output2.put("root2", 0.47140452079103173);
        assertEquals("testpath2",ResponseEntity.ok(output2),calculator.quadraticEquation(payload2));
    }

    @Test
    public void temperatureConverterTruePositive(){
        //[1,2,8]
        Map<String,Object> payload0 = new HashMap();
        payload0.put("unit1",(Object) new String("second"));
        payload0.put("unit2",(Object) new String("hour"));
        payload0.put("input1",(Object) new String("123"));
        assertEquals("testpath0",new ResponseEntity(HttpStatus.BAD_REQUEST),calculator.unitConverterTemperature(payload0));

        Map<String,Object> payload0 = new HashMap();
        payload0.put("unit1",(Object) new String("second"));
        payload0.put("unit2",(Object) new String("hour"));
        payload0.put("input1",(Object) new String("123"));
        assertEquals("testpath0",new ResponseEntity(HttpStatus.BAD_REQUEST),calculator.unitConverterTemperature(payload0));

    }
}
