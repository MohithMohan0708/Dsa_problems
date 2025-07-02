class Solution(object):
    def groupAnagrams(self, strs):
        ans = []
        d = {}
        for str in strs:
            l = tuple(sorted(str))
            if l in d:
                d[l].append(str)
            else:
                d[l] = [str]
        for value in d.values():
            ans.append(value)
        return ans
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        