package com.venjay.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

import javax.xml.ws.ServiceMode;

/**
 * @author :liuwenjie
 * @description : 实现filter
 * @date : 2020/11/4 19:40
 * @since 1.0.0
 **/
public class HttpRequestFilterImpl implements HttpRequestFilter {
    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        fullRequest.headers().set("my_header", "tests");
    }
}
