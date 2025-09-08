class Solution:
    def commonChars(self, words: List[str]) -> List[str]:
        d = []
        for word in words:
            x=Counter(word)
            d.append(x)
      

        ans=[]

        for i in words[0]:
            mini=1e9
            

            for j in range(len(d)):
                
                if i not in d[j]:
                    break
                
                elif j==len(words)-1:
                    
                    if i in d[j]:
                        mini=min(d[j][i],mini)
                        ans.append(i*mini)
                elif i in d[j]:
                    mini=min(d[j][i],mini)
            
        a=list(set(ans))
        res=[]
        for i in a:
            res.extend(list(i))
        
        return res

        
        
        

            
                
                
            

        