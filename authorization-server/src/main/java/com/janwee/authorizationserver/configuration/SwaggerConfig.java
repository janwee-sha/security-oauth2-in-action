package com.janwee.authorizationserver.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Date;

/**
 * 
 * Function: Swagger 2配置. <br/>
 * date: 2020年5月24日 上午12:08:53 <br/>
 *
 * @author Jan-wee Sha
 * @since jdk1.8.0_92
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/**
	 * Swagger2 API Title
	 */
	@Value("${spring.application.name}")
	private String apiTitle;

	/**
	 * 创建Swagger2 Docket 对象
	 * 
	 * @return Docket
	 */
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).forCodeGeneration(true)
				.genericModelSubstitutes(ResponseEntity.class).ignoredParameterTypes(Pageable.class)
				.ignoredParameterTypes(java.sql.Date.class).directModelSubstitute(java.time.LocalDate.class, Date.class)
				.directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
				.directModelSubstitute(java.time.LocalDateTime.class, Date.class).select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).paths(PathSelectors.any())
				.build();
	}

	/**
	 * 
	 * @return ApiInfo
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(apiTitle + " API")
				.description("More projects please follow my github:https://github.com/janwee-sha")
				.termsOfServiceUrl("https://github.com/janwee-sha")
				.contact(new Contact("Jan-wee Sha", "https://github.com/janwee-sha", "janwee_sha@163.com"))
				.license("Brief introduction of the project")
				.licenseUrl("https://github.com/janwee-sha/java-projects/blob/master/janwee-security/README.md")
				.version("1.0").build();
	}
}
