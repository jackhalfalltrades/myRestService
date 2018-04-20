package com.jackhalfalltrades.springboot.myRestservice.service;


import com.jackhalfalltrades.foundation.datasource.FoundationDataSource;
import com.jackhalfalltrades.foundation.exception.FoundationRuntimeException;
import com.jackhalfalltrades.foundation.utils.FoundationConstants;
import com.jackhalfalltrades.springboot.myRestservice.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;


@Service
public class MyRestService {

    @Autowired
    private Environment environment;

    public City getCity(String location) {
        String query = (
                "SELECT name, location " +
                        "FROM cities " +
                        "WHERE location = :location;"
        );

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("location", location);

        try {
            //FoundationDataSource foundationDataSource = new FoundationDataSource();

            NamedParameterJdbcTemplate template = FoundationDataSource.builder().environment(environment).build().getJdbcTemplate();
            City city = (City) template.queryForObject(query, params, new StoreAccountMapper());
            return city;
        } catch (Exception e) {
            throw new FoundationRuntimeException(FoundationConstants.RUNTIMEEXCEPTION_MSG_KEY,
                    new Object[]{"120212-Exception while trying to query the database", e});
        }
    }


    public class StoreAccountMapper implements RowMapper {
        public City mapRow(ResultSet rs, int rowNum) throws SQLException {
            return City.builder().name(rs.getString("name"))
                    .location(rs.getString("location"))
                    .build();
        }
    }

}