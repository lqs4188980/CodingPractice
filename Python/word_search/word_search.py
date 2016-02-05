from functools import reduce

class Solution(object):
    def exist(self, board, word):
        if len(board) < 1 or len(word) < 1:
            return False
        m = len(board)
        n = len(board[0])
        starting_point = []
        for i in range(m):
            for j in range(n):
                if board[i][j] == word[0]:
                    if starting_point == []:
                        starting_point = [(i, j)]
                    else:
                        starting_point.append((i, j))

        return reduce(lambda init, ij: \
                                        init or self.ok(ij[0], ij[1], m, n, board, word, 0, set()), \
                                        starting_point, False)


    def ok(self, i, j, m, n, board, word, idx, visited):
        visited.add((i,j))
        idx += 1
        if idx == len(word):
            return True
        if i+1 >= 0 and i+1 < m:
            if board[i+1][j] == word[idx] and \
                    (i+1,j) not in visited and \
                    self.ok(i+1, j, m, n, board, word, idx, set(visited)):
                return True
        if i-1 >= 0 and i-1 < m:
            if board[i-1][j] == word[idx] and \
                    (i-1,j) not in visited and \
                    self.ok(i-1, j, m, n, board, word, idx, set(visited)):
                return True
        if j+1 >= 0 and j+1 < n:
            if board[i][j+1] == word[idx] and \
                    (i,j+1) not in visited and \
                    self.ok(i, j+1, m, n, board, word, idx, set(visited)):
                return True
        if j-1 >= 0 and j-1 < n:
            if board[i][j-1] == word[idx] and \
                    (i,j-1) not in visited and \
                    self.ok(i, j-1, m, n, board, word, idx, set(visited)):
                return True
        return False
