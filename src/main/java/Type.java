import net.sf.json.JSONObject;

/**
 * Created by kk on 2017/5/8.
 */
public class Type {

    private static final int FIELD = 0;
    private static final String EMPTY = "";

    private String tableName;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Type() {
    }

    public Type(JSONObject jsonObject) {
        super();
        if (jsonObject != null) {
            this.init(jsonObject);
        }
    }

    public void init(JSONObject jsonObject) {
    }

    public int fields() {
        return FIELD;
    }

    public String linkStr() {
        String insert = "INSERT INTO " + this.getTableName();
        insert += " VALUES(";
        for (int i = 0; i < fields(); i++) {
            insert += "?,";
        }
        insert = insert.substring(0, insert.length() - 1);
        insert += ")";
        return insert;
    }
}
