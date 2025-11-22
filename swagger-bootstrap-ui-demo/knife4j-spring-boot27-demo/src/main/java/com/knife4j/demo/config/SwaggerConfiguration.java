//
package com.knife4j.demo.config;

import cn.hutool.core.collection.CollectionUtil;
import com.fasterxml.classmate.ResolvedType;
import com.fasterxml.classmate.TypeResolver;
import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.*;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Import(BeanValidatorPluginsConfiguration.class)
@EnableSwagger2WebMvc
public class SwaggerConfiguration implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    }

    //
//   //private final TypeResolver typeResolver;
////   private final OpenApiExtensionResolver openApiExtensionResolver;
////
////    @Autowired
////    public SwaggerConfiguration(TypeResolver typeResolver, OpenApiExtensionResolver openApiExtensionResolver) {
////        this.typeResolver = typeResolver;
////        this.openApiExtensionResolver = openApiExtensionResolver;
////    }
//
//
//    @Bean(value = "defaultApi2")
//    public Docket defaultApi2() {
//        UrlBasedCorsConfigurationSource configurationSource=new UrlBasedCorsConfigurationSource();
//        CorsConfiguration corsConfiguration=new CorsConfiguration();
//        CorsFilter corsFilter=new CorsFilter(configurationSource);
//        //schema
//        List<GrantType> grantTypes=new ArrayList<>();
//        //简单模式implicit
//        ImplicitGrant implicitGrant=new ImplicitGrant(new LoginEndpoint("http://localhost:8990/oauth/authorize"),"access_token");
//        //grantTypes.add(implicitGrant);
//        //授权码模式AuthorizationCodeGrant
//        TokenRequestEndpoint tokenRequestEndpoint=new TokenRequestEndpoint("http://localhost:8990/oauth/authorize","app1","123");
//        //TokenEndpoint tokenEndpoint=new TokenEndpoint("http://192.168.1.10:8080/oauth/token","access_token");
//        TokenEndpoint tokenEndpoint=new TokenEndpoint("http://localhost:8990/oauth/token","access_token");
//        AuthorizationCodeGrant authorizationCodeGrant=new AuthorizationCodeGrant(tokenRequestEndpoint,tokenEndpoint);
//        //grantTypes.add(authorizationCodeGrant);
//        //密码模式
//        String passwordTokenUrl="http://localhost:8990/oauth/token";
//        //String passwordTokenUrl="http://192.168.1.10:8080/oauth/token";
//        ResourceOwnerPasswordCredentialsGrant resourceOwnerPasswordCredentialsGrant=new ResourceOwnerPasswordCredentialsGrant(passwordTokenUrl);
//        //grantTypes.add(resourceOwnerPasswordCredentialsGrant);
//        //客户端模式（client credentials）
//        String clientTokenUrl="http://localhost:8990/oauth/token";
//        //String clientTokenUrl="http://192.168.1.10:8080/oauth/token";
//        ClientCredentialsGrant clientCredentialsGrant=new ClientCredentialsGrant(clientTokenUrl);
//        grantTypes.add(clientCredentialsGrant);
//
//
//        OAuth oAuth=new OAuthBuilder().name("oauth2")
//                .grantTypes(grantTypes).build();
//        //context
//        //scope方位
//        List<AuthorizationScope> scopes=new ArrayList<>();
//        scopes.add(new AuthorizationScope("read","read all resources"));
//        SecurityReference securityReference=new SecurityReference("oauth2",scopes.toArray(new AuthorizationScope[]{}));
//        //SecurityContext securityContext=new SecurityContext(CollectionUtil.newArrayList(securityReference),PathSelectors.ant("/api/**"));
//        //schemas
//        List<SecurityScheme> securitySchemes=CollectionUtil.newArrayList(oAuth);
//        //securyContext
//        //List<SecurityContext> securityContexts=CollectionUtil.newArrayList(securityContext);
//        List<Parameter> parameters=new ArrayList<>();
//        parameters.add(new ParameterBuilder()
//                .name("abroadId")
//                .description("(公共参数)环境标识")
//                .modelRef(new ModelRef("integer"))
//                .defaultValue("0")
//                .parameterType("query")
//                .required(true)
//                .build());
//        String groupName="2.X版本";
//        Docket docket=new Docket(DocumentationType.SWAGGER_2)
//                //.host("https://www.baidu.com")
//                .apiInfo(apiInfo())
//                .groupName(groupName)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.knife4j.demo.new2"))
//                //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//                .paths(PathSelectors.any())
//                .build()
//                .enableUrlTemplating(false)
//               // .extensions(openApiExtensionResolver.buildExtensions(groupName))
//                //.extensions(openApiExtensionResolver.buildSettingExtensions())
//                //.globalOperationParameters(parameters)
//                //.securityContexts(securityContexts).securitySchemes(securitySchemes);
//                .securityContexts(CollectionUtil.newArrayList(securityContext()))
//                .securitySchemes(CollectionUtil.newArrayList(apiKey()))
//                ;
//        return docket;
//    }
//    private List<ApiKey> securitySchemes() {
//        return CollectionUtil.newArrayList(
//                new ApiKey("JWT", "Authorization", "header"));
//    }
//

    //@Bean(value = "defaultApi")
    public Docket defaultApi() {


        Docket docket=new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("3.默认接口")
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build().securityContexts(CollectionUtil.newArrayList(securityContext()))
                .securitySchemes(CollectionUtil.newArrayList(apiKey()));
                //.extensions(openApiExtensionResolver.buildExtensions("3.默认接口"));
                //.extensions(openApiExtensionResolver.buildSettingExtensions())
                //.securityContexts(CollectionUtil.newArrayList(securityContext()))
                //.securitySchemes(CollectionUtil.newArrayList(apiKey()));
       // .securitySchemes(securitySchemes());
        return docket;
    }

    private List<SecurityScheme> securitySchemes() {
        List<SecurityScheme> apiKeyList= new ArrayList<>();

        apiKeyList.add(HttpAuthenticationScheme.JWT_BEARER_BUILDER.name("Authorization").build());
        return apiKeyList;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //.title("swagger-bootstrap-ui-demo RESTful APIs")
                .description("# swagger-bootstrap-ui-demo RESTful APIs")
                .termsOfServiceUrl("http://www.xx.com/")
                //.contact("xx@qq.com")
                .version("")
                .build();
    }
//
    private ApiKey apiKey() {
        return new ApiKey("BearerToken", "Authorization", "header");
    }
//    private ApiKey apiKey1() {
//        return new ApiKey("BearerToken1", "Authorization-x", "header");
//    }
//
    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                //.forPaths(PathSelectors.regex(".*?208.*$"))
                .build();
    }
//    private SecurityContext securityContext1() {
//        return SecurityContext.builder()
//                .securityReferences(defaultAuth1())
//                .forPaths(PathSelectors.regex("/.*"))
//                .build();
//    }
//
    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return CollectionUtil.newArrayList(new SecurityReference("BearerToken", authorizationScopes));
    }
//    List<SecurityReference> defaultAuth1() {
//        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
//        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//        authorizationScopes[0] = authorizationScope;
//        return CollectionUtil.newArrayList(new SecurityReference("BearerToken1", authorizationScopes));
//    }
//
}
