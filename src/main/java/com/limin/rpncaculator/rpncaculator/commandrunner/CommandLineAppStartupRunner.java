package com.limin.rpncaculator.rpncaculator.commandrunner;

import com.limin.rpncaculator.rpncaculator.operate.Operate;
import com.limin.rpncaculator.rpncaculator.operate.Operators;
import com.limin.rpncaculator.rpncaculator.param.OpHistory;
import com.limin.rpncaculator.rpncaculator.param.Param;
import com.limin.rpncaculator.rpncaculator.validation.Validation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(CommandLineAppStartupRunner.class);

    private BufferedReader br  =  new BufferedReader(new InputStreamReader(System.in));

    private Deque<Param> params = new ArrayDeque<>();

    private Deque<OpHistory> histories = new ArrayDeque<>();

    @Autowired
    private ApplicationContext context;


    @Override
    public void run(String...args) throws Exception {

        while(true) {
            String inputString = br.readLine().trim();
            System.out.println("input is "+inputString);
// need to support accurate position of the char....cannot do simple split
            StringBuilder sb = new StringBuilder();
            boolean start = false;
            boolean end =false;

            if(null !=inputString && inputString.length()>0) {
                int index = 1;

                for (;index <= inputString.length(); index++) {

                   char i = inputString.charAt(index-1);
                    if (i == ' ' || i == '\t') {
                        if(true == start)
                        {
                            end = true;

                        }else {

                        }
                    }else{
                        start = true;
                        sb.append(i);
                        if(index == inputString.length())
                        {
                            end = true;
                        }
                    }

                    if(start && end) {

                        String input = sb.toString();
                        if (Param.isParam(input)) {
                            params.push(new Param(input));

                        }else {
                            //presumablely i cannot be both param and operator
                            Operators operator = Operators.isOperator(input);
                            if (Operators.UNKNOW_OPERATOR != operator) {
                                Operate op = (Operate) context.getBean(operator.getHandlerName());
                                Validation v = op.validate(params);
                                if (Validation.SUCCESS == v) {
                                    params = op.operate(params, histories);
                                } else {
                                    Validation.printMessage(v, operator.getSymbol(), index-1);
                                    System.out.println("due to validation error, discarded rest and start new input");
                                    break;
                                }
                            } else {
                                System.out.println("unrecognized value: " + input + ", discarded rest and start new input");
                                break;
                            }
                        }
                        start =false;
                        end = false;
                        sb = new StringBuilder();

                    }

                }
                Iterator it = params.descendingIterator();
                StringBuilder reverseParam = new StringBuilder();
                while(it.hasNext())
                {
                    reverseParam.append(it.next()+" ");
                }
                System.out.println("Stack: "+ reverseParam);
            }
        }
    }
}
