package spring;

/**
 * Created by Sang Jun Park on 01/24/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class VersionPrinter {
    private int majorVersion;
    private int minorVersion;

    public void setMajorVersion(int majorVersion) {
        this.majorVersion = majorVersion;
    }

    public void setMinorVersion(int minorVersion) {
        this.minorVersion = minorVersion;
    }

    public void print(){
        System.out.printf("This program version is %d.%d\n", majorVersion, minorVersion);
    }
}
