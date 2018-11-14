package com.limin.rpncaculator.rpncaculator.operate;

import com.limin.rpncaculator.rpncaculator.param.OpHistory;
import com.limin.rpncaculator.rpncaculator.param.Param;
import com.limin.rpncaculator.rpncaculator.validation.Validation;

import java.util.Deque;

public interface Operate {

    public Deque<Param> operate(Deque<Param> params, Deque<OpHistory> histories);
    public Validation validate(Deque<Param> params);
    public Deque<Param> undo(Deque<Param> params, OpHistory oph);


}
