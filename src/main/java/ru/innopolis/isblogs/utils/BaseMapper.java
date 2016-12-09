package ru.innopolis.isblogs.utils;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * Created by Nikolay on 05.12.2016.
 */
public class BaseMapper {
    public final static MapperFactory MAPPER_FACTORY = new DefaultMapperFactory.Builder().build();
}