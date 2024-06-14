class Solution {
    public String reverseVowels(String s) {
        StringBuilder str = new StringBuilder(s);
        StringBuilder vowel = new StringBuilder();

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(isVowel(ch)){
                vowel.append(ch);
                // str.charAt(i) = "_";
                str.setCharAt(i,'_');
            }
        }
        StringBuilder revVowel = new StringBuilder(vowel).reverse();

        int vowelIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '_') {
                str.setCharAt(i, revVowel.charAt(vowelIndex));
                vowelIndex++;
            }
        }

        // for(int i=0; i < revVowel.length(); i++){
        //     for(int j = 0; j < str.length(); j++){
        //         // char ch = str.charAt(j);
        //         if(str.charAt(j)=='_'){
        //             str.charAt(j) = revVowel.charAt(i);
        //             break;
        //         }
        //     }
        // }
        return str.toString();
    }

    public boolean isVowel(char ch){
        ch = Character.toLowerCase(ch); // Ensure case-insensitive comparison
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
        // if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
        //     return true;
        // }
        // else{
        //     return false;
        // }
    }
}