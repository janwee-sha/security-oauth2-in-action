package com.janwee.authorization.api.web.rest;

import io.swagger.annotations.Api;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Function: OAuth2 服务. <br/>
 * date: 2020/11/9 22:37 <br/>
 *
 * @author xiazhangwei
 * @since jdk1.8.0_92
 */
@Api(tags = {"Oauth 2.0 Service API"})
@RequestMapping("/oauth")
@FeignClient("auth-server")
public interface OAuth2Service {
}
