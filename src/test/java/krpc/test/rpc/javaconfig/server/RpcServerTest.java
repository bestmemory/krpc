package krpc.test.rpc.javaconfig.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import krpc.rpc.bootstrap.RpcApp;

public class RpcServerTest {

	static Logger log = LoggerFactory.getLogger(RpcServerTest.class);
	
	public static void main(String[] args) throws Exception {
		
	    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyServerJavaConfig.class);

	    RpcApp rpcApp = (RpcApp)context.getBean("rpcApp");
	    rpcApp.start();
	    
		Thread.sleep(150000);
		
		rpcApp.stop();
		
		context.close();
        ((ch.qos.logback.classic.Logger) log).getLoggerContext().stop();		
	}	
		
}

