import net.sf.json.JSONObject;

/**
 * Created by kk on 2017/5/8.
 */
public class Type {

    private static final int FIELD = 0;
    private static final String EMPTY = "";

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
        return EMPTY;
    }
}
