import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Methods {
    public static void sortingStack(ArrayList<String> partArrayList,Stack<Items> itemsStack,ArrayList<Stack<Items>> stackArrayList){
        for (String s : partArrayList) {
            Stack<Items> itemsStack1 = new Stack<>();
            for (int k = 0; k < itemsStack.size(); k++) {
                if (itemsStack.print(itemsStack.size() - 1 - k).type.equals(s)) {
                    itemsStack1.push(itemsStack.print(itemsStack.size() - 1 - k));
                }
            }
            stackArrayList.add(itemsStack1);
        }
    }
    public static void task(String taskLine,ArrayList<String> partArrayList,ArrayList<Stack<Items>> stackArrayList, Queue<Token> tokenBox){
        String[] splited = taskLine.split("\\s+");
        if (splited[0].equals("BUY")) {
            for (int k = 0; k < splited.length - 1; k++) {
                String[] splited1 = splited[k + 1].split(",");
                String type = splited1[0];
                int number = Integer.parseInt(splited1[1]);
                int counter = 0;
                int counter1 = 0;
                while (counter < number) {
                    int stackNumber = partArrayList.indexOf(type);
                    stackArrayList.get(stackNumber).pop();
                    counter++;
                }
                while (counter1 < number) {
                    for (int t = 0; t < tokenBox.size(); t++) {
                        if (tokenBox.print(t).type.equals(type)) {
                            Token token1 = tokenBox.print(t);
                            if (token1.number - number > 0) {
                                token1.number -= number;
                                counter1 += number;
                                for (int g = 0; g < tokenBox.size(); g++) {
                                    if (token1.number <= tokenBox.print(g).number) {
                                        Token.sortedPush(tokenBox, token1, g);
                                        break;
                                    }
                                }
                            } else {
                                counter1 += token1.number;
                                token1.number = 0;
                            }
                            tokenBox.dequeue(t);
                            break;
                        }
                    }
                }
            }
        } else if (splited[0].equals("PUT")) {
            for (int k = 0; k < splited.length - 1; k++) {
                String[] splited1 = splited[k + 1].split(",");
                String type = splited1[0];
                int stackNumber = partArrayList.indexOf(type);
                for (int j = 0; j < splited1.length - 1; j++) {
                    Items itemObject = new Items(splited1[j + 1], type);
                    stackArrayList.get(stackNumber).push(itemObject);
                }
            }
        }
    }
    public static void write(FileWriter output, ArrayList<Stack<Items>> stackArrayList, ArrayList<String> partArrayList, Queue<Token> tokenBox) throws IOException {
        for (int k = 0; k < stackArrayList.size(); k++) {
            output.write(partArrayList.get(k) + ":\n");
            if (stackArrayList.get(k).size() > 0) {
                for (int j = 0; j < stackArrayList.get(k).size(); j++) {
                    output.write(stackArrayList.get(k).print(j).ID + "\n");
                }
            } else output.write("\n");
            output.write("---------------\n");
        }
        output.write("Token Box:\n");
        for (int x = 0; x < tokenBox.size(); x++) {
            output.write(tokenBox.print(tokenBox.size() - x - 1) + "\n");
        }
    }
    public static void tokenBox(String tokenLine,Queue<Token> tokenBox){
        String[] splited = tokenLine.split("\\s+");
        Token tokenObject = new Token(splited[0], splited[1], Integer.parseInt(splited[2]));
        if (!tokenBox.isEmpty()) {

            if (tokenObject.number <= tokenBox.print(0).number) {
                Token.sortedPush(tokenBox, tokenObject, 0);
            } else {
                tokenBox.enqueue(tokenObject);
            }

        } else tokenBox.enqueue(tokenObject);
    }
}
