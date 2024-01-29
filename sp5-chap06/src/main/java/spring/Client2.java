package spring;

/**
 * Created by Sang Jun Park on 01/28/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class Client2 {

    private String host;

    public void setHost(String host){
        this.host = host;
    }

    public void connect(){
        System.out.println("Execute : Client2.afterPropertiesSet()");
    }

    public void close(){
        System.out.println("Execute : Client2.destroy()");
    }
    public void send(){
        System.out.println("Client2.send() to " + host);
    }
}
