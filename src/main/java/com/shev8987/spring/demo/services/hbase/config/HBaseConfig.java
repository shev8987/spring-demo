package com.shev8987.spring.demo.services.hbase.config;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.HBaseAdmin;

import java.io.IOException;

public abstract class HBaseConfig {

    public static final String HBASE_ZOOKEEPER_QUORUM_PARAM = "hbase.zookeeper.quorum";
    public static final String ZOOKEEPER_ZNODE_PARENT_PARAM = "zookeeper.znode.parent";

    public Configuration composeHbaseConfig() {
        // Конфиг org.apache.hadoop.conf.Configuration
        Configuration config = HBaseConfiguration.create();
        config.set(HBASE_ZOOKEEPER_QUORUM_PARAM, "localhost");
        config.set(ZOOKEEPER_ZNODE_PARENT_PARAM, "/hbase");

        return config;
    }

    public Connection getConnection(Configuration config) throws IOException {

        try {
            HBaseAdmin.available(config);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ConnectionFactory.createConnection(config);
    }
}
