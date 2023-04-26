package com.cskaoyan.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 张凡 on 2020/5/6 12:48
 */
@MappedTypes(Integer[].class)
public class String2IntegerList implements TypeHandler<Integer[]> {
    @SneakyThrows
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Integer[] integers, JdbcType jdbcType) throws SQLException {
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(integers);
        preparedStatement.setString(i,s);
    }

    @Override
    public Integer[] getResult(ResultSet resultSet, String s) throws SQLException {
        String string = resultSet.getString(s);
        Integer[] integers = transfer(string);
        return integers;
    }

    private Integer[] transfer(String string) {
        if(string!=null&&string.length()>2){
            String replace = string.replace("", "");
            String[] split = replace.subSequence(1, replace.length() - 1).toString().split(",");
            Integer[] inteArray = (Integer[]) ConvertUtils.convert(split, Integer.class);
            return inteArray;
        }else {
            return null;
        }

    }

    @Override
    public Integer[] getResult(ResultSet resultSet, int i) throws SQLException {
        String string = resultSet.getString(i);
        Integer[] integers = transfer(string);
        return integers;
    }

    @Override
    public Integer[] getResult(CallableStatement callableStatement, int i) throws SQLException {
        String string = callableStatement.getString(i);
        Integer[] integers = transfer(string);
        return integers;
    }
}
