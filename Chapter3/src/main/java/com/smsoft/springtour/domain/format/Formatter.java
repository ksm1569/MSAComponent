package com.smsoft.springtour.domain.format;

public interface Formatter<T>{
    String of(T target);
}
