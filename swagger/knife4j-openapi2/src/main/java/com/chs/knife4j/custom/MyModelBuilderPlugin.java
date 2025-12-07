// package com.chs.knife4j.custom;
//
// import com.fasterxml.classmate.TypeResolver;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.core.annotation.AnnotationUtils;
// import org.springframework.stereotype.Component;
// import springfox.documentation.spi.DocumentationType;
// import springfox.documentation.spi.schema.ModelBuilderPlugin;
// import springfox.documentation.spi.schema.contexts.ModelContext;
//
// /**
//  * @author: chs
//  * @date: 2025-12-04 15:34
//  * @description: todo
//  */
// // @Component
// public class MyModelBuilderPlugin implements ModelBuilderPlugin {
//     private final TypeResolver typeResolver;
//
//     @Autowired
//     public MyModelBuilderPlugin(TypeResolver typeResolver) {
//         this.typeResolver = typeResolver;
//     }
//
//     @Override
//     public void apply(ModelContext context) {
//         MyApiModel annotation = AnnotationUtils.findAnnotation(forClass(context), MyApiModel.class);
//         if (annotation != null) {
//             context.getBuilder().description(annotation.description());
//         }
//     }
//
//     private Class<?> forClass(ModelContext context) {
//         return typeResolver.resolve(context.getType()).getErasedType();
//     }
//
//     @Override
//     public boolean supports(DocumentationType delimiter) {
//         return true;
//     }
// }