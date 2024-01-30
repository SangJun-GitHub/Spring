package chap07;

/**
 * Created by Sang Jun Park on 01/29/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class ExeTimeCalculator implements Calculator{

    private Calculator delegate;

    public ExeTimeCalculator(Calculator delegate){
        this.delegate = delegate;
    }
    @Override
    public long factorial(long num) {
        long start = System.nanoTime();
        long result = delegate.factorial(num);
        long end = System.nanoTime();
        System.out.printf("%s.factorial(%d) runtime = %d\n", delegate.getClass().getSimpleName(), num, (end - start));

        return result;
    }
}
