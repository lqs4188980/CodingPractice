# no other word from the dict has the same abbr

class ValidWordAbbr(object):
    def __init__(self, dictionary):
        """
        initialize your data structure here.
        :type dictionary: List[str]
        """
        self.abbr = {}
        for word in dictionary:
            abbr = self.get_abbr(word)
            if abbr not in self.abbr:
                self.abbr[abbr] = [word]
            elif word not in self.abbr[abbr]:
                self.abbr[abbr].append(word)
        
        
    def get_abbr(self, word):
        if len(word) < 3:
            return word
        else:
            return word[0] + str(len(word)-2) + word[-1]
        

    def isUnique(self, word):
        """
        check if a word is unique.
        :type word: str
        :rtype: bool
        """
        abbr = self.get_abbr(word)
        if abbr not in self.abbr:
            return True
        elif len(self.abbr[abbr]) == 1 and word == self.abbr[abbr][0]:
            return True
        else:
            return False