package org.zongjieli.leetcode.question.daily.year2023.month2.week2;

import java.util.HashMap;

/**
 * 需要设计一个包含验证码的验证系统
 * 每一次验证中,用户会收到一个新的验证码
 * 这个验证码在 currentTime 时刻之后 timeToLive 秒过期
 * 如果验证码被更新了,那么它会在 currentTime(可能与之前的 currentTime 不同)时刻延长 timeToLive 秒
 *
 * 请你实现 Z4CheckSystem 类:
 * Z4CheckSystem(int timeToLive)
 *  构造 Z4CheckSystem 并设置 timeToLive 参数
 * generate(string tokenId, int currentTime)
 *  给定 tokenId,在当前时间 currentTime 生成一个新的验证码
 * renew(string tokenId, int currentTime)
 *  将给定 tokenId 且未过期的验证码在 currentTime 时刻更新
 *  如果给定 tokenId 对应的验证码不存在或已过期,请忽略该操作,不会有任何更新操作发生
 * countUnexpiredTokens(int currentTime)
 *  请返回在给定 currentTime 时刻,未过期的验证码数目
 * 如果一个验证码在时刻 t 过期,且另一个操作恰好在时刻 t 发生(renew 或者 countUnexpiredTokens 操作),过期事件优先于其他操作
 *
 * 1 <= timeToLive <= 10^8
 * 1 <= currentTime <= 10^8
 * 1 <= tokenId.length <= 5
 * tokenId 只包含小写英文字母
 * 所有 generate 函数的调用都会包含独一无二的 tokenId 值
 * 所有函数调用中,currentTime 的值严格递增
 * 所有函数的调用次数总共不超过 2000 次
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/9
 */
public class Z4CheckSystem {

    private final HashMap<String, Node> save = new HashMap<>();
    private final int live;

    private final Node start;
    private final Node end;

    class Node {
        int time;
        String key;
        Node pre;
        Node next;

        Node (String tokenId, int t, Node p, Node n){
            key = tokenId;
            time = t;
            pre = p;
            next = n;
        }
    }

    public Z4CheckSystem(int timeToLive) {
        this.live = timeToLive;
        start = new Node("", 0, null, null);
        end = new Node("", Integer.MAX_VALUE, start, null);
        start.next = end;
    }

    public void generate(String tokenId, int currentTime) {
        Node current = new Node(tokenId, currentTime, end.pre, end);
        current.pre.next = current;
        end.pre = current;
        save.put(tokenId, current);
    }

    public void renew(String tokenId, int currentTime) {
        Node exist = save.get(tokenId);
        if (exist != null && exist.time + live > currentTime) {
            exist.time = currentTime;
            Node next = exist.next;
            next.pre = exist.pre;
            exist.pre.next = next;
            exist.pre = end.pre;
            exist.next = end;
            end.pre.next = exist;
            end.pre = exist;
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        currentTime -= live;
        Node current = start.next;
        while (current.time <= currentTime) {
            start.next = current.next;
            save.remove(current.key);
            current = current.next;
        }
        current.pre = start;
        return save.size();
    }

    public static void main(String[] args) {
        Z4CheckSystem test;
        test = new Z4CheckSystem(5);
        test.renew("aaa", 1);
        test.generate("aaa", 2);
        System.out.print(test.countUnexpiredTokens(6) + ", ");
        test.generate("bbb", 7);
        test.renew("aaa", 8);
        test.renew("bbb", 10);
        // 1, 0
        System.out.println(test.countUnexpiredTokens(15));

        test = new Z4CheckSystem(3);
        System.out.print(test.countUnexpiredTokens(1) + ", ");
        test.generate("mqjfa", 2);
        test.generate("xg", 5);
        test.generate("dvm", 8);
        test.renew("euxli", 9);
        System.out.print(test.countUnexpiredTokens(11) + ", ");
        test.generate("oin", 13);
        System.out.print(test.countUnexpiredTokens(18) + ", ");
        test.generate("qst", 19);
        test.renew("qy", 20);
        System.out.print(test.countUnexpiredTokens(21) + ", ");
        test.renew("f", 22);
        test.renew("eqe", 23);
        System.out.print(test.countUnexpiredTokens(25) + ", ");
        System.out.print(test.countUnexpiredTokens(26) + ", ");
        System.out.print(test.countUnexpiredTokens(27) + ", ");
        System.out.print(test.countUnexpiredTokens(28) + ", ");
        test.renew("oni", 29);
        // 0, 0, 0, 1, 0, 0, 0, 0
        System.out.println(test.countUnexpiredTokens(15));

    }

}
