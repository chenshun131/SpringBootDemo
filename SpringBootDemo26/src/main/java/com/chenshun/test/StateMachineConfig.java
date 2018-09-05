package com.chenshun.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.transition.Transition;

import java.util.EnumSet;

@Slf4j
@Configuration
@EnableStateMachine // 启用Spring StateMachine状态机功能
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<States, Events> {

    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states) throws Exception {
        // 初始化当前状态机拥有哪些状态，其中
        // initial(States.UNPAID) 定义了初始状态为UNPAID
        // states(EnumSet.allOf(States.class)) 则指定使用上一步中定义的所有状态作为该状态机的状态定义
        states.withStates().initial(States.UNPAID).states(EnumSet.allOf(States.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions) throws Exception {
        // 初始化当前状态机有哪些状态迁移动作，都有来源状态source，目标状态target以及触发事件event
        transitions
                .withExternal()
                .source(States.UNPAID) // 指定状态来源
                .target(States.WAITING_FOR_RECEIVE) // 指定目标
                .event(Events.PAY) // 指定触发事件
                .and()
                .withExternal()
                .source(States.WAITING_FOR_RECEIVE).target(States.DONE)
                .event(Events.RECEIVE);
    }

    @Override
    public void configure(StateMachineConfigurationConfigurer<States, Events> config) throws Exception {
        // 为当前的状态机指定了状态监听器，其中 listener() 则是调用了下一个内容创建的监听器实例，用来处理各个各个发生的状态迁移事件
        config.withConfiguration().listener(listener());
    }

    @Bean
    public StateMachineListener<States, Events> listener() {
        // 创建 StateMachineListener 状态监听器的实例，在该实例中会定义具体的状态迁移处理逻辑，上面的实现中只是做了一些输出，
        // 实际业务场景会会有更负责的逻辑，所以通常情况下，可以将该实例的定义放到独立的类定义中，并用注入的方式加载进来
        return new StateMachineListenerAdapter<States, Events>() {
            @Override
            public void transition(Transition<States, Events> transition) {
                if (transition.getTarget().getId() == States.UNPAID) {
                    log.info("订单创建，待支付");
                    return;
                }

                if (transition.getSource().getId() == States.UNPAID && transition.getTarget().getId() == States.WAITING_FOR_RECEIVE) {
                    log.info("用户完成支付，待收货");
                    return;
                }

                if (transition.getSource().getId() == States.WAITING_FOR_RECEIVE && transition.getTarget().getId() == States.DONE) {
                    log.info("用户已收货，订单完成");
                    return;
                }
            }
        };
    }

}
