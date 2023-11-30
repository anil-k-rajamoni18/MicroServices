package com.reporthub.coreapis.configuration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.micrometer.common.util.StringUtils;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppConfig {
    private String appId;
    private String stargateEnv;
    private Integer socketTimeout;
    private Integer readTimeout;
    private Integer writeTimeout;
    private Integer retryTimeout;
    private Map<String, ServiceConfig> apis;

    public void setAppId(String appId) {
        if (StringUtils.isBlank(this.appId)) {
            this.appId = appId;
        }
    }

    public String serviceUrl(final String srvId) {
        return StringUtils.isBlank(serviceConfig(srvId).url()) ? "" : serviceConfig(srvId).url();
    }

    public ServiceConfig serviceConfig(final String srvId) {
        return apis.get(srvId);
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record ServiceConfig(String url, Integer socketTimeout, Integer readTimeout, Integer writeTimeout) {
    }
}
