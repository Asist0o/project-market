package market.config;

import com.github.scribejava.apis.VkontakteApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.oauth.OAuth20Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:oauth2Client.properties")
public class VkOauth2Config {

    @Value("${vk.client.id}")
    private String clientID;

    @Value("${vk.client.secret}")
    private String clientSecret;

    @Value("${vk.client.scope}")
    private String scope;

    @Value("${vk.client.redirect}")
    private String redirectCallback;

    @Bean
    public OAuth20Service getVkOAuth20Service() {
        return new ServiceBuilder(clientID)
                .apiSecret(clientSecret)
                .defaultScope(scope)
                .callback(redirectCallback)
                .build(VkontakteApi.instance());
    }
}
