package com.example.grpcservice;


import com.example.HelloReply;
import com.example.HelloRequest;
import com.example.SimpleGrpc;
import io.grpc.stub.StreamObserver;

import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GrpcServerService extends SimpleGrpc.SimpleImplBase {

    @Override
    public void sayHello(final HelloRequest req, final StreamObserver<HelloReply> responseObserver){
        HelloReply reply = HelloReply.newBuilder().setMessage("Hello ==> " + req.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
