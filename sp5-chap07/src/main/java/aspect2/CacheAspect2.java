package aspect2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sang Jun Park on 02/01/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

@Aspect
public class CacheAspect2 {

    private Map<Long, Object> cache = new HashMap<>();

    @Around("aspect2.CommonPointcut.commonTarget()")
    public Object execution(ProceedingJoinPoint joinPoint) throws Throwable{
        Long num = (Long) joinPoint.getArgs()[0];

        if(cache.containsKey(num)){
            System.out.printf("CacheAspect: Get from cache[%d]\n", num);
            return cache.get(num);
        }

        Object result = joinPoint.proceed();
        cache.put(num, result);
        System.out.printf("CacheAspect: Add into cache[%d]\n", num);
        return result;
    }
}
