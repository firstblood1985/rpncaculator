package com.limin.rpncaculator.rpncaculator.param;

public class Param {

    private final String literal;

    public Param(String literal)
    {
        this.literal = literal;
    }

    public Param(float value)
    {

        this.literal = String.valueOf(value);
    }

    public float toValue()
    {
        return (Float.valueOf(literal)).floatValue();
    }

    @Override
    public String toString() {

        //check if literal to int is possible without losing accuracy
        return literal;
    }

    public static boolean isParam(String p)
    {
    //    return true;
        try
        {
           // double d = Double.parseDouble(p);
            float d = Float.parseFloat(p);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }


}
