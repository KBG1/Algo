function solution(diffs, times, limit) {
    let answer = 0;
    let left = 1;
    let right = 100000;
    
    while(left <= right){
        //mid를 레벨로
        let level = Math.floor((left + right) / 2);
        let totalTime = 0;
        let check = false;
        
        for(let i = 0; i < diffs.length; i++){
            if(diffs[i] <= level){
                totalTime += times[i];
            }
            else {
                totalTime += ((diffs[i] - level) * (times[i] + (i > 0 ? times[i - 1] : 0))) + times[i];
            }
            //범위넘어가면 가지치기
            if(totalTime > limit){
                check = true;
                break;
            }
        }
        
        if(!check){
            answer = level;
            right = level - 1;
        }
        else {
            left = level + 1;
        }
    }
    
    return answer;
}