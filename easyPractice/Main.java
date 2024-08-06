/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;


public class Main
{
    public static void main(String[] args){
        findDistance(1,1,2,4,3,6);
    }
    private static void findDistance(int x1, int y1, int x2, int y2, int x3, int y3){
        int firstDist=(int) Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
        System.out.println(firstDist);
    }
    
	
}

/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main
{
	public static void main(String[] args) {
	    int[] arr = {1,0,0,0,0};
		System.out.println(switchesPressed(arr));
	}
	private static int switchesPressed(int[] arr){
	    int count = 0;
	    for(int i=0; i < arr.length; i++){
	        if(arr[i]==0){
	            count++;
	            for(int j=i; j< arr.length; j++){
	                if(arr[j]==0){
	                    arr[j]=1;
	                    continue;
	                }
	                if(arr[j]==1){
	                    arr[j]=0;
	                    continue;
	                }
	            }
	        }
	    }
	    return count;
	}
}
	
public static String replaceChar(String str, char c1, char c2){
	    StringBuilder s = new StringBuilder(str);
	    if(str.length() ==0 ){
	        return null;
	    }
	    for(int i=0; i< str.length(); i++){
	        if(s.charAt(i)==c1){
	            s.setCharAt(i, c2);
	            continue;
	        }if(str.charAt(i)==c2){
	            s.setCharAt(i, c1);
	            continue;
	        }
	       // s.append(str.charAt(i));
	    }
	    return s.toString();
	}

private static int operaionChoices(int a, int b, int c){
	    if(c==1){
	        return a+b;
	    }
	    if(c==2){
	        return a-b;
	    }
	    if(c==3){
	        return a*b;
	    }
	    if(c==1){
	        return a/b;
	    }
	    return -1;
	}


	public static void main(String[] args) {
	    System.out.println(pal(100, 200));
	}
	public static List<Integer> pal(int ll, int ul){
	    List<Integer> list = new ArrayList<>();
	    for(int i=ll; i<=ul; i++){
	        if(isPalindrome(i)){
	            list.add(i);
	        }
	    }
	    return list;
	}
	
	private static boolean isPalindrome(int i){
	    String str = String.valueOf(i);
	    StringBuilder s = new StringBuilder(str);
	    return str.equals(s.reverse().toString());
	}
	

	