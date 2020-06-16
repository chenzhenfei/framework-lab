package com.tssahre.stack.demo;

import com.tssahre.stack.SeqStack;

/**
 * @author chenzhenfei
 * @title: SymbolMatch
 * @projectName framework-lab
 * @description: 符号匹配 = 成对匹配
 * @date 2020/6/1622:15
 */
public class SymbolMatch {
    public static void main(String[] args) {
        String symbol ="((5-3)*8-2)";
        boolean match = match(symbol,'(',')');
        System.out.println(match);
    }

    private static boolean match(String symbol,Character left,Character right) {
        if(symbol==null||symbol.length()==0){
            return false;
        }
        int len =0;
        SeqStack<Character>  ss =new SeqStack<Character>();
        while (len < symbol.length()) {
            char c = symbol.charAt(len);
            if(c==left){
                ss.push(c);
            }else if(c==right){
                if(ss.isEmpty()){
                    return false;
                }
                Character pop = ss.pop();
            }
            len++;
        }
        if(ss.isEmpty()){
            return true;
        }
        return false;
    }
}
