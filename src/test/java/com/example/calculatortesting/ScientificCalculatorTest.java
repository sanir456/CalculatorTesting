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
    public void timeConverterTruePositive(){
        //[1,2,4]
        Map<String,Object> payload0 = new HashMap();
        payload0.put("unit1",(Object) new String("second"));
        payload0.put("unit2",(Object) new String("kelvin"));
        payload0.put("input1",(Object) new String("123"));
        assertEquals("testpath0",new ResponseEntity(HttpStatus.BAD_REQUEST),calculator.unitConverterTime(payload0));

        //[1,2,3,5,6,9,12,13]
        Map<String,Object> payload1 = new HashMap();
        payload1.put("unit1",(Object) new String("second"));
        payload1.put("unit2",(Object) new String("hour"));
        payload1.put("input1",(Object) new String("3600"));
        double output1 = 1.0;
        assertEquals("testpath1", ResponseEntity.ok(output1),calculator.unitConverterTime(payload1));

        //[1,2,3,5,7,9,10,13]
        Map<String,Object> payload2 = new HashMap();
        payload2.put("unit1",(Object) new String("minute"));
        payload2.put("unit2",(Object) new String("second"));
        payload2.put("input1",(Object) new String("6"));
        double output2 = 360.0;
        assertEquals("testpath1", ResponseEntity.ok(output2),calculator.unitConverterTime(payload2));

        //[1,2,3,5,6,9,11,13]
        Map<String,Object> payload3 = new HashMap();
        payload3.put("unit1",(Object) new String("second"));
        payload3.put("unit2",(Object) new String("minute"));
        payload3.put("input1",(Object) new String("3600"));
        double output3 = 60.0;
        assertEquals("testpath1", ResponseEntity.ok(output3),calculator.unitConverterTime(payload3));

        //[1,2,3,5,6,9,10,13]
        Map<String,Object> payload4 = new HashMap();
        payload4.put("unit1",(Object) new String("second"));
        payload4.put("unit2",(Object) new String("second"));
        payload4.put("input1",(Object) new String("90"));
        double output4 = 90.0;
        assertEquals("testpath1", ResponseEntity.ok(output4),calculator.unitConverterTime(payload4));

        //[1,2,3,5,7,9,11,13]
        Map<String,Object> payload5 = new HashMap();
        payload5.put("unit1",(Object) new String("minute"));
        payload5.put("unit2",(Object) new String("minute"));
        payload5.put("input1",(Object) new String("6"));
        double output5 = 6.0;
        assertEquals("testpath1", ResponseEntity.ok(output5),calculator.unitConverterTime(payload5));

        //[1,2,3,5,8,9,11,13]
        Map<String,Object> payload6 = new HashMap();
        payload6.put("unit1",(Object) new String("hour"));
        payload6.put("unit2",(Object) new String("minute"));
        payload6.put("input1",(Object) new String("2"));
        double output6 = 120.0;
        assertEquals("testpath1", ResponseEntity.ok(output6),calculator.unitConverterTime(payload6));

        //[1,2,3,5,8,9,12,13]
        Map<String,Object> payload7 = new HashMap();
        payload7.put("unit1",(Object) new String("hour"));
        payload7.put("unit2",(Object) new String("hour"));
        payload7.put("input1",(Object) new String("6"));
        double output7 = 6.0;
        assertEquals("testpath1", ResponseEntity.ok(output7),calculator.unitConverterTime(payload7));

        //[1,2,3,5,8,9,10,13]
        Map<String,Object> payload8 = new HashMap();
        payload8.put("unit1",(Object) new String("hour"));
        payload8.put("unit2",(Object) new String("second"));
        payload8.put("input1",(Object) new String("2"));
        double output8 = 7200.0;
        assertEquals("testpath1", ResponseEntity.ok(output8),calculator.unitConverterTime(payload8));

        //[1,2,3,5,7,9,12,13]
        Map<String,Object> payload9 = new HashMap();
        payload9.put("unit1",(Object) new String("minute"));
        payload9.put("unit2",(Object) new String("hour"));
        payload9.put("input1",(Object) new String("240"));
        double output9 = 4.0;
        assertEquals("testpath1", ResponseEntity.ok(output9),calculator.unitConverterTime(payload9));
    }

    @Test
    public void temperatureConverterTruePositive(){
        //[1,2,4]
        Map<String,Object> payload0 = new HashMap();
        payload0.put("unit1",(Object) new String("second"));
        payload0.put("unit2",(Object) new String("kelvin"));
        payload0.put("input1",(Object) new String("123"));
        assertEquals("testpath0",new ResponseEntity(HttpStatus.BAD_REQUEST),calculator.unitConverterTemperature(payload0));

        //[1,2,3,5,6,9,12,13]
        Map<String,Object> payload1 = new HashMap();
        payload1.put("unit1",(Object) new String("celsius"));
        payload1.put("unit2",(Object) new String("fahrenheit"));
        payload1.put("input1",(Object) new String("37"));
        double output1 = 98.60000000000001;
        assertEquals("testpath1", ResponseEntity.ok(output1),calculator.unitConverterTemperature(payload1));

        //[1,2,3,5,7,9,10,13]
        Map<String,Object> payload2 = new HashMap();
        payload2.put("unit1",(Object) new String("kelvin"));
        payload2.put("unit2",(Object) new String("celsius"));
        payload2.put("input1",(Object) new String("300"));
        double output2 = 26.850000000000023;
        assertEquals("testpath1", ResponseEntity.ok(output2),calculator.unitConverterTemperature(payload2));

        //[1,2,3,5,6,9,11,13]
        Map<String,Object> payload3 = new HashMap();
        payload3.put("unit1",(Object) new String("celsius"));
        payload3.put("unit2",(Object) new String("kelvin"));
        payload3.put("input1",(Object) new String("36"));
        double output3 = 309.15;
        assertEquals("testpath1", ResponseEntity.ok(output3),calculator.unitConverterTemperature(payload3));

        //[1,2,3,5,6,9,10,13]
        Map<String,Object> payload4 = new HashMap();
        payload4.put("unit1",(Object) new String("celsius"));
        payload4.put("unit2",(Object) new String("celsius"));
        payload4.put("input1",(Object) new String("90"));
        double output4 = 90.0;
        assertEquals("testpath1", ResponseEntity.ok(output4),calculator.unitConverterTemperature(payload4));

        //[1,2,3,5,7,9,11,13]
        Map<String,Object> payload5 = new HashMap();
        payload5.put("unit1",(Object) new String("kelvin"));
        payload5.put("unit2",(Object) new String("kelvin"));
        payload5.put("input1",(Object) new String("6"));
        double output5 = 6.0;
        assertEquals("testpath1", ResponseEntity.ok(output5),calculator.unitConverterTemperature(payload5));

        //[1,2,3,5,8,9,11,13]
        Map<String,Object> payload6 = new HashMap();
        payload6.put("unit1",(Object) new String("fahrenheit"));
        payload6.put("unit2",(Object) new String("kelvin"));
        payload6.put("input1",(Object) new String("95"));
        double output6 = 308.15;
        assertEquals("testpath1", ResponseEntity.ok(output6),calculator.unitConverterTemperature(payload6));

        //[1,2,3,5,8,9,12,13]
        Map<String,Object> payload7 = new HashMap();
        payload7.put("unit1",(Object) new String("fahrenheit"));
        payload7.put("unit2",(Object) new String("fahrenheit"));
        payload7.put("input1",(Object) new String("6"));
        double output7 = 6.0;
        assertEquals("testpath1", ResponseEntity.ok(output7),calculator.unitConverterTemperature(payload7));

        //[1,2,3,5,8,9,10,13]
        Map<String,Object> payload8 = new HashMap();
        payload8.put("unit1",(Object) new String("fahrenheit"));
        payload8.put("unit2",(Object) new String("celsius"));
        payload8.put("input1",(Object) new String("95"));
        double output8 = 35.0;
        assertEquals("testpath1", ResponseEntity.ok(output8),calculator.unitConverterTemperature(payload8));

        //[1,2,3,5,7,9,12,13]
        Map<String,Object> payload9 = new HashMap();
        payload9.put("unit1",(Object) new String("kelvin"));
        payload9.put("unit2",(Object) new String("fahrenheit"));
        payload9.put("input1",(Object) new String("300"));
        double output9 = 80.33000000000004;
        assertEquals("testpath1", ResponseEntity.ok(output9),calculator.unitConverterTemperature(payload9));
    }
}
