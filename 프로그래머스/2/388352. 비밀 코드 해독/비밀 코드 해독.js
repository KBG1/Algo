function solution(n, q, ans) {
    let answer = 0;
    
    //5중 반복문을 통해, 계속 값을 비교해본다.
    for(let a = 1; a <= n - 4; a++){
        for(let b = a + 1; b <= n - 3; b++){
            for(let c = b + 1; c <= n - 2; c++){
                for(let d = c + 1; d <= n - 1; d++){
                    for(let e = d + 1; e <= n; e++){
                        let arr = [a, b, c, d, e];
                        let isValid = true;
                        for(let i = 0; i < q.length; i++){
                            let common = 0;
                            //num과 qNum을 순환하며, 비교, 같은것이 나오면 다음 숫자로 전환
                            for(const num of arr){
                                for(const qNum of q[i]){
                                    if(num == qNum){
                                        common++;
                                        break;
                                    }
                                };
                            };
                            
                            if(common !== ans[i]){
                                isValid = false;
                                break;
                            }
                        }
                        
                        if(isValid){
                            answer++;
                        }
                    }
                }
            }
        }
    }
    
    return answer;
}