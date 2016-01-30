class Solution(object):
    def minCost(self, costs):
        if len(costs) < 1:
            return 0
        min_costs = [0]*3
        min_costs[0], min_costs[1], min_costs[2] = \
            costs[0][0], costs[0][1], costs[0][2]
        for i in range(1, len(costs)):
            r = min(min_costs[1], min_costs[2]) + costs[i][0]
            b = min(min_costs[0], min_costs[2]) + costs[i][1]
            g = min(min_costs[0], min_costs[1]) + costs[i][2]
            min_costs[0], min_costs[1], min_costs[2] = r, b, g
        return min(min_costs)