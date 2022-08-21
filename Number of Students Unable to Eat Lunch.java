class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int ans = 0;
        
        Queue<Integer>  q = new LinkedList<>();
        
        for(int i:students)
        {
            q.add(i);
        }
        
        Stack<Integer> st = new Stack<>();
        
        int n = students.length;
        
        for(int i=n-1;i>=0;i--)
        {
            st.push(sandwiches[i]);
        }   
        
        int c=0;
        
        boolean flag = true;
        
        while(flag && q.size()>0 && st.size()>0)
        {
            if(q.peek()==st.peek())
            {
                c = 0;
                q.remove();
                st.pop();
            }
            else if(q.peek()!=st.peek())
            {
                c++;
                if(c==q.size())
                {
                    flag = false;
                }
                int i = q.remove();
                q.add(i);
            }            
        }
        
        return q.size();
        
    }
}
