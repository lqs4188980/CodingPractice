class Solution(object):
    def canCompleteCircuit(self, gas, cost):
        start, curr, length, left = 0, 0, 0, 0
        while length < len(gas):
            length += 1
            left += gas[curr] - cost[curr]
            while left < 0:
                if length >= len(gas):
                    return -1
                start -= 1
                length += 1
                left += gas[start] - cost[start]
            curr += 1
        start = len(gas) + start if start < 0 else start
        return start