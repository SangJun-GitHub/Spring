package spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by Sang Jun Park on 01/27/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class Client implements InitializingBean, DisposableBean {

    private String host;

    public void setHost(String host){
        this.host = host;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Execute : Client.afterPropertiesSet()");
    }
    @Override
    public void destroy() throws Exception {
        System.out.println("Execute : Client.destroy()");
    }

    public void send(){
        System.out.println("Client.send() to " + host);
    }
}
