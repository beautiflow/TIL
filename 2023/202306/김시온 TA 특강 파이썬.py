n, m = map(int, input().split())

def dfs(pick):
    """
    지금까지 고른 수열이 pick 일 때,
    1부터 n까지 수를 추가해서 만들 수 있는 모든 순열을 탐색하는 함수
    1부터 n까지 수 중에서 추가할 수 있는 수가 여러 개라면 작은 수부터 탐색한다.
    """

    if len(pick) == m: # "n개의 수를 모두 고른 경우":
        print(*pick)
    else:
        # 1부터 n까지 수를 모두 시도
        for cand in range(1, n+1):
            if not cand in pick: #"cand를 지금까지 고른 적이 없다면":
               pick.append(cand) # 1. cand 를 선택
               dfs(pick) # 2. 더 깊이 탐색을 진행
               pick.pop() # 3. 탐색이 끝나면 cand 선택을 해제
