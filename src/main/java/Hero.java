import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**
 * Created by kk on 2017/5/4.
 */
public class Hero extends Type{

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String LOCALIZED_NAME = "localized_name";
    private static final int LISTCOUNT = 3;

    private static final String TABLENAME = "heroes";

    private String name;

    private int id;

    private String localized_name;

    private JSONArray jsonArray = new JSONArray();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocalized_name() {
        return localized_name;
    }

    public void setLocalized_name(String localized_name) {
        this.localized_name = localized_name;
    }

    public Hero() {
    }

    public Hero(JSONObject jsonObject) {
        super(jsonObject);
        jsonArray.add(1, this.getId());
        jsonArray.add(2, this.getName());
        jsonArray.add(3, this.getLocalized_name());
    }

    @Override
    public void init(JSONObject jsonObject) {
        super.init(jsonObject);
        Object ob_id = jsonObject.get(ID);
        Object ob_name = jsonObject.get(NAME);
        Object ob_localized_name = jsonObject.get(LOCALIZED_NAME);
        this.setId(Integer.parseInt(ob_id.toString()));
        this.setName(ob_name.toString());
        this.setLocalized_name(ob_localized_name.toString());
    }

    @Override
    public int fields() {
        return LISTCOUNT;
    }

    @Override
    public String linkStr() {
        super.setTableName(TABLENAME);
        return super.linkStr();
    }
}
