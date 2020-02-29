package org.poem.service.impl;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMultiLock;
import org.apache.zookeeper.CreateMode;
import org.poem.service.DistributedLockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 * @author poem
 */
@Service
public class DistributedLockServiceImpl implements DistributedLockService {

    private static final Logger logger = LoggerFactory.getLogger(DistributedLockServiceImpl.class);

    private final static String LOCK_PATH = "/lock/canal";

    @Autowired
    private CuratorFramework client;

    /**
     * 创建
     */
    @Override
    public void createLock(){
        logger.info("try do job for " + LOCK_PATH);
        try{
            InterProcessMultiLock lock = new InterProcessMultiLock(client, Collections.singletonList(LOCK_PATH));
            client.create().withMode(CreateMode.EPHEMERAL).forPath(LOCK_PATH);
            if (lock.acquire(10, TimeUnit.MINUTES)){
                try{
                    Thread.sleep(1000*5);
                }catch (Exception e){
                    logger.error(e.getMessage() ,e );
                }finally {
                    lock.release();
                }
            }
        }catch (Exception e){
            logger.error(e.getMessage() ,e );
        }
    }
}
