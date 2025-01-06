function solution(cacheSize, cities) {
    //캐시 타임
    let time = 0;
    //빈 배열 생성...
    var cache = [];
    
    //캐시가 0인경우 
    if(cacheSize === 0) return cities.length * 5;
    
    //cities 배열을 순환하면서...
    cities.forEach((value) => {
        //대문자로 통일
        value = value.toUpperCase();
        //캐시가 이미 있는 값이라면?
        if(cache.includes(value)){
            time++;
            //교체
            cache.splice(cache.indexOf(value), 1);
        }
        //없으면
        else{
            time += 5;
        }
        cache.push(value);
        
        //캐시 사이즈를 넘으면 맨 앞의 요소를 버린다.
        if(cache.length > cacheSize) {
            cache.shift();
        }
    })

    return time;
}