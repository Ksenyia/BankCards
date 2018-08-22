package by.task.service.validator;

public class Validator {
	
	public static String validate(String cardNumber,int[] cardNumberLength){
		String results="";
		if(cardNumber.length()<cardNumberLength[0]||cardNumber.length()>cardNumberLength[1]){
			return "Error \n Wrong Length of Number" ;
		}
       int sum = 0;
       char[] digits = cardNumber.toCharArray();
       int length = digits.length;
       for (int i = 0; i < length; i++) {
           int digit = Character.getNumericValue(digits[length - i - 1]);
           if (length - i - 1 % 2 == 1) {
               digit *= 2;
           }
           sum += digit > 9 ? digit - 9 : digit;
       }
       if(sum% 10!=0){
    	   results += "Error \n Wrong number of card";
       }
	       
		return results;
	}

}
