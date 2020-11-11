package com.tssahre.stack.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author chenzhenfei
 * @title: InfixToSuffixExp
 * @projectName framework-lab
 * @description: 中缀表达式转换为后缀表达
 * 中缀表达式 //1+3*(9-2)+9 --->中缀表达式（跟日常见到的表达式没啥区别）
 * 后缀表达式 //1 3 9 2 - * + 9 +  转化后的后缀表达式
 * @date 2020/6/1622:44
 */
@Slf4j
public class InfixToSuffixExpDemo {
    public static void main(String[] args) {
        String calExp = "1*2+3*(9-2)+90";
        Queue<Character> queue = null;
        try {
            queue = convertInfixToSuffixExp(calExp);
        } catch (Exception e) {
            log.error("表达式不规则");
            e.printStackTrace();
        }
        queue.stream().forEach(System.out::println);
        //如果要计算的话需要区分 1*2+12 ，放入队列中的时候 1212这种需要做区分
//        int i = machineCalExp(queue);
//        System.out.println(i);
    }


    private static Queue<Character> convertInfixToSuffixExp(String calExp) throws Exception {
        Queue<Character> queue = new LinkedBlockingQueue<>();
        Stack<Character> openStack = new Stack<Character>();
        int length = calExp.length();
        int index = 0;
        // 遍历处理表达式
        while (index < length) {
            char c = calExp.charAt(index);
//            Character pop = openStack.pop();
            switch (c) {
                case '*':
                    openStack.push(c);
                    break;
                case '/':
                    openStack.push(c);
                    break;
                case '+':
                    if (openStack.isEmpty()) {
                        openStack.push(c);
                    } else {
                        Character pop = openStack.pop();
                        while (!prior(c, pop)) {
                            queue.offer(pop);
                            if(!openStack.isEmpty()){
                                pop = openStack.pop();
                            }else{
                                break;
                            }
                        }
                        if(!openStack.isEmpty()) {
                            openStack.push(pop);
                        }
                        openStack.push(c);
                    }
                    break;
                case '-':
                    if (openStack.isEmpty()) {
                        openStack.push(c);
                    } else {
                        Character pop = openStack.pop();
                        while (!prior(c, pop)) {
                            queue.offer(pop);
                            if(!openStack.isEmpty()){
                                pop = openStack.pop();
                            }else{
                                break;
                            }
                        }
                        if(!openStack.isEmpty()) {
                            openStack.push(pop);
                        }
                        openStack.push(c);
                    }
                    break;
                case '(':
                    openStack.push(c);
                    break;
                case ')':
                    if(openStack.isEmpty()){
                        throw new Exception();
                    }
                    Character pop = openStack.pop();
                    while (pop != null && pop != '(') {
                        queue.offer(pop);
                        pop = openStack.pop();
                    }
                    if(openStack.isEmpty()){
                        throw new Exception();
                    }
                    break;
                default:
                    queue.offer(c);
                    break;
            }
            index++;
        }
        while(!openStack.isEmpty()){
            queue.offer(openStack.pop());
        }
        return queue;
    }


    public static boolean prior(Character c1, Character c2) {
        int prior1 = 0, prior2 = 0;
        switch (c1) {
            case '+':
                prior1 = 1;
                break;
            case '-':
                prior1 = 1;
                break;
            case '*':
                prior1 = 2;
                break;
            case '/':
                prior1 = 2;
                break;
            default:
                break;
        }
        switch (c2) {
            case '+':
                prior2 = 1;
                break;
            case '-':
                prior2 = 1;
                break;
            case '*':
                prior2 = 2;
                break;
            case '/':
                prior2 = 2;
                break;
            default:
                break;
        }
        return prior1 - prior2 > 0;
    }
}
