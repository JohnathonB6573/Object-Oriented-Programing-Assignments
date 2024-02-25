import java.util.Scanner;

public class MyString {
    
    private char[] char_arr;
    public int length;

    public void setChar(int index, char c){//Set c at fixed position index
        char_arr[index] = c;
    }

    public char charAt(int index){ // Returns the character at a particular index
        return char_arr[index];
    }

    public String getString(){//Returns String
        return new String(char_arr);
    }

    public int getLength(){//Returns Length
        return length;
    }

    public char[] getCArr(){
        return char_arr;
    }

    public MyString(){// Default Constructor
        this.char_arr = new char[0];
        this.length = 0;
    }

    public MyString(char[]name){
        this.char_arr = name.clone();//Saves value
        this.length = name.length;
    }
    
    public MyString(MyString string){
        this.char_arr = string.char_arr.clone();//Saves string as char arr
        this.length = string.length;
    }

    public MyString(String str){
        this.char_arr = str.toCharArray();//Converts to char arr
        this.length = str.length();
    }

    public MyString(int x){
        String xString = Integer.toString(x);//Convert to string
        this.char_arr = xString.toCharArray();//Convert to char arr
        this.length = xString.length();
    }

    public MyString(long x){
        String xString = Long.toString(x);//Convert to string
        this.char_arr = xString.toCharArray();//Convert to char arr
        this.length = xString.length();
    }

    public MyString(float x){
        String xString = Float.toString(x);//Convert to string
        this.char_arr = xString.toCharArray();//Convert to char arr
        this.length = xString.length();
    }

    public MyString(double x){
        String xString = Double.toString(x);//Convert to string
        this.char_arr = xString.toCharArray();//Convert to char arr
        this.length = xString.length();
    }

    public MyString(char[] cArr, int firstpos, int terminalpos){//String from first to terminal
        int len = terminalpos - firstpos;
        this.char_arr = new char[len];
        for (int i = 0; i < len; i++) {
            this.char_arr[i] = cArr[firstpos + i];
        }
        this.length = len;
    }

    MyString concat(MyString s1){//Concatenates MyString s to current object 
        String s3 = this.getString() + s1.getString();
        this.char_arr = s3.toCharArray();
        this.length = s3.length();
        
        return this;
    }

    boolean contains(MyString s){//Returns true if s exists in the Object  
        String Test = getString();
        if(Test.toLowerCase().contains(s.getString().toLowerCase())){
            return true;
        }
        else{
             return false;
        }
    }

     MyString subString(int start, int end) {//makes a new string that is the certain length
        int len = end - start;
        char[] s1 = getCArr(); 
        this.char_arr = new char[len];
        for (int i = 0; i < len; i++) {
            this.char_arr[i] = s1[start + i];
        }
        this.length = len;
        return this;
    }

    static boolean contentEquals(MyString s1, MyString s2) {
        if (s1.getString().equals(s2.getString())) {
            return true;//strings are equal
        } else {
            return false;//strings are not equal
        }
    }

    boolean contentEquals(MyString s) {
        if(this.getString().equals(s.getString())){
            return true;//strings are equal
        } else {
            return false;//strings are not equal
        }
    }

    MyString toUpper() {
        for(int i = 0; i < this.getLength(); i++){//loops the length converting to uppercase
            this.char_arr[i] = Character.toUpperCase(char_arr[i]); 
        }
        return this;
    }

    static MyString concat(MyString s1, MyString s2) {// adds s2 to s1
        return s1.concat(s2);
    }

    static MyString concat(MyString s1, char[] chr) {//adds chr to s1
        MyString s2 = new MyString(chr);
        return s1.concat(s2);
    }

    MyString concat(char[] chr) { //adds chr to the string
        String s2 = this.getString() + chr.toString();
        MyString test = new MyString(s2);
        return test;
    }
    ///////////////////////////////////////////////////////////////////////
   // static MyString toUpper(MyString s) { //converts string s to uppercase;
    //find s in string, capitalize, return
   // int index = .indexOf(s);
    //    for (int i = 0; i < s.length; i++) 
      //  {
      //      nChar_Arr[i]=Character.toUpperCase(s.char_arr[i]);
      //  }
      //  String newString = s.replace(s,s.toUpperCase());
      //  return new MyString(nChar_Arr);
   // }

