package com.interview.coffeeshop.configuration;

import com.interview.coffeeshop.brand.service.BrandService;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {

    @Bean
    public FilterRegistrationBean<TenantFilter> logFilter(BrandService brandService) {
        FilterRegistrationBean<TenantFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new TenantFilter(brandService));
        registrationBean.addUrlPatterns("/v1/*");
        return registrationBean;
    }
}
