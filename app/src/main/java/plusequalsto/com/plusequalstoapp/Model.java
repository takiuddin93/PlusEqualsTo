package plusequalsto.com.plusequalstoapp;

public class Model {
    public static final int IMAGE_TYPE = 1;
    public String title, author, date, categories, Image;
    public int type;

    public Model(int mtype, String mtitle, String mauthor, String mdate, String mcategories, String image) {
        this.type = mtype;
        this.title = mtitle;
        this.author = mauthor;
        this.date = mdate;
        this.categories = mcategories;
        this.Image = image;
    }
}
