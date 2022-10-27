package com.lanyuan.springTestDemo.aspect;

import com.lanyuan.springTestDemo.entity.User;
import com.lanyuan.springTestDemo.mapper.myMapper.MyMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Aspect
@Component
public class ControllerAspect {

    @Resource
    private MyMapper myMapper;

    @AfterReturning(returning="proceed"
            , value="execution(* com.lanyuan.springTestDemo.controller.UserController.register(..))")
    public void giveRoleDefault(Object proceed)throws Throwable{

        if (proceed!=null){
            User user=(User)proceed;
            if (user.getId()!=null){
                myMapper.insertRoleToUserDefault(user.getId());
            }
        }


    }
}
