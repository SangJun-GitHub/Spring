package chap07;

/**
 * Created by Sang Jun Park on 01/29/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class RecCalculator implements Calculator{
    @Override
    public long factorial(long num) {
        if(num == 0)
            return 1;
        else
            return num * factorial(num - 1);
    }
}
