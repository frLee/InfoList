import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Created by kk on 2017/5/9.
 */
public class GameItem extends Type {

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String COST = "cost";
    private static final String SECRET_SHOP = "secret_shop";
    private static final String SIDE_SHOP = "side_shop";
    private static final String RECIPE = "recipe";
    private static final String LOCALIZED_NAME = "localized_name";
    private static final int LISTCOUNT = 7;

    private static final String TABLENAME = "gameitems";

    private int id;
    private String name;
    private int cost;
    private int secret_shop;
    private int side_shop;
    private int recipe;
    private String localized_name;

    private JSONArray jsonArray = new JSONArray();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getSecret_shop() {
        return secret_shop;
    }

    public void setSecret_shop(int secret_shop) {
        this.secret_shop = secret_shop;
    }

    public int getSide_shop() {
        return side_shop;
    }

    public void setSide_shop(int side_shop) {
        this.side_shop = side_shop;
    }

    public int getRecipe() {
        return recipe;
    }

    public void setRecipe(int recipe) {
        this.recipe = recipe;
    }

    public String getLocalized_name() {
        return localized_name;
    }

    public void setLocalized_name(String localized_name) {
        this.localized_name = localized_name;
    }

    public GameItem() {
    }

    public GameItem(JSONObject jsonObject) {
        super(jsonObject);
        jsonArray.add(0, this.getId());
        jsonArray.add(1, this.getName());
        jsonArray.add(2, this.getCost());
        jsonArray.add(3, this.getSecret_shop());
        jsonArray.add(4, this.getSide_shop());
        jsonArray.add(5, this.getRecipe());
        jsonArray.add(6, this.getLocalized_name());
    }

    @Override
    public void init(JSONObject jsonObject) {
        super.init(jsonObject);
        Object ob_id = jsonObject.get(ID);
        Object ob_name = jsonObject.get(NAME);
        Object ob_cost = jsonObject.get(COST);
        Object ob_secret_shop = jsonObject.get(SECRET_SHOP);
        Object ob_side_shop = jsonObject.get(SIDE_SHOP);
        Object ob_recipe = jsonObject.get(RECIPE);
        Object ob_localized_name = jsonObject.get(LOCALIZED_NAME);
        this.setId(Integer.parseInt(ob_id.toString()));
        this.setName(ob_name.toString());
        this.setCost(Integer.parseInt(ob_cost.toString()));
        this.setSecret_shop(Integer.parseInt(ob_secret_shop.toString()));
        this.setSide_shop(Integer.parseInt(ob_side_shop.toString()));
        this.setRecipe(Integer.parseInt(ob_recipe.toString()));
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

    public String get(int index) {
        return jsonArray.get(index).toString();
    }
}
