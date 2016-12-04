import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 1、@EnableScheduling单线程执行计划任务，import引入Task相关注释为多线程
 */
@SpringBootApplication(scanBasePackages = "com.ellis.web")
// @EnableScheduling
@Configuration
@ImportResource(locations = { "classpath:spring-main.xml" })
public class WebBootApplication extends SpringBootServletInitializer
{
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebBootApplication.class);
    }

    public static void main(String[] args)
    {
        SpringApplication.run(WebBootApplication.class, args);
    }
}
