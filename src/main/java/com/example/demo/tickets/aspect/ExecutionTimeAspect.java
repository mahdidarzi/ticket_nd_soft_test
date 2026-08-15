package com.example.demo.tickets.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Aspect responsible for intercepting methods annotated with @LogExecutionTime
 * to measure and log their execution duration.
 */
@Aspect
@Component
public class ExecutionTimeAspect {

    private static final Logger logger = LoggerFactory.getLogger(ExecutionTimeAspect.class);

    /**
     * Intercepts the execution of methods annotated with @LogExecutionTime.
     *
     * @param joinPoint the join point representing the intercepted method.
     * @return the result of the method execution.
     * @throws Throwable if the underlying method throws an exception.
     */
    @Around("@annotation(com.example.demo.tickets.aspect.LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        // Proceed with the actual method execution
        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;

        // Log the method signature and the elapsed time
        logger.info("Method [{}] executed in {} ms",
                joinPoint.getSignature().toShortString(),
                executionTime);

        return proceed;
    }
}
