function solution(n, w, num) {
    let answer = 1;
    let height = Math.ceil(n / w);
    let arr = new Array(height);
    let x = 0, y = 0;
    
    for (let i = 0; i < height; i++) {
        arr[i] = new Array(w).fill(0);
    }
    
    let idx = 0;
    let number = 1;
    //이제 아래부터 쌓아야한다...
    out: for(let i = height - 1; i >= 0; i--){
        //왼 -> 오
        if(idx % 2 === 0){
            for(let j = 0; j < w; j++){
                if(number > n){
                    break out;
                }
                if(num === number){
                    x = i;
                    y = j;
                }
                arr[i][j] = number;
                number++;
            }   
        }
        //오 -> 왼
        else {
            for(let j = w - 1; j >= 0; j--){
                if(number > n){
                    break out;
                }
                if(num === number){
                    x = i;
                    y = j;
                }
                arr[i][j] = number;
                number++;
                
            }
        }
        idx++;
    }
        
    //이제, 해당 값 위에 요소들이 몇개있는지 센다.
    for(let i = x - 1; i >= 0; i--){
        if(arr[i][y] !== 0){
            answer++;
        }
    }
  
    return answer;
}