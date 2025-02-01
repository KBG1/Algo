class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        boolean check = false;
        boolean big = false;
        
        //지폐 접기
        while(!check){
            big = false;
            
            int bigBill = Math.max(bill[0], bill[1]);
            int smallBill = Math.min(bill[0], bill[1]);
            int bigWallet = Math.max(wallet[0], wallet[1]);
            int smallWallet = Math.min(wallet[0], wallet[1]);
            
            if(bigBill > bigWallet || smallBill > smallWallet){
                big = true;
            }
            
            if(big){
                if(bill[0] > bill[1]){
                    bill[0] /= 2;
                }
                else {
                    bill[1] /= 2;
                }
                answer++;            
            }
            else {
                check = true;
            }
        }
        
        
        return answer;
    }
}