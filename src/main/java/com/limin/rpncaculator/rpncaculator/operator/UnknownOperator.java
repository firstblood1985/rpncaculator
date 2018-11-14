package com.limin.rpncaculator.rpncaculator.operator;

import com.limin.rpncaculator.rpncaculator.param.OpHistory;
import com.limin.rpncaculator.rpncaculator.param.Param;
import com.limin.rpncaculator.rpncaculator.validation.Validation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Deque;

public class UnknownOperator extends ZeroNumberOperator {

    private static final Logger logger = LoggerFactory.getLogger(UnknownOperator.class);


    @Override
    public Deque<Param> operate(Deque<Param> params, Deque<OpHistory> histories) {
            return null;
    }

    @Override
    public Validation validate(Deque<Param> params) {
        return Validation.FAIL;
    }

    @Override
    public Deque<Param> undo(Deque<Param> params,OpHistory oph) {
        return null;
    }
}