    MyString toLower(){//converts uppercae to lowercse
        char[] nChar_Arr = new char[this.length];
        for (int i = 0; i < this.length; i++) 
        {
            nChar_Arr[i]=Character.toLowerCase(this.char_arr[i]);
        }
        return new MyString(nChar_Arr);
    }
    ///////////////////////////////////////////////////////////////////////
   // static MyString toLower(MyString s){//converts s from uppercase to lowercase
      //  char[] nChar_Arr = new char[s.length];
       // for (int i = 0; i < s.length; i++) 
       // {
      //      nChar_Arr[i]=Character.toLowerCase(s.char_arr[i]);
     //   }
      //  return new MyString(nChar_Arr);
   // }

    boolean startsWith(MyString s) {//returns true if starts with s 
        for(int i = 0; i < s.length; i++){
            if (this.char_arr[i] != s.char_arr[i]) {
                return false;
            }
        }
        return true;      
    }

    boolean endWith(MyString s) {//returns true if ends with s
        int difference = this.length - s.length;
        for(int i = 0; i < s.length; i++){
            if (this.char_arr[i+difference] != s.char_arr[i]) {
                return false;
            }
        }
        if(this.char_arr[this.length-1] != s.char_arr[s.length-1]){
            return false;//needs work
        }
        else{
            return true;
        }
    }
   
    MyString copy() {//creates creates a copy of the object and returns it
        char[] newChr = new char[this.length];
        for (int i = 0; i < this.length; i++) {
            newChr[i] = this.char_arr[i];
        }
        return new MyString(newChr);
    }

    boolean isEmpty() {//returns true if empty or length = 0
        if(this.length == 0){
            return true;
        }
        else{
            return false;
        }
    }

    int length(){//return length
        return this.length;
    }
    ///////////////////////////////////////////////////////////////////////
   // MyString replace(MyString s1, MyString s2) {//Replace all occurrences of s1 with s2
        //look for s1 in string, save variables, replace 

       // String str = new String(char_arr);
        //int index = str.indexOf(s1.getString());
       // for (int i = 0; i; i++) {
        //    newChr[i] = this.char_arr[i];
       // }
    //}
    

    MyString replace(int start, int end, MyString s) {//Replace contents in between start and end with s
        for(int i=start;i<=end || i<= this.length; i++){
            this.char_arr[i]=s.char_arr[i];
        }
        return this;
    }

    MyString trim() {//Removes the leading and trailing white spaces 
        int left = 0, right = length - 1;
        while (left <= right && Character.isWhitespace(char_arr[left])) {
            left++;
        }
        while (right >= left && Character.isWhitespace(char_arr[right])) {
            right--;
        }//decreases size based on the whitespaces
        int Len = right-left+1;
        char[] newChr = new char[Len];//new array the correct size
        for(int i=left;i<=right;i++)
        {
            newChr[i]=this.char_arr[i];//new string creation
        }
        return new MyString(newChr);//return new string
    }
    public static void main(String[] args) {

        //Tests for each default constructor
       /* MyString TEST = new MyString();
        System.out.println("MyString(): " + TEST.getLength() + " " + TEST.getString());
        
        TEST = new MyString("HELLO");
        System.out.println("MyString(String): " + TEST.getLength() + " " + TEST.getString());

        TEST = new MyString(432);
        System.out.println("MyString(Int): " + TEST.getLength() + " " + TEST.getString());

        TEST = new MyString((double)(585));
        System.out.println("MyString(Double): " + TEST.getLength() + " " + TEST.getString());

        char[] cArr = {'h', 'e', 'l', 'l', 'o'};
        TEST = new MyString(cArr);
        System.out.println("MyString(Char[]): " + TEST.getLength() + " " + TEST.getString());

        TEST = new MyString(new MyString());
        System.out.println("MyString(MyString): " + TEST.getLength() + " " + TEST.getString());

        TEST = new MyString((long)(873));
        System.out.println("MyString(Long): " + TEST.getLength() + " " + TEST.getString());

        TEST = new MyString((float)(921));
        System.out.println("MyString(Float): " + TEST.getLength() + " " + TEST.getString());
    
        TEST = new MyString(cArr, 0, 3);
        System.out.println("MyString(Char[], X1, X2): " + TEST.getLength() + " " + TEST.getString());
        
        System.out.println("charAt(Index): " + TEST.charAt(2));
        TEST = new MyString("Hello");
        TEST.concat(new MyString("GOODBYE"));
        System.out.println("concat(Mystring): " + TEST.getString());
        System.out.println("Boolean Contains : " + TEST.contains(new MyString("he")));
        TEST.subString(0,2);
        System.out.println("Sub String : " + TEST.getString());
         */
    }
}