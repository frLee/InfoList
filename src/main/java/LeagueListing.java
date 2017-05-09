import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Created by kk on 2017/5/8.
 */
public class LeagueListing extends Type{

    private static final String NAME = "name";
    private static final String LEAGUEID = "leagueid";
    private static final String DESCRIPTION = "description";
    private static final String TOURNAMENT_URL = "tournament_url";
    private static final String ITEMDEF = "itemdef";
    private static final int LISTCOUNT = 5;

    private static final String TABLENAME = "LeagueListing";

    private String name;
    private int leagueid;
    private String description;
    private String tournament_url;
    private int itemdef;

    private JSONArray jsonArray = new JSONArray();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLeagueid() {
        return leagueid;
    }

    public void setLeagueid(int leagueid) {
        this.leagueid = leagueid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTournament_url() {
        return tournament_url;
    }

    public void setTournament_url(String tournament_url) {
        this.tournament_url = tournament_url;
    }

    public int getItemdef() {
        return itemdef;
    }

    public void setItemdef(int itemdef) {
        this.itemdef = itemdef;
    }

    public JSONArray getJsonArray() {
        return jsonArray;
    }

    public void setJsonArray(JSONArray jsonArray) {
        this.jsonArray = jsonArray;
    }

    public LeagueListing() {
    }

    public LeagueListing(JSONObject jsonObject) {
        super(jsonObject);
        jsonArray.add(0, this.getName());
        jsonArray.add(1, this.getLeagueid());
        jsonArray.add(2, this.getDescription());
        jsonArray.add(3, this.getTournament_url());
        jsonArray.add(4, this.getItemdef());
    }

    @Override
    public void init(JSONObject jsonObject) {
        super.init(jsonObject);
        Object ob_name = jsonObject.get(NAME);
        Object ob_leagueid = jsonObject.get(LEAGUEID);
        Object ob_description = jsonObject.get(DESCRIPTION);
        Object ob_tournament_url = jsonObject.get(TOURNAMENT_URL);
        Object ob_itemdef = jsonObject.get(ITEMDEF);
        this.setName(ob_name.toString());
        this.setLeagueid(Integer.parseInt(ob_leagueid.toString()));
        this.setDescription(ob_description.toString());
        this.setTournament_url(ob_tournament_url.toString());
        this.setItemdef(Integer.parseInt(ob_itemdef.toString()));
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

    public String get(int index) {
        return jsonArray.get(index).toString();
    }
}
