package com.top.zookeeper.client.test;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class Test {

	public static void main(String[] args) {
		try {
			ZooKeeper zk = new ZooKeeper("192.168.159.128:2181", 5000, new Watcher() {
				@Override
				public void process(WatchedEvent event) {
					System.out.println("已经触发了" + event.getType() + "事件！");
				}
			});
			try {
				// 创建节点
				zk.create("/testRootPath", "testRootData".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
				// 创建子节点
				//zk.create("/testRootPath/testChildPath2", "testChildPathTwo".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
				// 获取节点的数据，不出发事件，不设置版本
				//System.out.println(new String(zk.getData("/testRootPath/testChildPath1", false, null)));
				// 获取目录下子节点
				//System.out.println(zk.getChildren("/testRootPath", false));
				//zk.setData("/testRootPath/testChildPath2", "testChildPath2".getBytes(), 0);
				zk.delete("/testRootPath2", -1);
			} catch (KeeperException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
