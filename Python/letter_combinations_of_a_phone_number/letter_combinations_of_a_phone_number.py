class Solution(object):
    def letterCombinations(self, digits):
        mapping = {}
        mapping['2'] = ['a', 'b', 'c']
        mapping['3'] = ['d', 'e', 'f']
        mapping['4'] = ['g', 'h', 'i']
        mapping['5'] = ['j', 'k', 'l']
        mapping['6'] = ['m', 'n', 'o']
        mapping['7'] = ['p', 'q', 'r', 's']
        mapping['8'] = ['t', 'u', 'v']
        mapping['9'] = ['w', 'x', 'y', 'z']
        results = []
        if digits == '':
            return results
        self.helper(digits, 0, '', results, mapping)
        return results

    def helper(self, digits, idx, curr, results, mapping):
        if len(curr) == len(digits):
            results.append(curr)
            return
        for char in mapping[digits[idx]]:
            new_curr = curr + char
            self.helper(digits, idx+1, new_curr, results, mapping)

if __name__ == '__main__':
    s = '23'
    so = Solution()
    print(so.letterCombinations(s))
