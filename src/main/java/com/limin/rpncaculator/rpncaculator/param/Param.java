package com.limin.rpncaculator.rpncaculator.param;

import java.text.DecimalFormat;
import java.text.ParseException;

public class Param {

    private final String literal;

    public Param(String literal)
    {
        this.literal = literal;
    }

    public Param(double value)
    {

        //this.literal = String.valueOf(value);
        this.literal = String.format("%.15f",value);
    }

    public double toValue()
    {

        DecimalFormat df = new DecimalFormat("0.000000000000000");

        //(Float.valueOf(literal)).floatValue();
        try
        {
            double d =  df.parse(literal).doubleValue();
            return d;
        }catch (ParseException e) {
            System.out.println(literal + " is not a valid number.");
        }
        return 0;
    }

    @Override
    public String toString() {

       String s = String.format("%.10f", (Double.valueOf(literal)).doubleValue());
       return s = s.indexOf(".") < 0 ? s : s.replaceAll("0*$", "").replaceAll("\\.$", "");
    }

    public static boolean isParam(String p)
    {
    //    return true;
        try
        {
            double d = Double.parseDouble(p);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }


}
