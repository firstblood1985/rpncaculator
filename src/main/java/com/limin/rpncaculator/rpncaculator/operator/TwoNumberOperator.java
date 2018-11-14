package com.limin.rpncaculator.rpncaculator.operator;

import com.limin.rpncaculator.rpncaculator.operate.Operate;
import com.limin.rpncaculator.rpncaculator.operate.Operators;
import com.limin.rpncaculator.rpncaculator.operatorparameter.TwoNumberOperatorParameter;
import com.limin.rpncaculator.rpncaculator.param.OpHistory;
import com.limin.rpncaculator.rpncaculator.param.Param;
import com.limin.rpncaculator.rpncaculator.validation.Validation;

import java.util.Deque;

public abstract class TwoNumberOperator implements Operate {

    public TwoNumberOperatorParameter retrieveParams(Operators op, Deque<Param> params, Deque<OpHistory> histories) {


        TwoNumberOperatorParameter twoNumberOperatorParameter = new TwoNumberOperatorParameter(params);
        OpHistory opHistory = new OpHistory(op, twoNumberOperatorParameter);
        histories.push(opHistory);

        return twoNumberOperatorParameter;
    }

    public Validation validateTwoParam(Operators op, Deque<Param> params) {
        //at least there are two params in stack
        if (params.size() < 2) {
            return Validation.INSUFFICIENT_PARAMS;
        }
        return Validation.SUCCESS;

    }

    public Deque<Param> undoTwoNumber(Deque<Param> params,OpHistory oph)
    {
        Deque<Param> origin = oph.getParams();
        params.pop();
        params.push(origin.pop());
        params.push(origin.pop());

        return params;
    }


    public void push(Deque<Param> params,Param p) {

        params.push(p);

    }
}
