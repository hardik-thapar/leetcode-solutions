class Solution:
    def search(self, nums: List[int], target: int) -> int:
        end=len(nums)
        st=0
        while(st<end):
            mid=int((st+end)/2)
            if nums[mid]==target:
                return mid
            elif nums[mid]>target:
                end=mid
            else:
                st=mid+1
        return -1

        