function solution(absolutes, signs) {
    let answer = 0;
    
    absolutes.forEach((value, idx) => {
        //true이면 양수
        if(signs[idx]){
            answer += value;
        }
        
        //아니면 음수
        else{
            answer -= value;
        }
    })
    
    return answer;
}