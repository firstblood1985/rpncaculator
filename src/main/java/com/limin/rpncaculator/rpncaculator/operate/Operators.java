package com.limin.rpncaculator.rpncaculator.operate;
public enum  Operators {

    UNKNOW_OPERATOR(" ","unknownOperator"),
    MINUS("-","minusOperator"),
    PLUS("+","plusOperator"),
    MULTIPLY("*","mutiplyOperator"),
    DIVIDE("/","divideOperator"),
    SQRT("sqrt","sqrtOperator"),
    CLEAR("clear","clearOperator"),
    UNDO("undo","undoOperator");

    private String sym;

    private String handlerName;

    Operators(String sym, String handlerName)
    {
        this.handlerName = handlerName;
        this.sym = sym;

    }

    public String getHandlerName() {
        return handlerName;
    }


    public String getSymbol(){
        return sym;
    }

    public static Operators isOperator(String o)
    {
        //if is Operator, then return Operator, otherwise return unknown
        for(Operators op :Operators.values())
        {
            if(op.getSymbol().equalsIgnoreCase(o))
            {
                return op;
            }
        }
        return Operators.UNKNOW_OPERATOR;

    }
}
