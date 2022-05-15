package com.xanderhub.services.businesslogic;

@FunctionalInterface
public interface GreetingGenerator {
    String generate(UserInfoProvider userInfoProvider);
}
