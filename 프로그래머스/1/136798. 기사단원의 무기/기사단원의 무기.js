function solution(number, limit, power) {
    //철의 무게
    let answer = 0;
    
    //1부터 number까지...
    for(let i = 1; i <= number; i++){
        //그 수를 돌면서, 약수의 갯수를 찾는다.
        let count = 0;
        for(let j = 1; j * j <= i; j++){
            if(j * j === i) count++;
            else if(i % j === 0) count += 2;
        }
        //한계치보다 카운트가 더 커지면
        if(count > limit){
            count = power;
        }
        answer += count;
    }
    return answer;
}