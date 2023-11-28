public class Items {
    public String ID;
    public String type;
    public Items(String id, String type){
        this.ID=id;
        this.type=type;
    }
    public String toString() {
        return this.ID+" "+this.type ;
    }
}
