/**
 * Copyright (c) 2017, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package io.github.spafka.mybatis.generator.plugin.type;

import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

import java.sql.Types;

/**
 * 项目：mybatis-generator-plugins
 * 包名：xyz.mrwood.mybatis.generator.plugin.type
 * 功能：tinyint 转 integer
 * 时间：2017-02-28 16:07
 * 作者：Mr.Kiwi
 */
public class ByteCastInteger extends JavaTypeResolverDefaultImpl {

    public ByteCastInteger() {

        super.typeMap.put(Types.TINYINT, new JdbcTypeInformation("INTEGER", //$NON-NLS-1$
            new FullyQualifiedJavaType(Integer.class.getName())));
    }
}
