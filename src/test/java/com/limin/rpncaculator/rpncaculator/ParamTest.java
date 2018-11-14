package com.limin.rpncaculator.rpncaculator;

import com.limin.rpncaculator.rpncaculator.param.Param;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParamTest {

    @Test
    public void ParamInt()
    {
        Param a = new Param("1");
        Assert.assertEquals(a.toValue(),1,0);

    }
}
