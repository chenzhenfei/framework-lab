package com.tssahre.stack.demo;

import com.tssahre.stack.SeqStack;
import org.springframework.util.StringUtils;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author chenzhenfei
 * @title: InfixToSuffixExp
 * @projectName framework-lab
 * @description: 中缀表达式转换为后缀表达
 * 中缀表达式 //1+3*(9-2)+9 --->中缀表达式（跟日常见到的表达式没啥区别）
 * 后缀表达式 //1 3 9 2 - * + 9 +  转化后的后缀表达式
 *
 * @date 2020/6/1622:44
 */
public class InfixToSuffixExp {
    public static void main(String[] args) {
        String calExp = "1*2+3*(9-2)+90";
        Queue<Character> queue = convertInfixToSuffixExp(calExp);
        //如果要计算的话需要区分 1*2+12 ，放入队列中的时候 1212这种需要做区分
        int i = machineCalExp(queue);
        System.out.println(i);
    }

    private static int machineCalExp(Queue<Character> queue) {
        if(queue.isEmpty()){
            return 0;
        }
        int res = 0;

        SeqStack<Integer> calStack =new SeqStack<>();
        while(!queue.isEmpty()){
            char c = queue.poll();
            if(c>='0'&&c<='9'){
                calStack.push(Integer.parseInt(c+""));
            }else if('+'==c||'-'==c||'*'==c||'/'==c){
                if(!calStack.isEmpty()){
                    Integer c1 = calStack.pop();
                    Integer c2 = calStack.pop();
                    res =calExp(c1,c2,c);
                    calStack.push(res);
                }
            }
        }

        return calStack.pop();
    }

    private static int calExp(Integer a, Integer b, Character c) {
        int ia =a;
        int ib =b;
        switch (c) {
            case '*':
                return ia * ib;
            case '/':
                return ia / ib;
            case '+':
                return ia + ib;
            case '-':
                return ia - ib;
            default:
                break;
        }
        return 0;
    }

    private static int calExp(char[] chars) {
        return 0;
    }

    /**
     * 1）如果遇到操作数，我们就直接将其放入数组B中。
     * 2）如果遇到运算符，则我们将其放入到栈A中，遇到左括号时我们也将其放入栈A中。
     * 3）如果遇到一个右括号，则将栈元素弹出，将弹出的运算符输出并存入数组B中直到遇到左括号为止。注意，左括号只弹出并不存入数组。
     * 4）如果遇到任何其他的操作符，如（“+”， “*”，“（”）等，从栈中弹出元素存入数组B直到遇到发现更低优先级的元素(或者栈为空)为止。弹出完这些元素后，才将遇到的操作符压入到栈中。有一点需要注意，只有在遇到” ) “的情况下我们才弹出” ( “，其他情况我们都不会弹出” ( “。
     * 5）如果我们读到了输入的末尾，则将栈中所有元素依次弹出存入到数组B中。
     * 6）到此中缀表达式转化为后缀表达式完成，数组存储的元素顺序就代表转化后的后缀表达式。
     * @param calExp
     * @return
     */
    private static Queue<Character> convertInfixToSuffixExp(String calExp) {
        if (StringUtils.isEmpty(calExp)) {
            return null;
        }
        int length = calExp.length();
        Queue<Character> queue = new LinkedBlockingQueue<Character>();
        SeqStack<Character> tmp = new SeqStack<Character>();
        for (int i = 0; i < length; i++) {
            char c = calExp.charAt(i);
            if (c >= '0' && c <= '9') { // 如果是数字直接存入数组
                queue.offer(c);
            } else {
                if ('+' == c || '-' == c) { // +-
                    while (!tmp.isEmpty() && tmp.peek() != '(') {
                        queue.offer(tmp.pop());
                    }
                    tmp.push(c);
                } else if ('*' == c || '/' == c) {//*/
                    while (!tmp.isEmpty() && (tmp.peek() == '*' || tmp.peek() == '/')) {
                        queue.offer(tmp.pop());
                    }
                    tmp.push(c);

                } else if ('(' == c) {
                    tmp.push(c);
                } else if (')' == c) {
                    // 不断出栈 到碰到 ‘(’
                    Character top;
                    do {
                        top = tmp.pop();
                        if (top != '(') {
                            queue.offer(top);
                        }
                    } while (top != '(' && top != null);
                }
            }
        }
        if (!tmp.isEmpty()) {
            while (!tmp.isEmpty()) {
                queue.offer(tmp.pop());
            }
        }
        return queue;
    }
}
