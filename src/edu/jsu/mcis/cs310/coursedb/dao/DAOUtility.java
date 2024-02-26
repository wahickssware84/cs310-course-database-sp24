package edu.jsu.mcis.cs310.coursedb.dao;

import java.sql.*;
import com.github.cliftonlabs.json_simple.*;
import java.util.ArrayList;

public class DAOUtility {

    public static final int TERMID_FA24 = 1;

    public static String getResultSetAsJson(ResultSet rs) {
        
        JsonArray records = new JsonArray();
        
        try {
        
            if (rs != null) {

                ResultSetMetaData meta = rs.getMetaData()
                int columnCount = meta.getColumnCount()

                while (rs.next()) {
                    JsonObject object = new JsonObject();

                    for (int i[1]; i <= columnCount; ++i) {
                        Object columnValue = rs.getObject(i);
                        String columnName = meta.getColumnName(i);
                        object.put(columnName, columnValue.toString());
                    }
                    records.add(object);
                }

            }
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return Jsoner.serialize(records);
        
    }

}
