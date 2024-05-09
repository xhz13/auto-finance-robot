package com.finance;

import java.sql.Types;
import java.util.Collections;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class CoderGenerator {
    
    public static void main(String[] args) {
    FastAutoGenerator.create("jdbc:mysql://localhost:3306/statadata?characterEncoding=utf-8&serverTimezone=Asia/Shanghai", "root", "12345")
        .globalConfig(builder -> {
            builder.author("Xiong") // 设置作者
                .outputDir("C://Users//1//Desktop//Code//auto-finance-robot//financerobot//src//main//java"); // 指定输出目录
        })
        .dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
            int typeCode = metaInfo.getJdbcType().TYPE_CODE;
            if (typeCode == Types.SMALLINT) {
                // 自定义类型转换
                return DbColumnType.INTEGER;
            }
            return typeRegistry.getColumnType(metaInfo);

        }))
        .packageConfig(builder -> {
            builder.parent("com.finance.domain") // 设置父包名
                .entity("entity")           //Entity 包名 默认值:entity
                .pathInfo(Collections.singletonMap(OutputFile.mapper, "C://Users//1//Desktop//Code//auto-finance-robot//financerobot//src//main//java//com//finance//mapper")); // 设置Java mapper生成路径
        })
        .strategyConfig(builder -> {
            builder.addInclude("stock_data"); // 设置需要生成的表名
        })
        .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
        .execute();
    }
}

