package chap02;

/**
 * Created by Sang Jun Park on 6/15/2023.
 * Github : http://github.com/SangJun-GitHub
 */
public class Greeter {
    private String format;

    public String greeter(String guest){
        return String.format(format, guest);
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
