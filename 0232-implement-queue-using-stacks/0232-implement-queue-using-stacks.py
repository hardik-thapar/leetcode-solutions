class MyQueue:

    def __init__(self):
        self.st=[]
        self.out=[]
        


    def reverse(self, st1: list):
        for i in range(len(self.st)):
            self.out.append(self.st.pop())
        
    def push(self, x: int) -> None:
        self.st.append(x)

    def pop(self) -> int:
        if not self.out:
            self.reverse(self.st)
        return self.out.pop()



    def peek(self) -> int:
        if not self.out:
            self.reverse(self.st)
        return self.out[-1]

    def empty(self) -> bool:
        if not self.st and not self.out:
            return True
        else:
            return False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()