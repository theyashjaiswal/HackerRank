/* Problem link - https://www.hackerrank.com/challenges/balanced-brackets/problem
*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        // Write your code here
        Stack<String> stack = new Stack<String>();
        boolean flag = true;
        // System.out.println(s);
        for(char c: s.toCharArray()){
            // System.out.println(c);
            String temp = Character.toString(c);
            if(temp.equals("{")||temp.equals("[")||temp.equals("(")){
                stack.push(temp);
            }
            else if(temp.equals("}")||temp.equals("]")||temp.equals(")")){
                if(!stack.empty() && stack.peek().equals("{") && temp.equals("}")){
                    stack.pop();
                }
                else if( !stack.empty() && stack.peek().equals("[") && temp.equals("]")){
                    stack.pop();
                }
                else if( !stack.empty() && stack.peek().equals("(") && temp.equals(")")){
                    stack.pop();
                }
                else{
                    flag = false;
                }

            }
        }

        // String s1 = stack.peek();
        // System.out.println(s1);
        if(!flag){
            return "NO";
        }
        if(s.length()>1){
            if(stack.empty()){
                return "YES";
            }
            else{
                return "NO";
            }
        }
        else{
            return "NO";
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
