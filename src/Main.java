import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        FileWriter output = new FileWriter(args[4]);
        FileReader token = new FileReader(args[2]);
        BufferedReader bf2 = new BufferedReader(token);
        String tokenLine = bf2.readLine();
        FileReader part = new FileReader(args[0]);
        BufferedReader bf = new BufferedReader(part);
        String parts = bf.readLine();
        FileReader item = new FileReader(args[1]);
        BufferedReader bf1 = new BufferedReader(item);
        String items = bf1.readLine();
        Stack<Items> itemsStack = new Stack<>();
        Queue<Token> tokenBox = new Queue<>();
        ArrayList<String> partArrayList = new ArrayList<>();
        ArrayList<Stack<Items>> stackArrayList = new ArrayList<>();
        FileReader task = new FileReader(args[3]);
        BufferedReader bf3 = new BufferedReader(task);
        String taskLine = bf3.readLine();
        while (tokenLine != null) {
            Methods.tokenBox(tokenLine,tokenBox);
            tokenLine = bf2.readLine();
        }
        while (parts != null) {
            partArrayList.add(parts);
            parts = bf.readLine();
        }
        while (items != null) {
            String[] splited = items.split("\\s+");
            Items itemObject = new Items(splited[0], splited[1]);
            itemsStack.push(itemObject);
            items = bf1.readLine();
        }
        Methods.sortingStack(partArrayList,itemsStack,stackArrayList);
        while (taskLine != null) {
            Methods.task(taskLine,partArrayList,stackArrayList,tokenBox);
            taskLine = bf3.readLine();
        }
        Methods.write(output,stackArrayList,partArrayList,tokenBox);
        output.close();
    }
}

