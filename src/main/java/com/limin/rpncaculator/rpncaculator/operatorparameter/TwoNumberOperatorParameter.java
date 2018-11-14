package com.limin.rpncaculator.rpncaculator.operatorparameter;

import com.limin.rpncaculator.rpncaculator.param.Param;

import java.util.Deque;

public class TwoNumberOperatorParameter {

    private Param left;
    private Param right;

    public Param getLeft() {
        return left;
    }

    public void setLeft(Param left) {
        this.left = left;
    }

    public Param getRight() {
        return right;
    }

    public void setRight(Param right) {
        this.right = right;
    }

    public TwoNumberOperatorParameter(Param left, Param right)
    {
        this.left = left;
        this.right = right;
    }

    public TwoNumberOperatorParameter(Deque<Param> params)
    {
        this.right = params.pop();
        this.left = params.pop();
    }
}
