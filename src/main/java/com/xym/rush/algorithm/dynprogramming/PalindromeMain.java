package com.xym.rush.algorithm.dynprogramming;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:最大回文串测试
 * @author: 86137
 * @date: 2021/9/8 17:33
 */
@Slf4j
public class PalindromeMain {
    public static void main(String[] args) {
        //测试数据
        String str1 = "qwertyuapcnnvjdnjnskdk  oakjbckbakjbkbakc kabjkckbhbajhbjajhb" +
                "sdbfkjaja;ljlandlfjn cmn kbkkbkhbjhbbjancankjcbkajbcakcsjbkajbckjabkc aknlsdhuoaih" +
                "foalcjbak jk lanlma kcjnalknckakcnaknclakjc lanvlknalknvlanl lsvnosndvlnvlknvlnlvldjnvm kjb";

        String str2 = "abacdfdc";

        MaxPalindromeString maxPalindromeString = new MaxPalindromeString();

        long start = System.currentTimeMillis();
        log.info("最长回文字符串为:{}",maxPalindromeString.myselfImpl(str2));
        long end = System.currentTimeMillis();

        log.info("开始时间：{}",start);
        log.info("结束时间：{}",end);
        log.info("计算耗时：{}ms",end-start);
    }
}
