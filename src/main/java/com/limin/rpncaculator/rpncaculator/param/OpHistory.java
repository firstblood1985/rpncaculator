package com.limin.rpncaculator.rpncaculator.param;

import com.limin.rpncaculator.rpncaculator.operate.Operators;
import com.limin.rpncaculator.rpncaculator.operatorparameter.TwoNumberOperatorParameter;

import java.util.ArrayDeque;
import java.util.Deque;

public class OpHistory {
    private Deque<Param> params = new ArrayDeque<>();

    private Operators op;

    public OpHistory(Operators op)
    {
        this.op = op;
    }

    public OpHistory(Operators op, TwoNumberOperatorParameter twoNumberOperatorParameter)
    {
        this.op = op;
        params.push(twoNumberOperatorParameter.getRight());
        params.push(twoNumberOperatorParameter.getLeft());
    }

    public OpHistory(Operators op, Deque<Param> params)
    {
        this.op = op;
        this.params = new ArrayDeque<>(params);
    }

    public OpHistory(Operators op, Param p)
    {
        this.op = op;
        params.push(p);
    }

    public Deque<Param> getParams() {
        return params;
    }

    public Operators getOp(){
        return op;
    }
}
