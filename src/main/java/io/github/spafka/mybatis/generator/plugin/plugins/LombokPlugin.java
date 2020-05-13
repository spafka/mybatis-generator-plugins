/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package io.github.spafka.mybatis.generator.plugin.plugins;

import io.github.spafka.mybatis.generator.plugin.common.LombokConstant;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;

/**
 * 项目：mybatis-generator-plugin
 * 包名：xyz.mrwood.mybatis.generator.plugin
 * 功能：给生成的model类添加lombok的Data与Builder注解，和不生成getter与setter方法
 * 时间：2016-06-24 16:54
 * 作者：Mr.Kiwi
 */
public class LombokPlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

        addAnno(topLevelClass, LombokConstant.LOMBOK_ANNO_DATA);

        return true;
    }

    /**
     * 返回false,取消生成getter方法
     *
     * @param method
     * @param topLevelClass
     * @param introspectedColumn
     * @param introspectedTable
     * @param modelClassType
     * @return
     */
    @Override
    public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {

        return false;
    }

    /**
     * 返回false,取消生成setter方法
     *
     * @param method
     * @param topLevelClass
     * @param introspectedColumn
     * @param introspectedTable
     * @param modelClassType
     * @return
     */
    @Override
    public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {

        return false;
    }

    /**
     * 添加注解
     *
     * @param topLevelClass
     */
    private void addAnno(TopLevelClass topLevelClass, String fullyQualifiedJavaType) {

        FullyQualifiedJavaType full = new FullyQualifiedJavaType("lombok.Data");

        topLevelClass.addImportedType(fullyQualifiedJavaType);
        topLevelClass.addImportedType(new FullyQualifiedJavaType("lombok.experimental.Accessors"));

        topLevelClass.addAnnotation("@Data");
        topLevelClass.addAnnotation("@Accessors(chain = true)");
    }
}
