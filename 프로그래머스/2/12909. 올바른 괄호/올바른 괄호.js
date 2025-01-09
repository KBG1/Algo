function solution(s){
    const array = s.split("");
    
    //닫는괄호부터 시작이면 바로 false
    if(array[0] === ')') return false;
    
    //스택으로 활용할 배열
    let stack = [];
    let idx = 0;
    
    array.forEach((e) => {
        //여는 괄호면 삽입
        if(e === '('){
            stack[idx++] = e;
        }
        else if(e === ')'){
            //길이가 0이라면 옳지않은 괄호이므로
            if(idx <= 0){
                return false;
            }
            else {
                //닫는 괄호면 idx 뒤로
                stack[--idx];
            }
        }
    })
    
    //반복문이 끝나고, stack의 idx가 0이면 옳은 괄호
    if(idx === 0) return true;
    else return false;
}