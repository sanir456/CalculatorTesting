package com.example.calculatortesting;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class ScientificCalculator {

    @RequestMapping(value = "/calculator", method = RequestMethod.GET)
    public  ResponseEntity<?> calculator(@RequestBody Map<String, Object> payload) {
        String ops = (String) payload.get("ops");
        double res = 0;
        double input1;
        double input2;

        switch (ops) {
            case "power":
                input1 = Double.parseDouble((String) payload.get("input1"));
                input2 = Double.parseDouble((String) payload.get("input2"));
                res = Math.pow(input1, input2);
                break;

            case "sqrt":
                input1 = Double.parseDouble((String) payload.get("input1"));
                res = Math.sqrt(input1);
                break;

            case "fact":
                input1 = Double.parseDouble((String) payload.get("input1"));
                res = 1.0;
                for (double i = 1; i <= input1; i++)
                    res = res * i;
                break;

            case "log":
                input1 = Double.parseDouble((String) payload.get("input1"));
                res = Math.log10(input1);
                break;

            default:
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(res);
    }


    @RequestMapping(value = "/areacalculator", method = RequestMethod.GET)
    public ResponseEntity<?> areaCalculator(@RequestBody Map<String, Object> payload) {
        String shape = (String) payload.get("shape");
        double res = 0;
        double input1;
        double input2;

        switch (shape) {
            case "circle":
                input1 = Double.parseDouble((String) payload.get("input1"));
                res = Math.PI * input1 * input1;
                break;

            case "square":
                input1 = Double.parseDouble((String) payload.get("input1"));
                res = input1 * input1;
                break;

            case "rectangle":
                input1 = Double.parseDouble((String) payload.get("input1"));
                input2 = Double.parseDouble((String) payload.get("input2"));
                res = input1 * input2;
                break;

            case "triabgle":
                input1 = Double.parseDouble((String) payload.get("input1"));
                input2 = Double.parseDouble((String) payload.get("input2"));
                res = 0.5 * input1 * input2;
                break;

            default:
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(res);

    }


    @RequestMapping(value = "/unitConverterLength", method = RequestMethod.GET)
    public ResponseEntity<?> unitConverterlength(@RequestBody Map<String, Object> payload) {
        Set<String> setlength = new HashSet<String>(Arrays.asList("millimeter", "centimeter", "meter", "kilometer", "Inch", "Foot", "Yard", "mile"));
        String unit1 = (String) payload.get("unit1");
        String unit2 = (String) payload.get("unit2");
        double res = 0;
        double input1 = Double.parseDouble((String) payload.get("input1"));

        if (setlength.contains(unit1) && setlength.contains(unit2)) {
            double meter = 0.0;
            switch (unit1) {
                case "millimeter":
                    meter = input1 / 1000;
                    break;

                case "centimeter":
                    meter = input1 / 100;
                    break;

                case "meter":
                    meter = input1;
                    break;

                case "kilomete":
                    meter = input1 * 1000;
                    break;

                case "inch":
                    meter = input1 / 39.3701;
                    break;

                case "foot":
                    meter = input1 / 3.28084;
                    break;

                case "yard":
                    meter = input1 / 1.09361;
                    break;

                case "mile":
                    meter = input1 / 0.000621371;
                    break;

                default:
                    return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }

            switch (unit2) {
                case "millimeter":
                    res = meter * 1000;
                    break;

                case "centimeter":
                    res = meter * 100;
                    break;

                case "meter":
                    res = meter;
                    break;

                case "kilomete":
                    res = meter / 1000;
                    break;

                case "inch":
                    res = meter * 39.3701;
                    break;

                case "foot":
                    res = meter * 3.28084;
                    break;

                case "yard":
                    res = meter * 1.09361;
                    break;

                case "mile":
                    res = meter * 0.000621371;
                    break;

                default:
                    return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }

        }
        else
        {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(res);
    }

    @RequestMapping(value = "/unitConverterWeight", method = RequestMethod.GET)
    public ResponseEntity<?> unitConverterWeight(@RequestBody Map<String, Object> payload) {
        Set<String> setWeight = new HashSet<String>(Arrays.asList("milli", "centi", "gram", "kilo", "metrictonnes", "pounds", "ounces", ""));
        String unit1 = (String) payload.get("unit1");
        String unit2 = (String) payload.get("unit2");
        double res = 0;
        double input1 = Double.parseDouble((String) payload.get("input1"));
        if (setWeight.contains(unit1) && setWeight.contains(unit2)) {
            double kilo = 0.0;

            switch (unit1) {
                case "milli":
                    kilo = input1 / 1000000;
                    break;

                case "centi":
                    kilo = input1 / 100000;
                    break;

                case "gram":
                    kilo = input1 / 1000;
                    break;

                case "kilo":
                    kilo = input1;
                    break;

                case "matrictonnes":
                    kilo = input1 * 1000;
                    break;

                case "pounds":
                    kilo = input1 / 2.20462;
                    break;

                case "ounces":
                    kilo = input1 / 35.274;
                    break;

                default:
                    return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }

            switch (unit2) {
                case "milli":
                    res = kilo * 1000000;
                    break;

                case "centi":
                    res = kilo * 100000;
                    break;

                case "gram":
                    res = kilo * 1000;
                    break;

                case "kilo":
                    res = kilo;
                    break;

                case "matrictonnes":
                    res = kilo / 1000;
                    break;

                case "pounds":
                    res = kilo * 2.20462;
                    break;

                case "ounces":
                    res = kilo / 35.274;
                    break;

                default:
                    return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
        }
        else
        {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(res);
    }

    @RequestMapping(value = "/unitConverterArea", method = RequestMethod.GET)
    public ResponseEntity<?> unitConverterArea(@RequestBody Map<String, Object> payload) {
        Set<String> setArea = new HashSet<String>(Arrays.asList("millimeter", "centimeter", "meter", "kilometer", "acre", "hectare"));
        String unit1 = (String) payload.get("unit1");
        String unit2 = (String) payload.get("unit2");
        double res = 0;
        double input1 = Double.parseDouble((String) payload.get("input1"));

        if (setArea.contains(unit1) && setArea.contains(unit2)) {
            double meter = 0.0;
            switch (unit1) {
                case "millimeter":
                    meter = input1 / 1000000;
                    break;

                case "centimeter":
                    meter = input1 / 10000;
                    break;

                case "meter":
                    meter = input1;
                    break;

                case "kilomete":
                    meter = input1 * 1000000;
                    break;

                case "acre":
                    meter = input1 * 4046.86;
                    break;

                case "hectare":
                    meter = input1 * 10000;
                    break;

                default:
                    return new ResponseEntity(HttpStatus.BAD_REQUEST);

            }

            switch (unit2) {
                case "millimeter":
                    res = meter * 1000000;
                    break;

                case "centimeter":
                    res = meter * 10000;
                    break;

                case "meter":
                    res = meter;
                    break;

                case "kilomete":
                    res = meter / 1000000;
                    break;

                case "acre":
                    res = meter / 4046.86;
                    break;

                case "hectare":
                    res = meter / 10000;
                    break;

                default:
                    return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
        }
        else
        {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(res);
    }

    @RequestMapping(value = "/unitConverterTemperature", method = RequestMethod.GET)
    public ResponseEntity<?> unitConverterTemperature(@RequestBody Map<String, Object> payload) {
        Set<String> setTemperature = new HashSet<String>(Arrays.asList("kelvin","celsius","fahrenheit"));
        String unit1 = (String) payload.get("unit1");
        String unit2 = (String) payload.get("unit2");
        double res = 0;
        double input1 = Double.parseDouble((String) payload.get("input1"));

        if (setTemperature.contains(unit1) && setTemperature.contains(unit2)) {
            double celsius = 0.0;
            switch (unit1){
                case "celsius":
                    celsius = input1;
                    break;

                case "kelvin":
                    celsius = input1 - 273.15;
                    break;

                case "fahrenheit":
                    celsius = (input1-32.0)*(5.0/9.0);
                    break;

                default:
                    return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }

            switch (unit2){
                case "celsius":
                    res = celsius;
                    break;

                case "kelvin":
                    res = celsius + 273.15;
                    break;

                case "fahrenheit":
                    res = celsius*(9.0/5.0)+32.0;
                    break;

                default:
                    return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
        }
        else
        {
             return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(res);
    }

    @RequestMapping(value = "/unitConverterTime", method = RequestMethod.GET)
    public ResponseEntity<?> unitConverterTime(@RequestBody Map<String, Object> payload) {
        Set<String> setTime = new HashSet<String>(Arrays.asList("second","minutes","hour"));
        String unit1 = (String) payload.get("unit1");
        String unit2 = (String) payload.get("unit2");
        double res = 0;
        double input1 = Double.parseDouble((String) payload.get("input1"));

        if(setTime.contains(unit1) && setTime.contains(unit2))
        {
            double second = 0.0;
            switch (unit1){
                case "second":
                    second = input1;
                    break;

                case "minute":
                    second = input1 * 60;
                    break;

                case "hour":
                    second = input1 * 3600;
                    break;

                default:
                    return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }


            switch (unit2){
                case "second":
                    res = second;
                    break;

                case "minute":
                    res = second / 60;
                    break;

                case "hour":
                    res = second / 3600;
                    break;

                default:
                    return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
        }
        else
        {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(res);
    }
    @RequestMapping(value = "/quadraticEquation", method = RequestMethod.GET)
    public ResponseEntity<?> quadraticEquation(@RequestBody Map<String, Object> payload) {
        double a = Double.parseDouble((String) payload.get("input1"));
        double b = Double.parseDouble((String) payload.get("input2"));
        double c = Double.parseDouble((String) payload.get("input3"));

        double determinant = b * b - 4 * a * c;
        double root1, root2;

        if(determinant > 0)
        {
            root1 = (-b + Math.sqrt(determinant)) / (2 * a);
            root2 = (-b - Math.sqrt(determinant)) / (2 * a);
        }
        else if (determinant == 0) {
            root1 = root2 = -b / (2 * a);
        }
        else {
            root1 = -b / (2 * a);
            root2 = Math.sqrt(-determinant) / (2 * a);
        }
        Map<String,Double> res = new HashMap<String,Double>();
        res.put("root1",root1);
        res.put("root2",root2);

        return ResponseEntity.ok(res);
    }
}
