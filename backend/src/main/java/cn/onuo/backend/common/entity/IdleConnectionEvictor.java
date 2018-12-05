package cn.onuo.backend.common.entity;

import org.apache.http.conn.HttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName IdleConnectionEvictor
 * @Description TODO
 * @Author nanaOni
 * @Date 2018/10/16 16:54
 * @Version 1.0
 **/

@Component
public class IdleConnectionEvictor extends Thread {

    @Autowired
    private HttpClientConnectionManager connMgr;

    private volatile boolean shutdown;

    public IdleConnectionEvictor() {
        super();
        super.start();
    }

    @Override
    public void run() {
        try {
            while (!shutdown) {
                synchronized (this) {
                    wait(5000);
                    // 关闭失效的连接
                    connMgr.closeExpiredConnections();
                }
            }
        } catch (InterruptedException ex) {
        // 结束
        }
    }

    // 关闭清理无效连接的线程
    public void shutdown() {
        shutdown = true;
        synchronized (this) {
            notifyAll();
        }
    }
}
