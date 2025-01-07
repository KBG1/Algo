function solution(video_len, pos, op_start, op_end, commands) {
    //비디오 재생 시간
    let video_time = video_len.slice(0, 2) * 60 + Number(video_len.slice(3, 5));
    
    //현 시점 시간
    let pos_time = pos.slice(0, 2) * 60 + Number(pos.slice(3, 5));
    
    //op 시작과 끝 시간
    let op_start_time = op_start.slice(0, 2) * 60 + Number(op_start.slice(3, 5));
    let op_end_time = op_end.slice(0, 2) * 60 + Number(op_end.slice(3, 5));
    
    //pos 타임이 오프닝 시간 내에 위치한 경우 끝시간으로 이동한다.
    if(pos_time <= op_end_time && pos_time >= op_start_time){
        pos_time = op_end_time;
    }
    
    //명령어를 순회하며, 값을 수행한다.
    commands.forEach((value) => {
        //10초 뒤 이동
        if(value === "next"){
            pos_time += 10;
            //이때, 비디오 길이를 넘어가면 안됨
            if(pos_time > video_time){
                pos_time = video_time;
            }
        }
        //10초 전 이동
        else if(value === "prev"){
            //이때 0보다 작아지면 안됨
            pos_time -= 10;
            if(pos_time < 0){
                pos_time = 0;
            }
        }
        
        //이때도 pos 타임이 오프닝 시간 내에 위치한 경우 끝시간으로 이동한다.
        if(pos_time <= op_end_time && pos_time >= op_start_time){
            pos_time = op_end_time;
        }
    })
    
    
    //이때의 pos_time은 숫자형식이므로, 리턴할때는, 문자열로 바꿔준다.   
    let pos_minute = parseInt(pos_time / 60) >= 10 ? parseInt(pos_time / 60) : '0' + parseInt(pos_time / 60);
    let pos_second = pos_time % 60 >= 10 ? pos_time % 60 : '0' + pos_time % 60;
    
    return pos_minute + ":" + pos_second;
}