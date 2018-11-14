package com.limin.rpncaculator.rpncaculator.operator;

import com.limin.rpncaculator.rpncaculator.operate.Operators;
import com.limin.rpncaculator.rpncaculator.param.OpHistory;
import com.limin.rpncaculator.rpncaculator.param.Param;
import com.limin.rpncaculator.rpncaculator.validation.Validation;

import java.util.ArrayDeque;
import java.util.Deque;

public class ClearOperator extends ZeroNumberOperator {

    private final Operators clear = Operators.CLEAR;
    @Override
    public Deque<Param>  operate(Deque<Param> params, Deque<OpHistory> histories) {

        OpHistory oph = new OpHistory(clear,params);
        params.clear();
        histories.push(oph);
        return  params;
    }

    @Override
    public Validation validate(Deque<Param> params) {
        return Validation.SUCCESS;
    }

    @Override
    public Deque<Param>undo(Deque<Param> params, OpHistory oph) {

        params = new ArrayDeque<>(oph.getParams());

        return params;
    }
}
