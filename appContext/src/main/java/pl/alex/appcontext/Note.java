package pl.alex.appcontext;

public class Note {
   static   final String TYPE_PUBLIC = "public";
    static final String TYPE_PRIVATE = "private";

    private String id;
    private String content;
    private String type;

    public Note(String id, String content, String type) {
        this.id = id;
        this.content = content;
        this.type = type;
    }

    public String getTYPE_PUBLIC() {
        return TYPE_PUBLIC;
    }

    public String getTYPE_PRIVATE() {
        return TYPE_PRIVATE;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getType() {
        return type;
    }
}
