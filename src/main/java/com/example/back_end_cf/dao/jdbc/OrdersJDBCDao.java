package com.example.back_end_cf.dao.jdbc;

import com.example.back_end_cf.model.dto.OrdersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrdersJDBCDao {
//
//    @Autowired
//    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
//
//    public List<OrdersDTO> getAllOrdersWithSearch() {
//        List<OrdersDTO> result = new ArrayList<>();
//        Map<String, Object> params = new HashMap<>();
//
//        StringBuilder SQL = new StringBuilder();
//        SQL.append("SELECT /n");
//        SQL.append("orders_table.ORDER_ID,/n");
//        SQL.append("orders_table.BILL_NUMBER,/n");
//        SQL.append("orders_table.BILLED_DATE,/n");
//        SQL.append("orders_table.ORDER_QUANTITY,/n");
//        SQL.append("orders_table.TOTAL_AMOUNT,/n");
//        SQL.append("orders_table.PAYMENT_METHOD,/n");
//        SQL.append("orders_table.PAYMENT_STATUS,/n");
//        SQL.append("product_table.PRODUCT_NAME/n");
//        SQL.append("FROM/n");
//        SQL.append("orders_table/n");
//        SQL.append("LEFT JOIN product_table /n");
//        SQL.append("ON /n");
//        SQL.append("orders_table.PRODUCT_ID = product_table.PRODUCT_ID;/n");
//
//        return namedParameterJdbcTemplate.query(SQL.toString(), params, new ResultSetExtractor<List<OrdersDTO>>() {
//            @Override
//            public List<OrdersDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
//                while (rs.next()) {
//                    OrdersDTO ordersDTO = new OrdersDTO();
//                    ordersDTO.setOrderID(rs.getInt("ORDER_ID"));
//                    ordersDTO.setBillNumber(rs.getString("BILL_NUMBER"));
//                    ordersDTO.setBilledDate(rs.getString("BILLED_DATE"));
//                    ordersDTO.setOrderQuantity(rs.getInt("ORDER_QUANTITY"));
//                    ordersDTO.setTotalAMount(rs.getInt("TOTAL_AMOUNT"));
//                    ordersDTO.setPaymentMethod(rs.getString("PAYMENT_METHOD"));
//                    ordersDTO.setPaymentStatus(rs.getString("PAYMENT_STATUS"));
//                    ordersDTO.setProductName(rs.getString("PRODUCT_NAME"));
//
//                    result.add(ordersDTO);
//                }
//
//                return result;
//            }
//        });
//    }
}
