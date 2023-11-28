public class Token {
    String ID;
    String type;
    Integer number;
    public Token(){}
    public Token(String ID, String type,Integer number){
        this.ID=ID;
        this.type=type;
        this.number=number;
    }
    public String toString() {
        return this.ID+" "+this.type+" "+this.number ;
    }
    public static void sortedPush(Queue<Token> tokenBox, Token tokenObject, int q) {
        for (int x = q; x < tokenBox.size(); x++) {
            if (x != tokenBox.size() - 1) {
                if (tokenObject.number > tokenBox.print(x + 1).number) {
                    tokenBox.enqueueIndex(tokenObject, x + 1);
                    break;
                }
            } else if (x == tokenBox.size() - 1) {
                tokenBox.enqueue(tokenObject);
                break;
            }
        }
    }
}
