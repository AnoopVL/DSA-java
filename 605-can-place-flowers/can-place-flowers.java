class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int extraFlowers = n;
        for(int i = 0; i < flowerbed.length ; i++ ){
            if(flowerbed[i] == 0){
                boolean leftEmpty = (i ==0) || (flowerbed[i-1] ==0);
                boolean rightEmpty = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);
                if(leftEmpty && rightEmpty){
                    flowerbed[i]=1;
                    extraFlowers--;
                    if(extraFlowers==0){
                        return true;
                    }
                }
            }
        }
        return extraFlowers <= 0;
        // if(extraFlowers==0){
        //     return true;
        // }
        // else{
        //     return false;
        // }
    }
}
            // for(int j = 0; j<flowerbed.length; j++){
            //     if(j==0){
            //         if(flowerbed[j]==0 && flowerbed[j+1]==0 ){
            //         flowerbed[j]=1;
            //         n--;
            //         break;
            //     }
            //     if(j == flowerbed.length -1){
            //         if(flowerbed[j]==0 && flowerbed[j-1]==0 ){
            //         flowerbed[j]=1;
            //         n--;
            //         break;
            //     }
            //     }
            //     if(flowerbed[j]==0 && flowerbed[j-1]==0 && flowerbed[j+1]==0 ){
            //         flowerbed[j]=1;
            //         n--;
            //         break;
            //     }
            //     if(n == 0){
            //         break;
            //     }
            // }
        // }
        // if(n == 0){
        //     return true;
        // }
        // else{
        //     return false;
        // }

