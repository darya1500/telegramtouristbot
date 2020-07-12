package by.resliv.daryatarasevich.telegramtouristbot.config;

import by.resliv.daryatarasevich.telegramtouristbot.bot.TouristBot;
import by.resliv.daryatarasevich.telegramtouristbot.util.MessageConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiContext;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Class with configurations.
 *
 * @author darya tarasevich
 */
@Configuration
@PropertySource(value = { "classpath:application.properties" })
@EnableJpaRepositories("by.resliv.daryatarasevich.telegramtouristbot.repository")
@EnableSwagger2
public class TouristBotConfig {
    @Value("bot.name")
    private String botUserName;
    @Value("bot.token")
    private String botToken;
    @Value("${spring.datasource.driver-class-name}")
    public String driver;
    @Value("${spring.datasource.url}")
    public String url;

    @Bean
    public TouristBot TouristBot() {
        DefaultBotOptions options = ApiContext.getInstance(DefaultBotOptions.class);
        TouristBot myBot = new TouristBot(options);
        myBot.setName(botUserName);
        myBot.setToken(botToken);
        return myBot;
    }

    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        return dataSource;
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(MessageConstants.CONTROLLER))
                .paths(PathSelectors.any())
                .build();
    }
}
