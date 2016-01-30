class Solution(object):
    def candy(self, ratings):
        # two pass, each pass satisfy part of equation
        candies = [1] * len(ratings)
        for i in range(1, len(ratings)):
            if ratings[i] > ratings[i-1]:
                candies[i] = candies[i-1]+1
        for i in range(len(ratings)-1, 0,  -1):
            if ratings[i-1] > ratings[i]:
                candies[i-1] = max(candies[i]+1, candies[i-1])
        return sum(candies)
# one pass
# count descending num, update sum accordingly