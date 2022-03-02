package org.zongjieli.leetcode.question.daily.year2022.month2.week4;
/**
 * 给定一个字符串 s,根据下述规则反转字符串:
 *  所有非英文字母保留在原有位置。
 *  所有英文字母(小写或大写)位置反转
 * 返回反转后的 s
 *
 * 1 <= s.length <= 100
 * s 仅由 ASCII 值在范围 [33, 122] 的字符组成
 * s 不含 '\"' 或 '\\'
 *
 * @author   Li.zongjie
 * @date     2022/2/23
 * @version  1.0
 */
public class Z3ReverseCharacter {
    public String reverseOnlyLetters(String s) {
        byte[] value = s.getBytes();
        int left = 0, right = value.length - 1;
        a: while (left < right) {
            byte leftV = value[left];
            if (leftV < 'A' || (leftV > 'Z' && leftV < 'a') || leftV > 'z') {
                ++left;
                continue;
            }

            byte rightV = value[right];
            while (rightV < 'A' || (rightV > 'Z' && rightV < 'a') || rightV > 'z') {
                if (--right <= left) {
                    break a;
                }
                rightV = value[right];
            }
            value[right--] = leftV;
            value[left++] = rightV;
        }
        return new String(value);
    }
}
