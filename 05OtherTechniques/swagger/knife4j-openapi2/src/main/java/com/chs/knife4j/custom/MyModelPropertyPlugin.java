// package com.chs.knife4j.custom;
//
// import com.fasterxml.classmate.ResolvedType;
// import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
// import com.google.common.base.Optional;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;
// import springfox.documentation.schema.Annotations;
// import springfox.documentation.service.AllowableValues;
// import springfox.documentation.spi.DocumentationType;
// import springfox.documentation.spi.schema.ModelPropertyBuilderPlugin;
// import springfox.documentation.spi.schema.contexts.ModelPropertyContext;
// import springfox.documentation.spring.web.DescriptionResolver;
// import springfox.documentation.swagger.common.SwaggerPluginSupport;
//
//
//
// /**
//  * @author: chs
//  * @date: 2025-12-04 15:34
//  * @description: todo
//  */
// @Component
// public class MyModelPropertyPlugin implements ModelPropertyBuilderPlugin {
//     private final DescriptionResolver descriptions;
//
//     @Autowired
//     public MyModelPropertyPlugin(DescriptionResolver descriptions) {
//         this.descriptions = descriptions;
//     }
//
//     @Override
//     public void apply(ModelPropertyContext context) {
//         Optional<MyApiModelProperty> annotation = Optional.absent();
//     /*if (context.getAnnotatedElement().isPresent()) {
//           annotation =
//               annotation.or(
//                   ApiModelProperties.findApiModePropertyAnnotation(
//                       (AnnotatedElement) context.getAnnotatedElement().get()));
//         }
//     */
//         if (context.getBeanPropertyDefinition().isPresent()) {
//             annotation =
//                     annotation.or(
//                             Annotations.findPropertyAnnotation(
//                                     (BeanPropertyDefinition) context.getBeanPropertyDefinition().get(),
//                                     MyApiModelProperty.class));
//         }
//
//         // if (annotation.isPresent()) {
//         //     context
//         //             .getBuilder()
//         //             .allowableValues(
//         //                     (AllowableValues) annotation.transform(MyPropertiesUtil.toAllowableValues()).orNull())
//         //             .required((Boolean) annotation.transform(MyPropertiesUtil.toIsRequired()).or(false))
//         //             .readOnly((Boolean) annotation.transform(MyPropertiesUtil.toIsReadOnly()).or(false))
//         //             .description(
//         //                     (String)
//         //                             annotation.transform(MyPropertiesUtil.toDescription(this.descriptions)).orNull())
//         //             .isHidden((Boolean) annotation.transform(MyPropertiesUtil.toHidden()).or(false))
//         //             .type(
//         //                     (ResolvedType)
//         //                             annotation.transform(MyPropertiesUtil.toType(context.getResolver())).orNull())
//         //             .position((Integer) annotation.transform(MyPropertiesUtil.toPosition()).or(0))
//         //             .example((String) annotation.transform(MyPropertiesUtil.toExample()).orNull());
//         // }
//     }
//
//     @Override
//     public boolean supports(DocumentationType delimiter) {
//         return SwaggerPluginSupport.pluginDoesApply(delimiter);
//     }
// }