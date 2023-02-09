package org.zongjieli.leetcode.question.daily.year2023.month2.week2;

import java.util.HashMap;
import java.util.Map;

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

    private final Map<String, Integer> save = new HashMap<>();
    private final int live;

    public Z4CheckSystem(int timeToLive) {
        this.live = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        save.put(tokenId, currentTime);
    }

    public void renew(String tokenId, int currentTime) {
        Integer exist = save.get(tokenId);
        if (exist == null) {
            return;
        }
        if (exist + live > currentTime) {
            save.put(tokenId, currentTime);
        } else {
            save.remove(tokenId);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for (Integer value : save.values()) {
            if (value + live > currentTime) {
                count++;
            }
        }
        return count;
    }

}
