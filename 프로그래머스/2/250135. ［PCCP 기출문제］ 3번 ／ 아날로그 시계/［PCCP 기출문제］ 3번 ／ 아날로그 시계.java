class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        //시간을 초로 변환하기
        double start = h1 * 3600 + m1 * 60 + s1;
        double end = h2 * 3600 + m2 * 60 + s2;
        
        //0시이거나, 12시이거나
        if(start == 0 || start == 12 * 3600){
            answer++;
        }
        
        while(start < end){
            //각도로 시간 계산하기
            double hAngle = start / 120 % 360 ;
            double mAngle = start / 10 % 360;
            double sAngle = start * 6 % 360;
            
            //다음 각도 보기
            double nextHAngle = checkOnTime((start + 1) / 120 % 360);
            double nextMAngle = checkOnTime((start + 1) / 10 % 360);
            double nextSAngle = checkOnTime((start + 1) * 6 % 360);
            
            //시침과 초침이 마주치거나, 분침과 초침이 마주치거나.
            if(sAngle < hAngle && nextHAngle <= nextSAngle){
                answer++;
            }
            if(sAngle < mAngle && nextMAngle <= nextSAngle){
                answer++;
            }
            //동시에 겹치는 경우 1번 빼주기
            if(nextSAngle == nextMAngle && nextSAngle == nextHAngle){
                answer--;
            }
            
            start++;
        }
        return answer;
    }
    
    public double checkOnTime(double x){
        if(x == 0){
            return 360;
        }
        else return x;
    }
}