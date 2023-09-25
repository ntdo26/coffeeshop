package com.interview.coffeeshop.configuration;

import com.interview.coffeeshop.brand.service.BrandService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Enumeration;

@Slf4j
public class TenantFilter extends OncePerRequestFilter {

    private final BrandService brandService;

    public TenantFilter(BrandService brandService) {
        this.brandService = brandService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Enumeration<String> tenantEnumeration = request.getHeaders("tenant");
        boolean isValid = false;
        if (tenantEnumeration.hasMoreElements()) {
            String tenant = tenantEnumeration.nextElement();
            var brand = brandService.getBrandByTenant(tenant);
            if (isTheSameTenant(tenant, tenant) && brand != null) {
                isValid = true;
            }
        }
        if (isValid) {
            filterChain.doFilter(request, response);
        } else {
            log.error("method=doFilterInternal, missing request header");
            response.sendError(HttpStatus.BAD_REQUEST.value());
        }
    }

    private boolean isTheSameTenant(String jwtToken, String tenantInHeader) {
        // TODO extract the tenant from JWT and compare with tenant in header
        return tenantInHeader.equals(jwtToken);
    }
}
