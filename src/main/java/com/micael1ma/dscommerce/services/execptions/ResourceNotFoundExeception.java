package com.micael1ma.dscommerce.services.execptions;

public class ResourceNotFoundExeception extends RuntimeException {

    public ResourceNotFoundExeception(String msg) {
        super(msg);
    }
}
