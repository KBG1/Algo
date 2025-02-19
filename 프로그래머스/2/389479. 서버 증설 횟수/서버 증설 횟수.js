function solution(players, m, k) {
    let answer = 0;
    //서버 증설용...
    let server = [];
    //플레이어 수를 반복하면서, 서버를 판단하기
    players.forEach((player, idx) => {
        //서버가 부족하다면 추가해주어야한다.
        if(!checkServer(server.length, m, player)){
            //필요한 서버갯수 구하기
            let needServer = Math.floor(player / m) - server.length;
            //서버 유지시간은 5시간
            for(let i = 0; i < needServer; i++){
                server.push(idx + k);
                answer++;
            }
        }
              
        //시간이 다 된 서버는 삭제
        while(server.length !== 0 && server[0] === idx + 1){
            server.shift();
        }

    })

    
    return answer;
}

//시간대 이용자의 수가 적당한지 판단
function checkServer(n, m, k){
    if(k >= (n * m) && k < (n + 1) * m){
        return true;
    }
    return false;
}