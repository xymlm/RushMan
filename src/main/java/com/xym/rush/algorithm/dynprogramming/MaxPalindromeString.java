package com.xym.rush.algorithm.dynprogramming;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @ClassName MaxPalindromeString
 * @Description: 最大回文字符串（示例：abacdfdc=>cdfdc）
 * @Author 哈拉曼
 * @Date 2021/8/31 19:38
 **/
@Slf4j
public class MaxPalindromeString {
    //标记回文长度(arg1,arg2开始和结束字符长度)
    private int[][] flag;

    /*
     * @description: 个人实现（类似中心扩散法）
     *  实现思路：用一个长宽都为str.length的int类型矩阵保存字符串回文长度信息
     *      递归计算：recursionStr(str,i,j)，当前两个字符相等时，判断临界值分别递归  recursionStr(str,i-1,j) recursionStr(str,i,j+1) recursionStr(str,i-1,j+1)
     *              并保存当前回文长度（j-i+1）到矩阵当中
     *      递归开始：便利所有字字符，recursionStr(str,i,i)
     * @author: 哈啦曼
     * @date: 2021/9/8 19:47
     * @param：String
     * @return:String
     */
    public String myselfImpl(String str){
        int maxlength = -10000000;
        int left = 0,right = 0;
        flag = new int[str.length()][str.length()];
        for(int i = 0,length = str.length() ; i < length ; i++){
            flag[i][i] = 1;
            recursionStr(str,i,i);
        }
        for(int i = 0,length = str.length() ; i < length ; i++){
            //StringBuilder sb = new StringBuilder();
            for(int j = 0 ; j < length ; j++){
                if(flag[i][j] > maxlength){
                    maxlength = flag[i][j];
                    left = i;
                    right = j;
                }
                //sb.append(flag[i][j]).append("  ");
            }
            //log.info(sb.toString());
        }
        return str.substring(left,right+1);
    }

    private void recursionStr(String str,int arg1,int arg2){
        if(str.charAt(arg1) == str.charAt(arg2)){
            if(arg1 == arg2){
                if(arg1 != 0){
                    recursionStr(str,arg1-1,arg2);
                }
                if(arg2 != flag.length-1){
                    recursionStr(str,arg1,arg2+1);
                }
            }else{
                flag[arg1][arg2] = arg2-arg1+1;
            }
            if (arg1 != 0 && arg2 != flag.length-1) {
                recursionStr(str,arg1-1,arg2+1);
            }
        }
        else return;
    }


    /*
     * @description: 动态规划实现(利用之前计算的结果集)
     *  标记字符串回文情况：boolean sign[i][j]  true=>表示字符串i->j为回文串  false=>相反
     *  核心部分：一条字符串在左右两边同时去除相同的长度，字符串仍然是回文的,动态规划则是利用去除左右第一个字符的子字符串的计算结果，再判断左右单个字符“==”即可
     *      公式->sign[i][j] = sign[i+1][j-1] && (str.charAt(i) == str.charAt(j))  (其中：i <= j)
     *  临界条件：① i == j,此时sign[i][j] = true;
     *          ② i + 1 = j,此时sign[i][j] = str.charAt(i) == str.charAt(j)
     * @author: 哈啦曼
     * @date: 2021/9/9 9:57
     * @param:String
     * @return:String
     */
    public String dynamicImpl(String str){
        int len = str.length();
        boolean[][] sign = new boolean[len][len];
        int start = 0,maxLen = 1;

        if(len < 2){
            return str;
        }
        for(int i = 0 ; i < len ; i++){
            sign[i][i] = true;
        }

        for(int l = 2 ; l <= len ; l++){
            for(int i = 0 , j = i + l -1 ; j < len ; i++ , j = i + l -1){
                if(l < 3){
                    sign[i][j] = (str.charAt(i) == str.charAt(j));
                }else{
                    sign[i][j] = (sign[i+1][j-1] && (str.charAt(i) == str.charAt(j)));
                }
                if(sign[i][j] && l > maxLen){
                    start = i;
                    maxLen = l;
                }
            }
        }
        return str.substring(start,start+maxLen);
    }

}
