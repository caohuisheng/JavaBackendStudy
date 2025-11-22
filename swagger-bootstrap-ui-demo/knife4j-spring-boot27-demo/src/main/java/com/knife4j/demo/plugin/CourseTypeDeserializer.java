package com.knife4j.demo.plugin;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.knife4j.demo.model.CourseType;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Objects;

/**
 * @author <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2023/8/6 07:24
 * @since knife4j-spring-boot27-demo
 */
@Slf4j
public class CourseTypeDeserializer  extends JsonDeserializer<CourseType> {
    @Override
    public CourseType deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        log.info("des....");
        String type = jsonParser.getValueAsString();
        log.info("value:{}",type);
        for (CourseType courseType : CourseType.values()) {
            if (type.startsWith(Objects.toString(courseType.getType()))) {
                return courseType;
            }
        }
        throw new IllegalArgumentException("Invalid CourseType value: " + type);
    }
}
