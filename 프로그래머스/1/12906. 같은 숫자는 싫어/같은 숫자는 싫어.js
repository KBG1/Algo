function solution(arr)
{
    var answer = [];
    let cur = arr[0];
    answer.push(arr[0]);
    
    arr.forEach((value) => {
        //현재값과 지금 값이 같지 않으면 현재값을 변경한다.
        if(cur !== value){
            cur = value;
            answer.push(value);
        }
    })
    
    return answer;
}