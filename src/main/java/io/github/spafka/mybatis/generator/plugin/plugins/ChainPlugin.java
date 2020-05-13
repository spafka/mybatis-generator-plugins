package io.github.spafka.mybatis.generator.plugin.plugins;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;

import java.util.List;
/**
 * @author spafka 2020-05-13
 */
//@See @Accesses(chain=true)
public class ChainPlugin extends PluginAdapter {
    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass,
                                                 IntrospectedTable introspectedTable) {

        return true;
    }

    @Override
    public boolean modelRecordWithBLOBsClassGenerated(
            TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
       return true;
    }

    @Override
    public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass,
                                                 IntrospectedTable introspectedTable) {

        return true;
    }

    /**
     * 返回false,取消生成getter方法
     *
     */
    @Override
    public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {

        return false;
    }

    /**
     * 返回false,取消生成setter方法
     *
     */
    @Override
    public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {

        return false;
    }


    @Override
    public boolean modelFieldGenerated(Field field, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {

        settergetter(field,topLevelClass);
        return true;
    }

    private void settergetter(
                              Field field,TopLevelClass topLevelClass) {


        {
            Method method = new Method();
            method.setVisibility(JavaVisibility.PUBLIC);
            method.setReturnType(field.getType());
            String name = field.getName();
            method.setName("get" + name.substring(0, 1).toUpperCase() + name.substring(1));

            method.addBodyLine("return this." + name + ";");

            topLevelClass.addMethod(method);
        }

        {


            Method method = new Method();
            method.setVisibility(JavaVisibility.PUBLIC);
            method.setReturnType(topLevelClass.getType());
            String name = field.getName();
            method.setName("set"+  name.substring(0, 1).toUpperCase() + name.substring(1));

            method.addParameter(new Parameter(field.getType(),name));



            method.addBodyLine("this."+name+" = "+name+";");
            method.addBodyLine("return this;");

            topLevelClass.addMethod(method);
        }


    }
}
