class Solution {
    public int solution(int[] stones, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        //순회하면서 최소, 최대 찾기
        for(int stone: stones){
            min = Math.min(min, stone);
            max = Math.max(max, stone);
        }
        
        //이분..탐색?
        while(min < max){
            //중간 값
            int mid = (min + max + 1) / 2;
            
            if(isPossible(stones, mid, k)){
                min = mid;
            }
            else {
                max = mid - 1;
            }
        }
        
        return max;
    }
    
    //해당 값의 돌로도 이동이 가능한지 테스트
    public boolean isPossible(int[] stones, int mid, int k){
        int count = 0;
        
        for(int stone: stones){
            if(stone - mid < 0){
                count++;
            }           
            else {
                count = 0;
            }
            
            //카운트가 넘어가면 못건너가므로...
            if(count >= k){
                return false;
            }
        }
        return true;
    }
}