package com.limin.rpncaculator.rpncaculator.validation;

public enum Validation {

    SUCCESS("validation success"),
    FAIL("validation fail"),
    INSUFFICIENT_PARAMS("operator %s (position: %d): insufficient parameters"),
    DIVIDE_BY_ZEOR("cannot divide by zero"),
    SQRT_NEGATIVE("sqrt cannot operate on negative number");


    private String message;
    private  Validation(String message)
    {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static void printMessage(Validation v,String op, int pos){
        String m = v.getMessage();
        System.out.println(String.format(m,op,pos));
    }
}
