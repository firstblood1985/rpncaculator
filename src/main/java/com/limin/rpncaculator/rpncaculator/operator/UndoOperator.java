package com.limin.rpncaculator.rpncaculator.operator;

import com.limin.rpncaculator.rpncaculator.operate.Operate;
import com.limin.rpncaculator.rpncaculator.param.OpHistory;
import com.limin.rpncaculator.rpncaculator.param.Param;
import com.limin.rpncaculator.rpncaculator.validation.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.Deque;

public class UndoOperator extends ZeroNumberOperator {

    @Autowired
    private ApplicationContext context;


    @Override
    public Deque<Param> operate(Deque<Param> params, Deque<OpHistory> histories) {
       if(histories.size()>0) {
           OpHistory oph = histories.pop();

           Operate op = (Operate) context.getBean(oph.getOp().getHandlerName());

           return op.undo(params,oph);
       }else{
           if(params.size()>0)
           {
               params.pop();
           }else {
               System.out.println("there is nothing to undo");
           }
           return params;
       }
    }

    @Override
    public Validation validate(Deque<Param> params) {
        return Validation.SUCCESS;
    }

    @Override
    public Deque<Param> undo(Deque<Param> params, OpHistory oph) {
        return null;
    }
}
