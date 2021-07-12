package com.stte.jsonschema;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonNodeReader;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Iterator;

/**
 * @author: chenxiaohua
 * @date: 2021/7/12
 */
public class JsonSchemaTest {

    public static void main(String[] args) throws IOException {
        ClassPathResource json = new ClassPathResource("/test.json");
        JsonNodeReader jsonNodeReader = new JsonNodeReader();
        JsonNode jsonNode = jsonNodeReader.fromInputStream(json.getInputStream());

        ClassPathResource jsonSchema = new ClassPathResource("/testJsonSchema.json");
        JsonNodeReader jsonSchemaNodeReader = new JsonNodeReader();
        JsonNode jsonSchemaNode = jsonSchemaNodeReader.fromInputStream(jsonSchema.getInputStream());

        // 校验json 是否符合 jsonSchema约束
        validateJsonByFgeByJsonNode(jsonNode, jsonSchemaNode);

    }

    public static void validateJsonByFgeByJsonNode(JsonNode jsonNode, JsonNode schemaNode) {
        ProcessingReport report = null;
        report = JsonSchemaFactory.byDefault().getValidator().validateUnchecked(schemaNode, jsonNode);
        if (report.isSuccess()) {
            // 校验成功
            System.out.println("校验成功！");
        } else {
            System.out.println("校验失败！");
            for (ProcessingMessage processingMessage : report) {
                System.out.println(processingMessage);
            }
        }
    }
}
