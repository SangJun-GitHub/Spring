package aspect2;

import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by Sang Jun Park on 02/01/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class CommonPointcut {

    @Pointcut("execution(public * chap07..*(..))")
    public void commonTarget() {
    }

}