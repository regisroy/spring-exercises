package com.zenika.service;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service("service")
public class ServiceImplThree implements Service {

    private StringBuilder recorder;

    @Autowired
    public ServiceImplThree(StringBuilder recorder) {
        this.recorder = recorder;
    }

    @Override
    public void execute() {
        recorder.append("Instance : ").append(toString()).append("\n");
        recorder.append("   Execution de ").append(this.getClass().getName()).append(".execute()\n");
    }
}
