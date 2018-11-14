package com.limin.rpncaculator.rpncaculator.operator;

import com.limin.rpncaculator.rpncaculator.operate.Operators;
import com.limin.rpncaculator.rpncaculator.param.OpHistory;
import com.limin.rpncaculator.rpncaculator.param.Param;
import com.limin.rpncaculator.rpncaculator.validation.Validation;

import java.util.Deque;

public class SqrtOperator extends OneNumberOperator {

    private  final Operators sqrt = Operators.SQRT;

    @Override
    public Deque<Param> operate(Deque<Param> params, Deque<OpHistory> histories) {

        Param p = retrieveParam(sqrt,params,histories);

        Param result = new Param((float) Math.sqrt((double)p.toValue()));

        push(params,result);

        return params;

    }

    @Override
    public Validation validate(Deque<Param> params) {

       // return
        Validation v = validateOneParam(sqrt,params);
        if(Validation.SUCCESS == v)
        {
            Param p = params.peek();
            if(p.toValue() < 0)
            {
                return Validation.SQRT_NEGATIVE;
            }else{
                return v;
            }
        }
        return v;
    }

    @Override
    public Deque<Param> undo(Deque<Param> params, OpHistory oph) {
       return undoOneNumber(params,oph);
    }
}
