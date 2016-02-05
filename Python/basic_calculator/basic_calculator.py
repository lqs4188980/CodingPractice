class Solution(object):
    def calculate(self, s):
        past, curr, plus, stack = 0, [], True, []
        for i in range(len(s)):
            if s[i] == ' ':
                pass
            elif s[i] == '+' or s[i] == '-':
                curr = int(''.join(curr)) if curr != [] else 0
                past = past + curr if plus else past - curr
                curr = []
                plus = True if s[i] == '+' else False
            elif s[i] == '(':
                curr = int(''.join(curr)) if curr != [] else 0
                past = past + curr if plus else past - curr
                stack.append((past, plus))
                past, curr, plus = 0, [], True
            elif s[i] == ')':
                curr = int(''.join(curr)) if curr != [] else 0
                past = past + curr if plus else past - curr
                (_past, _plus) = stack.pop()
                past = _past + past if _plus else _past - past
                curr = []
            else:
                curr.append(s[i])
        curr = int(''.join(curr)) if curr != [] else 0
        return past + curr if plus else past - curr
# duplication