package Pertemuan6.Complex;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class Model {

    protected abstract String tableName();

    public <T> List<T> select(String where, Class<? extends Model> className) {
        Database db = new Database();
        List<T> list = new ArrayList<>();
        try {
            Statement statement = db.makeStatement();

            String str = "SELECT * FROM " + tableName();
            if (where != null)
                str += " WHERE " + where;

            ResultSet result = statement.executeQuery(str);

            HashMap<Integer, Method> methods = new HashMap<Integer, Method>();
            for (int i = 1; i <= result.getMetaData().getColumnCount(); i++) {
                String columnName = result.getMetaData().getColumnName(i);

                try {
                    switch (result.getMetaData().getColumnType(i)) {
                        case Types.INTEGER:
                        case Types.SMALLINT:
                        case Types.TINYINT:
                        case Types.BIGINT:
                            methods.put(i, className.getDeclaredMethod("set" + columnName, Integer.class));
                        case Types.VARCHAR:
                        case Types.CHAR:
                            methods.put(i, className.getDeclaredMethod("set" + columnName, String.class));
                    }
                } catch (NoSuchMethodException e) {
                    System.err.println("No method named set" + columnName);
                }
            }

            while (result.next()) {
                try {
                    T o = (T) className.newInstance();
                    for (int i = 1; i <= result.getMetaData().getColumnCount(); i++) {
                        Method method = methods.get(i);
                        if (method != null) {
                            switch (result.getMetaData().getColumnType(i)) {
                                case Types.INTEGER:
                                case Types.SMALLINT:
                                case Types.TINYINT:
                                case Types.BIGINT:
                                    method.invoke(o, result.getInt(i));
                                    break;
                                case Types.VARCHAR:
                                case Types.CHAR:
                                    method.invoke(o, result.getString(i));
                                    break;
                            }
                        }
                    }
                    list.add(o);
                } catch (InstantiationException | InvocationTargetException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
