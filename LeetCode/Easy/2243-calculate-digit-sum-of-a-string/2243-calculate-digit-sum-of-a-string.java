class Solution {
    public String digitSum(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        while(sb.length() > k){
            StringBuilder sb1 = new StringBuilder();
            //List<String> list = new ArrayList<>();
            for (int i = 0; i < sb.length(); i += k) {
                //list.add(sb.substring(i, Math.min(i + k, sb.length())));
                int sum = 0;
                for(int j = i; j <  Math.min(i + k, sb.length()) ; j++){
                    sum += sb.charAt(j) - '0';
                }
                sb1.append(sum);
            }

            // for(String str : list){
            //     //
            //     int digitSum = 0;
            //     for(int i = 0; i < str.length(); i++){
            //         digitSum += str.charAt(i) - '0';
            //     }
            
            //     sb1.append(String.valueOf(digitSum));
            // }
            sb = sb1;
        }
        return sb.toString();
    }
}