const dr = [-1 ,1, 0, 0];
const dc = [0, 0, -1, 1];
let answer = 0;
let deleteArray = new Array();
function solution(storage, requests) {
    let r = storage.length;
    let c = storage[0].length;
    let arr = Array.from(Array(r), () => Array(c).fill(null));
    const alpha = new Set();
    
    for(let i = 0; i < r; i++){
        for(let j = 0; j < c; j++){
            arr[i][j] = storage[i].charAt(j);          
            //셋에 추가해서 알파벳 저장(중복X)
            if(!alpha.has(arr[i][j])){
                alpha.add(arr[i][j]);
            }
        }
    }
    
    requests.forEach((request) => {
        deleteArray = [];
        //크레인
        if(request.length === 2){
            let com = request.charAt(0);
            useCrain(com, alpha, arr, r, c);
        }
        //지게차
        else {
            for(let i = 0; i < r; i++){
                for(let j = 0; j < c; j++){
                    //지게차 수행
                    if(request === arr[i][j]){
                        let check = useForkLift(arr, i, j, r, c);
                        if(check){
                            deleteArray.push([i, j]);
                        }
                    }       
                }
            }
            //삭제배열을 한꺼번에 처리한다.
            deleteArray.forEach((element) => {
                arr[element[0]][element[1]] = "0";
                answer++;
            });
        }
    })
    
    return (r * c) - answer;
}

//크레인 사용(모든 요소 다꺼내기)
function useCrain(command, alphaSet, arr, r, c){
    //해당 요소가 set에 아직 있는 경우에만 수행
    if(alphaSet.has(command)){
        for(let i = 0; i < r; i++){
            for(let j = 0; j < c; j++){
                if(command === arr[i][j]){
                    arr[i][j] = "0";
                    answer++;
                }
            }
        }
        alphaSet.delete(command);
    }
}

//지게차 사용(외부와 맞닿은 부분만 꺼내기 가능) bfs로 탐색
function useForkLift(arr, i, j, r, c){
    let visited = Array.from(Array(r), () => Array(c).fill(false));
    const queue = [[i, j]];
    visited[i][j] = true;
    
    while(queue.length > 0){
        const [curR, curC] = queue.shift();
        
        //순환
        for(let d = 0; d < 4; d++){
            let nr = curR + dr[d];
            let nc = curC + dc[d];
            
            //경계를 벗어날 수 있다면 바로 return(꺼낼 수 있음)
            if(nr < 0 || nr >= r || nc < 0 || nc >= c){
                return true;
            }
            
            //경계를 벗어나지 않고 "0"이라면 한번 더 수행한다.
            if(nr >= 0 && nr < r && nc >= 0 && nc < c && arr[nr][nc] === "0" && !visited[nr][nc]){
                visited[nr][nc] = true;
                queue.push([nr, nc]);
            }   
        }
    }
    
    return false;
}