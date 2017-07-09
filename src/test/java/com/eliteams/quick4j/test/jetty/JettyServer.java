package com.eliteams.quick4j.test.jetty;

import java.net.URL;
import java.net.URLClassLoader;
import org.eclipse.jetty.util.log.StdErrLog;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * @author zhanfei
 * @since 2017-07-09
 * */
public class JettyServer {
	/**
	 * port
	 * */
	private int port = 81;

	/**
	 * jetty server 启动时
	 * @throws javax.naming.ConfigurationException
	 * */
	private void start() {
		// 设置jetty日志
		System.setProperty("org.eclipse.jetty.util.log.class",
				StdErrLog.class.getName());
		Server server = new Server();
		// 设置jetty连接器
		Connector connector = new SelectChannelConnector();
		connector.setPort(this.port);
		connector.setRequestHeaderSize(16246);
		server.setConnectors(new Connector[] { connector });
		String projectUrl = Class.class.getClass().getResource("/").getPath();
		// 设置context
		WebAppContext context = new WebAppContext();
		context.setResourceBase(projectUrl + "../../src/main/webapp");
		context.setContextPath("/");
		context.setDefaultsDescriptor(projectUrl
				+ "../../src/test/java/com/eliteams/quick4j/test/jetty/webdefault.xml");
		// PS:嵌入式的Jetty，应用当前工程的ClassPath，如果不设置将使用WebAppClassLoder，WEB-INF/lib目录加载jar。
		// context.setClassLoader(Thread.currentThread().getContextClassLoader());
		// PS:URLClassLoader支持jstl
		ClassLoader jspClassLoader = new URLClassLoader(new URL[0], this
				.getClass().getClassLoader());
		context.setClassLoader(jspClassLoader);
		context.setParentLoaderPriority(true);
		server.setHandler(context);
		// 启动Server
		try {
			server.start();
			server.join();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		JettyServer server = new JettyServer();
		server.start();
	}
}
