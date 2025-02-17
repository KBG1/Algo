function solution(schedules, timelogs, startday) {
    let answer = 0;
    let late = false;
    
    //1. schedules를 반복한다. 
    schedules.forEach((schedule, idx) => {
        let day = startday;
        let scheduleTime = (Math.floor(schedule / 100) * 60) + (schedule % 100);
        late = false;
        //2. timelog를 보면서, 지각했는지 체크한다.
        for(let i = 0; i < 7; i++){
            let time = (Math.floor(timelogs[idx][i] / 100) * 60) + (timelogs[idx][i] % 100);
            //3. 지각을 하면, 바로 out (토, 일 제외)
            if(time - scheduleTime > 10 && (day <= 5)){
                late = true;
                break;
            }
            //4. startday를 증가시키면서 값 계속 비교
            day++;
            if(day === 8){
                day = 1;
            }
        }
        //5. 지각 안했으면 선물
        if(!late){
            answer++;
        }
        
    })
    
    
    return answer;
}