package com.cskaoyan.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 张凡 on 2020/4/30 19:39
 */
@MappedTypes(Boolean.class)
public class BooleanTypeHandler implements TypeHandler<Boolean> {
    ObjectMapper objectMapper=new ObjectMapper();



    @SneakyThrows
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Boolean aBoolean, JdbcType jdbcType) throws SQLException {
        String s = objectMapper.writeValueAsString(aBoolean);
        preparedStatement.setString(i,s);

    }

    @SneakyThrows
    @Override
    public Boolean getResult(ResultSet resultSet, String s) throws SQLException {
        String string = resultSet.getString(s);
        Boolean aBoolean = objectMapper.readValue(string, Boolean.class);
        return aBoolean;
    }

    @SneakyThrows
    @Override
    public Boolean getResult(ResultSet resultSet, int i) throws SQLException {
        String string = resultSet.getString(i);
        Boolean aBoolean = objectMapper.readValue(string, Boolean.class);
        return aBoolean;
    }

    @SneakyThrows
    @Override
    public Boolean getResult(CallableStatement callableStatement, int i) throws SQLException {
        String string = callableStatement.getString(i);
        Boolean aBoolean = objectMapper.readValue(string, Boolean.class);
        return aBoolean;
    }
}
