import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    private double[] numarr;
    private double result;

    //Default Constructor
    Calculator (){
        this.numarr = new double[]{0,0};
        this.result = 0.0;
    }

    public Calculator(ArrayList<Double> input){
        for(int i = 0; i < input.size(); i++){
            this.numarr[i] = input.get(i);
        }
        this.result = 0.0;
    }

    //Set Methods
    public void set_Numarr(double[] numarr){
        this.numarr = numarr;
    }

    public void set_Result(double result){
        this.result = result;
    }

    //Get methods
    public double get_Result(){
        return result;
    }

    public double[] get_Numarr(){
        return numarr;
    }

    public double get_Numarr_val(int x){
        return numarr[x];
    }

    public double add(int count){
        double[] arr = get_Nummar_val;
        double j = arr[0];
        for(int i = 1; i < count; i++){
            j += arr[i];
        }
        System.out.println("\nThe total is " + j);
        return j;
    }

    public double sub(int count){
        double j = nummar[0];
        for(int i = 1; i < count; i++){
            j -= nummar[i];
        }
        System.out.println("\nThe total is " + j);
        return j;
    }

    public double div(int count){
        double j = get_Nummar_val(0);
        for(int i = 1; i < count; i++){
            j =+ get_Nummar_val(i);
        }
        System.out.println("\nThe total is " + j);
        return j;
    }

    public double mul(int count){
        double j = nummar[0];
        for(int i = 1; i < count; i++){
            j *= nummar[i];
        }
        System.out.println("\nThe total is " + j);
        return j;
    }

    //Main
    public static void main(String[] args){
        //Initialization
        ArrayList<Double> user_input = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean do_input = true, do_extra_input = true, do_calculation = true;

        while(do_calculation){

        //Getting user input
        System.out.print("Welcome to the Calculator!\nPlease enter two numbers for the calculation\n");
        while(do_input) {

            user_input.add(sc.nextDouble());
            user_input.add(sc.nextDouble());

            while(do_extra_input){
                System.out.print("Please enter more numbers to be added to the calculation.\nIf you don't want to add anymore type 'no'\n");
                if (sc.next() == "no"){
                    user_input.remove("no");
                    do_input = false;
                    do_extra_input = false;
                }
                else {
                    user_input.add(sc.nextDouble());
                }
            }
        }
      
        Calculator calc = new Calculator(user_input);
        
        //Asking the user which operation they would like to use
        System.out.print("\nWhich would you like to do?\nAddition(+)\nSubtraction(-)\nMultiplication(*)\nDivision(/)");
        String user_case = sc.nextLine();
        int count = user_input.size();

        //Execution of Math and Printing the results
        switch(user_case){
            case "+":
                calc.add(count);
                break;

            case "-":
                calc.sub(count);
                break;
            
            case "/":
                calc.div(count);
                break;
                
            case "*":
                calc.mul(count);
                break;
        }
        System.out.println("\nWould you like to use the calculator again?\nIf not type 'no'");
        if (sc.next() == "no"){
            do_calculation = false;
        }
    }
    }
}
