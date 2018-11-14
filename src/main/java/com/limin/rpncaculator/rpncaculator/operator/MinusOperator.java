package com.limin.rpncaculator.rpncaculator.operator;

import com.limin.rpncaculator.rpncaculator.operate.Operators;
import com.limin.rpncaculator.rpncaculator.operatorparameter.TwoNumberOperatorParameter;
import com.limin.rpncaculator.rpncaculator.param.OpHistory;
import com.limin.rpncaculator.rpncaculator.param.Param;
import com.limin.rpncaculator.rpncaculator.validation.Validation;

import java.util.Deque;

public class MinusOperator extends TwoNumberOperator  {
    private final Operators minus = Operators.MINUS;

    @Override
    public Deque<Param> operate(Deque<Param> params, Deque<OpHistory> histories) {
        TwoNumberOperatorParameter param = retrieveParams(minus,params,histories);

        Param result = new Param(param.getLeft().toValue() - param.getRight().toValue());

        push(params, result);

        return params;
    }

    @Override
    public Validation validate(Deque<Param> params) {
        return validateTwoParam(minus,params);
    }

    @Override
    public Deque<Param> undo(Deque<Param> params, OpHistory oph) {
        return  undoTwoNumber(params,oph);
    }
}
