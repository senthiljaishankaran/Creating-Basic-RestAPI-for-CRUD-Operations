package com.Spring.SpringBoot.GettingStarted.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id= "features")
public class FeatureEndPoint {
    private Map<String,Feature> featureMap=new ConcurrentHashMap<>();
    public FeatureEndPoint(){
        featureMap.put("Student",new Feature(true));
        featureMap.put("Department",new Feature(false));
        featureMap.put("Id",new Feature(false));
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Feature{
        private boolean isEnabled;
    }
    @ReadOperation
    public Map<String, Feature> features() {
        return featureMap;
    }
    @ReadOperation
    public Feature feature(String featureName){
        return featureMap.get(featureName);
    }

}
