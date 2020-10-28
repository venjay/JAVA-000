package com.venjay.week02.server;

import com.venjay.week02.server.HttpServer;

public class Week02Application {

    public static void main(String[] args) {
        HttpServer server = new HttpServer(false,8808);
        try {
            server.run();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
