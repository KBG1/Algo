function solution(info, n, m) {
    const N = info.length;
    const min = Number.MAX_SAFE_INTEGER;

    //a가 x를 훔치고 b가 y를 훔쳤을 때, 그때의 A 최소흔적을 저장하는 배열
    let prev = Array.from({length: n + 1}, () => Array(m + 1).fill(min));
    let cur = Array.from({length: n + 1}, () => Array(m + 1).fill(min));
    
    prev[0][0] = 0;
    
    for(let i = 0; i < N; i++){
        const [aItem, bItem] = info[i];
        
        for(let j = 0; j <= n; j++){
            cur[j].fill(min);
        }
        
        for(let a = 0; a < n; a++){
            for(let b = 0; b < m; b++){
                if(prev[a][b] === min) continue;
                
                //A가 훔치는 경우~
                let newA = Math.min(n, a + aItem);
                cur[newA][b] = Math.min(cur[newA][b], prev[a][b] + aItem);
                //B가 훔치는 경우~
                let newB = Math.min(m, b + bItem);
                cur[a][newB] = Math.min(cur[a][newB], prev[a][b] );
            }
        }
        //스왑
        [prev, cur] = [cur, prev];
    }
    
    let result = min;   
    for(let a = 0; a < n; a++){
        for(let b = 0; b < m; b++){
            if(prev[a][b] !== min){
                result = Math.min(result, prev[a][b]);                       }
        }
    }
    return result === min ? -1 : result;
}
