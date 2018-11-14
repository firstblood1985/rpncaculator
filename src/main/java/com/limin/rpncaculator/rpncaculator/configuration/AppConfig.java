package com.limin.rpncaculator.rpncaculator.configuration;

import com.limin.rpncaculator.rpncaculator.operator.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public UnknownOperator unknownOperator()
    {
        return new UnknownOperator();
    }

    @Bean
    public PlusOperator plusOperator()
    {
        return new PlusOperator();
    }

    @Bean
    public UndoOperator undoOperator()
    {
        return new UndoOperator();
    }

    @Bean
    public MinusOperator minusOperator(){return new MinusOperator();}

    @Bean
    public MutiplyOperator mutiplyOperator() {return  new MutiplyOperator();}

    @Bean
    public SqrtOperator sqrtOperator(){ return new SqrtOperator(); }

    @Bean
    public DivideOperator divideOperator(){ return  new DivideOperator(); }

    @Bean
    public ClearOperator clearOperator() {return new ClearOperator(); }
}
