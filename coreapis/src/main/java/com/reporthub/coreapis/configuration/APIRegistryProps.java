package com.reporthub.coreapis.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.reporthub.coreapis.constants.ClientConstants.API_PATH_SEPARATOR;

@ConfigurationProperties(prefix = "api-registry")
public class APIRegistryProps {
    private final Integer socketTimeout;
    private final Integer readTimeout;
    private final Integer writeTimeout;
    private final Integer retryTimeout;
    private final StargateConfig stargateConfig;
    private final Map<String,AppConfig> registrations;

    public APIRegistryProps(final Integer socketTimeout, final Integer readTimeout,
                            final Integer writeTimeout, final Integer retryTimeout,
                            final StargateConfig stargateConfig,
                            final Map<String, AppConfig> registrations) {
        this.socketTimeout = socketTimeout;
        this.readTimeout = readTimeout;
        this.writeTimeout = writeTimeout;
        this.retryTimeout = retryTimeout;
        this.stargateConfig = stargateConfig;
        this.registrations = populateRegistrations(registrations);;
    }

    private Map<String,AppConfig> populateRegistrations(final Map<String,AppConfig> registrations) {
            if (registrations != null) {
                return registrations.entrySet().stream().map(elm -> {
                    AppConfig config = elm.getValue();
                    config.setAppId(elm.getKey());
                    config.setSocketTimeout(nvl(config.getSocketTimeout(), socketTimeout));
                    config.setReadTimeout(nvl(config.getReadTimeout(),readTimeout));
                    config.setWriteTimeout(nvl(config.getWriteTimeout(),writeTimeout));
                    return elm;
                }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            }
            return new HashMap<>();
    }

    public Integer socketTimeout() {
        return socketTimeout;
    }

    public Integer socketTimeout(final String appRegId) {
        return registrations.get(appRegId).getSocketTimeout();
    }

    public Integer readTimeout() {
        return readTimeout;
    }

    public Integer readTimeout(final String appRegId) {
        return registrations.get(appRegId).getReadTimeout();
    }

    public Integer writeTimeout() {
        return writeTimeout;
    }

    public Integer writeTimeout(final String appRegId) {
        return registrations.get(appRegId).getWriteTimeout();
    }

    public Integer retryTimeout() {
        return retryTimeout;
    }

    public Integer retryTimeout(final String appRegId) {
        return registrations.get(appRegId).getRetryTimeout();
    }


    public String serviceUrl(final String appRegId, final String srvId) {
        return registrations.get(appRegId).serviceUrl(srvId);
    }

    public String serviceAbsoluteURL(final String appRegId, final String srvId) {
        return stargateConfig.env().get(registrations.get(appRegId).getStargateEnv())
                .concat(API_PATH_SEPARATOR)
                .concat(registrations.get(appRegId).serviceUrl(srvId));
    }

    private Integer nvl(final Integer... integers) {
        return Arrays.stream(integers).filter(Objects::nonNull)
                .findFirst().orElse(null);
    }

    public record StargateConfig(Map<String, String> env, String clientId, String clientSecret, String tokenPath) {
    }
}
