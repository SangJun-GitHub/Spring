package chap07;

/**
 * Created by Sang Jun Park on 01/29/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class ImpeCalculator implements Calculator{
    @Override
    public long factorial(long num) {

//        long start = System.currentTimeMillis();
        long result = 1;

        for(long i = 1; i <= num; i++){
            result *= i;
        }

//        long end = System.currentTimeMillis();
//        System.out.printf("ImpeCalculator.factorial(%d) runtime = %d\n", num, (end - start));

        return result;
    }
}
