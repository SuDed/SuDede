package cn.jiyun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

//加注解、自动被springboot加载
@Configuration //spring中的application.xml <beans></beans>
public class CorsConfig {

    //corsFilter
    @Bean// <bean></bean>
    public CorsFilter getCorsFilter(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //简单请求，特殊请求
        //1.origin 允许的跨域的域  *所有的域都可以跨  不要写*，否则cookie就无效
        corsConfiguration.addAllowedOrigin("*");
        //2.是否可以携带cookie
        corsConfiguration.setAllowCredentials(true);
        //3.允许访问的方式有哪些  8种  *所有的访问方式都允许
        corsConfiguration.addAllowedMethod("*");
        //4.允许携带的头信息  *啥都可以带
        corsConfiguration.addAllowedHeader("*");


        UrlBasedCorsConfigurationSource cc = new UrlBasedCorsConfigurationSource();
        cc.registerCorsConfiguration("/**",corsConfiguration);

        //3.返回新的CorsFilter
        return new CorsFilter(cc);
    }
}
