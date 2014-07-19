package variablenotation;
import java.util.Scanner;

/**
 *
 * @author todyerutz @ plainintricacy.wordpress.com
 */
public class VariableNotation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter notation format:");
        String q = in.nextLine();
        System.out.println("Please enter your input:");
        String input = in.nextLine();
        in.close();
        
        switch(q){
            case("0"):
                camel_case(input);
            break;
            case("1"):
                snake_case(input);
            break;
            case("2"):
                cap_snake(input);
            break;
            case("0 0"):
                if(camel_case_check(input)){
                    System.out.println(input);
                }
                else{
                    System.out.println("INVALID NOTATION FORMAT");
                }
            break;
            case("1 1"):
                if(snake_case_check(input)){
                    System.out.println(input);
                }
                else{
                    System.out.println("INVALID NOTATION FORMAT");
                }
            break;
            case("2 2"):
                if(cap_snake_check(input)){
                    System.out.println(input);
                }
                else{
                    System.out.println("INVALID NOTATION FORMAT");
                }
            break;
            case("0 1"):
                if(camel_case_check(input)){
                    String Z1 = input.substring(0, 1);
                    Z1 = Z1.toLowerCase();
                    for(int i=1;i<input.length();i++){
                        if(Character.isUpperCase(input.charAt(i))){
                            Z1 += "_";
                            Z1 += Character.toLowerCase(input.charAt(i));
                        }else{
                            Z1 += input.charAt(i);
                        }
                    }
                    System.out.println(Z1);
                }
                else{
                    System.out.println("INVALID NOTATION FORMAT");
                }
            break;
            case("0 2"):
                if(camel_case_check(input)){
                    String Z2 = input.substring(0, 1);
                    Z2 = Z2.toUpperCase();
                    for(int i=1;i<input.length();i++){
                        if(Character.isUpperCase(input.charAt(i))){
                            Z2 += "_";
                            Z2 += input.charAt(i);
                        }else{
                            Z2 += Character.toUpperCase(input.charAt(i));
                        }
                    }
                    System.out.println(Z2);
            }
                else{
                    System.out.println("INVALID NOTATION FORMAT");
                }
            break;
            case("1 0"):
                if(snake_case_check(input)){
                    input = input.replace("_", " ");
                    camel_case(input);
                }
                else{
                    System.out.println("INVALID NOTATION FORMAT");
                }
            break;
            case("1 2"):
                if(snake_case_check(input)){
                    System.out.println(input.toUpperCase());
                }
                else{
                    System.out.println("INVALID NOTATION FORMAT");
                }
            break;
            case("2 1"):
                if(cap_snake_check(input)){
                    System.out.println(input.toLowerCase());
                }
                else{
                    System.out.println("INVALID NOTATION FORMAT");
                }
            break;
            case("2 0"):
                if(cap_snake_check(input)){
                    input = input.toLowerCase();
                    input = input.replace("_", " ");
                    camel_case(input);
                }
                else{
                    System.out.println("INVALID NOTATION FORMAT");
                }
            break;
    }
    }   
    public static void camel_case(String x){
        
        if(x!=null){
            String[] parts;
            String output;
            if(x.contains(" ")){
                parts = x.split(" ");
                output = parts[0];
                for(int i=1; i<parts.length; i++){
                    output += parts[i].substring(0, 1).toUpperCase();
                    output += parts[i].substring(1);
                }
            System.out.println(output);
            }else{
                System.out.println("No valid input found (NO_SPACE)");
            }
        }else{
            System.out.println("No valid input found (NULL INPUT");
        }
    }
    
    public static void snake_case(String x){
        
        if(x!=null){
            x = x.toLowerCase();
            if(x.contains(" ")){
                x = x.replace(" ", "_");
            }
            System.out.println(x);
        }
    }
    
    public static void cap_snake(String x){
        if(x!=null){
            x = x.toUpperCase();
            if(x.contains(" ")){
                x = x.replace(" ", "_");
            }
            System.out.println(x);
        }
    }
    
    public static boolean camel_case_check(String x){
        if(x.contains(" ")==false || x.contains("_")==false){
            for(int i=0; i<x.length(); i++){
                if(Character.isUpperCase(x.charAt(i))){
                    return true;
                }
            }
        }
            return false;
}
    
    public static boolean snake_case_check(String x){
    
        if(x.contains(" ")){
            return false;
        }
        if(x.contains("_")){
        for(int i=0; i<x.length(); i++){
            if(Character.isUpperCase(x.charAt(i))){
                return false;
            }
        }
        }else{
            return false;
        }
        return true;
    }
    
    public static boolean cap_snake_check(String x){
        String out = x;
        if(out.contains(" ")){
            return false;
        }
        if(x.contains("_")){
            out.replace("_", "A");
        }
        for(int i=0;i<out.length();i++)
            if(Character.isLowerCase(out.charAt(i))){
                return false;
            }
        return true;
    }
}
