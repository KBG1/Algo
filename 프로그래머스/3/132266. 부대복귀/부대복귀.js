function solution(n, roads, sources, destination) {
    let answer = new Array(sources.length).fill(-1);
    let adjList = Array.from({ length: n + 1 }, () => []);
    
    // 그래프 구성
    roads.forEach(([a, b]) => {
        adjList[a].push(b);
        adjList[b].push(a);
    });

    // BFS를 위한 자료구조: Queue (Deque 활용)
    let distance = new Array(n + 1).fill(-1);
    let queue = [];
    
    // 목표 지점에서 시작하는 BFS
    distance[destination] = 0;
    queue.push(destination);

    while (queue.length > 0) {
        let cur = queue.shift();  // 큐의 앞에서 원소를 꺼냄

        for (let next of adjList[cur]) {
            if (distance[next] === -1) { // 방문하지 않은 곳이면 거리 갱신
                distance[next] = distance[cur] + 1;
                queue.push(next);
            }
        }
    }

    // 결과 생성
    for (let i = 0; i < sources.length; i++) {
        answer[i] = distance[sources[i]];
    }

    return answer;
}
