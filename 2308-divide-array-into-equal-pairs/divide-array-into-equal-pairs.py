class Solution(object):
    def divideArray(self, nums):
        count = 0 
        n = len(nums)//2
        d = {}
        for i in range(len(nums)):
            if nums[i] in d.keys():
                d[nums[i]] = d[nums[i]] + 1
            else:
                d[nums[i]] = 1
        values = d.values()
        list_values = list(values)
        for i in range(len(list_values)):
            if list_values[i] % 2 != 0:
                break
                return false
            else:
                count += list_values[i]//2
        return count == n

        """
        :type nums: List[int]
        :rtype: bool
        """
        