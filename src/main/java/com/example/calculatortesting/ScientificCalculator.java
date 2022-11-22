package com.example.calculatortesting;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RestController
public class ScientificCalculator {

    @RequestMapping(value = "/calculator", method = RequestMethod.GET)
    public double calculator(@RequestBody Map<String, Object> payload) {
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
        }

        return res;
    }


    @RequestMapping(value = "/areacalculator", method = RequestMethod.GET)
    public double areaCalculator(@RequestBody Map<String, Object> payload) {
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
        }

        return res;

    }


    @RequestMapping(value = "/unitConverterLength", method = RequestMethod.GET)
    public double unitConverterlength(@RequestBody Map<String, Object> payload) {
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
            }

        }

        return res;
    }

    @RequestMapping(value = "/unitConverterWeight", method = RequestMethod.GET)
    public double unitConverterWeight(@RequestBody Map<String, Object> payload) {
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
            }
        }
        return res;
    }

    @RequestMapping(value = "/unitConverterArea", method = RequestMethod.GET)
    public double unitConverterArea(@RequestBody Map<String, Object> payload) {
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

            }

        }

        return res;
    }
}
