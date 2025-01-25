function solution(h1, m1, s1, h2, m2, s2) {
    var answer = 0;
    //시간 초로 변환
    let start = h1 * 3600 + m1 * 60 + s1;
    let end = h2 * 3600 + m2 * 60 + s2;
    
    if(start === 0 || start === 12 * 3600){
        answer++;
    }
    
    while(start < end){
        const hAngle = start / 120 % 360;
        const mAngle = start / 10 % 360;
        const sAngle = start * 6 % 360;
        
        const nextHAngle = checkOnTime((start + 1) / 120 % 360);
        const nextMAngle = checkOnTime((start + 1) / 10 % 360);
        const nextSAngle = checkOnTime((start + 1) * 6 % 360);
        
        if(sAngle < hAngle && nextHAngle <= nextSAngle){
            answer++;
        }
        if(sAngle < mAngle && nextMAngle <= nextSAngle){
            answer++;
        }
        if(nextSAngle === nextMAngle && nextSAngle === nextHAngle){
            answer--;
        }
        
        start++;
        
    }
    return answer;
}
    
function checkOnTime(x){
    if(x === 0){
        return 360;
    }
    else return x;
}
    