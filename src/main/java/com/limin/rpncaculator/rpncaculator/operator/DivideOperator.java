package com.limin.rpncaculator.rpncaculator.operator;

import com.limin.rpncaculator.rpncaculator.operate.Operators;
import com.limin.rpncaculator.rpncaculator.operatorparameter.TwoNumberOperatorParameter;
import com.limin.rpncaculator.rpncaculator.param.OpHistory;
import com.limin.rpncaculator.rpncaculator.param.Param;
import com.limin.rpncaculator.rpncaculator.validation.Validation;

import java.util.Deque;

public class DivideOperator extends TwoNumberOperator {

    private final Operators divide = Operators.DIVIDE;

    @Override
    public Deque<Param>  operate(Deque<Param> params, Deque<OpHistory> histories) {

        TwoNumberOperatorParameter param = retrieveParams(divide,params,histories);

        Param result = new Param(param.getLeft().toValue() / param.getRight().toValue());

        push(params, result);

        return params;
    }

    @Override
    public Validation validate(Deque<Param> params) {
        Validation v = validateTwoParam(divide,params);

        if(Validation.SUCCESS ==v )
        {
            Param p = params.peek();
            if(p.toValue() == 0)
            {
                return Validation.DIVIDE_BY_ZEOR;
            }

        }else{
           return v;
        }
        return  v;
    }

    @Override
    public Deque<Param> undo(Deque<Param> params, OpHistory oph) {
        return  undoTwoNumber(params,oph);
    }
}
