function solution(s) {
    const array = s.split(" ");
    let min, max = 0;
    
    array.forEach((value, idx) => {
        //첫 번째 순서면, 얘를 일단 최솟값과 최댓값 에 넣는다.
        if(idx === 0){
            min = Number(value);
            max = Number(value);
        }    
        //나머지는 값을 비교하여 최대와 최소를 바꾼다.
        else if(Number(value) > max){
            max = Number(value);
        }
        else if(Number(value) < min){
            min = Number(value);
        }    
    })
    
    return min + " " + max;
}