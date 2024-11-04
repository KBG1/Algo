function solution(bandage, maxHealth, attacks) {
    //bandage[0] === 시전시간 bandage[1] === 초당 회복량 bandage[2] === 추가 회복량
    //health === 전체체력
    //attacks[n][0] === 공격 시간 attacks[n][1] === 피해량

    //최대 공격 시간...?
    const maxTime = attacks[attacks.length - 1][0];
    let attackIdx = 0;
    let bandageCount = 0;
    let health = maxHealth;

    for(let i = 1; i <= maxTime; i++){

        //공격 시간이랑, i랑 같으면 피해를 받고, 다음 시간으로 증가
        if(i === attacks[attackIdx][0]){
            health -= attacks[attackIdx][1];
            attackIdx++;
            //0으로 초기화
            bandageCount = 0;
            continue;
        }

        //아니라면 회복, 이 때 최대 체력이면 회복 안함
        if(health === maxHealth){
            continue;
        }

        health += bandage[1];
        bandageCount++;

        //붕대감기 전부 성공시 바로 추가회복 갈기고 카운트 초기화
        if(bandageCount === bandage[0]){
            health += bandage[2];
            bandageCount = 0;
        }

        //최대체력을 넘으면 안돼
        if( health > maxHealth ){
            health = maxHealth;
        }

        //만약에 애초에 죽었다면, 여기 반복할 필요가 없음
        if(health <= 0 ){
            break;
        }
    }

    if(health <= 0){
        return -1;
    }
    else {
        return health;
    }

}