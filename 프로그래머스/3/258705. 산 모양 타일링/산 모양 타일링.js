function solution(n, tops) {
    let MOD = 10007;
    let k = 2 * n + 1;
    let dp = new Array(k + 1).fill(0);
    dp[0] = 1;
    dp[1] = 1;
    for(let i = 2; i <= k; i++){
        
        if(i % 2 === 0 && tops[Math.floor((i - 1) / 2)] === 1){
            dp[i] = ((dp[i - 1] * 2) + dp[i - 2]) % MOD;
        }
        else {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }
    }
    
    return dp[k];
}