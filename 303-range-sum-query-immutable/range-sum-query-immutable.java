class NumArray {
    int n;
    int[] tree;
    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[4*n];
        build(nums ,  0,  0,  n-1);
        
    }
    public void build(int[] arr , int node , int start , int end){
        if(end == start){
            tree[node] = arr[start];
        }
        else{
            int mid = (start+end)/2;
            build(arr , 2*node+1 , start , mid);
            build(arr , 2*node+2 , mid+1 , end);
            tree[node] = tree[2*node+1] + tree[2*node+2];
        }
    }
    
    public int sumRange(int left, int right) {
        return query(0,0,n-1,left , right);
    }
    public int query(int node , int start , int end , int left , int right){
        if(right < start || end < left){
            return 0;
        }
        if(left <= start && end <= right){
            return tree[node];
        }
        int mid = (start + end)/2;
        int leftSum = query(2*node+1 , start , mid , left , right);
        int rightSum = query(2*node+2 , mid+1 , end , left , right);
        return leftSum + rightSum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */