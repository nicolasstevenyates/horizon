package com.example.horizon.requests;

public interface OnTaskCompleted<D> {

    void requestCompleted(D data);

}
