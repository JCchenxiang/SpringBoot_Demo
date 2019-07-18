package com.xchen.utils;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

public  class ElasticSearchUtils {

    private static ElasticSearchUtils esUtils = null;

    private static String host="192.168.57.130"; // 服务器地址
    private static int port=9300; // 端口
    TransportClient client = null;

    private ElasticSearchUtils(){

    }
    public static ElasticSearchUtils getInstance(){
        if(esUtils == null) esUtils = new ElasticSearchUtils();
        return esUtils;
    }

    public TransportClient getClient(){
        try {
            Settings settings = Settings.builder()
                    .put("cluster.name","myES").build();
            client = new PreBuiltTransportClient(settings)
                    .addTransportAddress(new TransportAddress(InetAddress.getByName(host),port));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return client;
    }
}
