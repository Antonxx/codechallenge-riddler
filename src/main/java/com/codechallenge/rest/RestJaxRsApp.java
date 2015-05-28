package com.codechallenge.rest;

import org.glassfish.jersey.server.ResourceConfig;

public class RestJaxRsApp extends ResourceConfig {

    public RestJaxRsApp(){

        packages("com.codechallenge.rest");

    }

}
