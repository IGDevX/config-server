package org.igdevx.configserver.config;

import com.netflix.discovery.EurekaClientConfig;
import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;
import org.springframework.context.annotation.Bean;

public class EurekaConfigOverride {
    @Bean
    public EurekaClientConfig eurekaClientConfig() {
        EurekaClientConfigBean config = new EurekaClientConfigBean();
        String eurekaUrl = System.getenv("EUREKA_URI");
        if (eurekaUrl != null && !eurekaUrl.isEmpty()) {
            config.getServiceUrl().put("defaultZone", eurekaUrl);
            System.out.println("Eureka defaultZone set to: " + eurekaUrl);
        } else {
            System.out.println("EUREKA_URI not set, using default localhost");
        }
        return config;
    }
}
