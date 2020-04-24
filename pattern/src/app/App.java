package app;

public class App {
    public static void main(String[] args) throws Exception {
        transferNumToDollar("-2256");
    }

    public static String transferNumToDollar(String number) {
        String dollar = "";
        Integer integer = 0;
        Boolean negtive = false;
        Boolean decimal = true;
        Integer pointpos = -1;
        pointpos = number.indexOf(".");
        if (pointpos == -1) {
            decimal = false;
        }
        if (number.substring(0, 1).equalsIgnoreCase("-")) {
            negtive = true;
            number = number.substring(1);    
        }
        if (decimal) {
            integer = Integer.parseInt(number.substring(0, pointpos - 1)); 
            if (pointpos + 2 <= number.length()) {
                number = number.substring(0, pointpos + 2);              
            }
            if (number.substring(pointpos).length() == 1) {
                number = number + "0";
            }    
        } else {
            integer = Integer.parseInt(number); 
        } 
        for (int i = integer.toString().length(); i > 3 ; i = i - 3) {
            number = number.substring(0, i - 3) + "," + number.substring(i - 3, number.length());
        }    
        dollar = "$" + number;
        if (negtive) {
            dollar = "(" + dollar + ")";
        }
        System.out.println(dollar);
        return dollar;
    }
}