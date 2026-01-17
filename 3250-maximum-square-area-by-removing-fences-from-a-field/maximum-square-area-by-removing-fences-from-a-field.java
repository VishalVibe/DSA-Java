class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        final long MOD = 1_000_000_007;
        HashSet<Integer> set = new HashSet<>();
        int maxSide =0;
        int[] hFence = new int[hFences.length +2];
        int[] vFence = new int[vFences.length + 2];
        hFence[0]  = 1;
        hFence[hFence.length-1] = m;
        vFence[0] = 1;
        vFence[vFence.length-1] = n;
        for(int i=1 ;i< hFence.length-1 ; i++){
            hFence[i] = hFences[i-1];
        }
        for(int i=1 ; i< vFence.length-1 ; i++){
            vFence[i] = vFences[i-1];
        }
        Arrays.sort(hFence);
        Arrays.sort(vFence);

        for(int i=0; i< hFence.length-1 ; i++){
            for(int j=i+1 ; j< hFence.length ; j++){
                set.add(hFence[j] - hFence[i]);
            }
        }

        for(int i=0 ; i< vFence.length-1; i++){
            for(int j= i+1 ; j<vFence.length ; j++){
                if(set.contains(vFence[j] - vFence[i])){
                    maxSide = Math.max(maxSide , vFence[j] - vFence[i]);
                }
            }
        }
        if (maxSide == 0) return -1;
        return (int) ((1L * maxSide * maxSide) % MOD);
        
        
    }
}