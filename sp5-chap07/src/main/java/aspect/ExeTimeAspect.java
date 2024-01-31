package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

/**
 * Created by Sang Jun Park on 01/30/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

@Aspect
public class ExeTimeAspect {

    @Pointcut("execution(public * chap07..*(..))")
    private void publicTarget(){
    }

    @Around("publicTarget()")
    public Object measure(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.nanoTime();

        try{
            Object result = joinPoint.proceed();
            return result;
        } finally {
            long finish = System.nanoTime();
            Signature sig = joinPoint.getSignature();
            System.out.printf("%s.%s(%s) runtime = %d ns\n",
                    joinPoint.getTarget().getClass().getSimpleName(),
                    sig.getName(),
                    Arrays.toString(joinPoint.getArgs()),
                    (finish - start));
        }
    }
}
