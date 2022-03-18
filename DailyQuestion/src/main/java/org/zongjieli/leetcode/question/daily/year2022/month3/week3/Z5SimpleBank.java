package org.zongjieli.leetcode.question.daily.year2022.month3.week3;
/**
 * 为一个很受欢迎的银行设计一款程序,以自动化执行所有传入的交易(转账,存款和取款)
 * 银行共有 n 个账户,编号从 1 到 n,每个账号的初始余额存储在一个下标从 0 开始的整数数组 balance 中
 * 其中第 (i + 1) 个账户的初始余额是 balance[i]
 *
 * 请执行所有有效的交易,如果满足下面全部条件,则交易有效:
 *  指定的账户数量在 1 和 n 之间
 *  且取款或者转账需要的钱的总数小于或者等于账户余额
 *
 * 实现 Bank 类:
 *  Bank(long[] balance)
 *      使用下标从 0 开始的整数数组 balance 初始化该对象
 *  boolean transfer(int account1, int account2, long money)
 *      从编号为 account1 的账户向编号为 account2 的账户转帐 money 元
 *      如果交易成功,返回 true,否则返回 false
 *  boolean deposit(int account, long money)
 *      向编号为 account 的账户存款 money 元
 *      如果交易成功,返回 true,否则返回 false
 *  boolean withdraw(int account, long money)
 *      从编号为 account 的账户取款 money 美元
 *      如果交易成功返回 true,否则返回 false
 *
 * n == balance.length
 * 1 <= n, account, account1, account2 <= 10^5
 * 0 <= balance[i], money <= 10^12
 * transfer, deposit, withdraw 三个函数,每个 最多调用 10^4 次
 *
 * @author   Li.zongjie
 * @date     2022/3/18
 * @version  1.0
 */
public class Z5SimpleBank {

    private long[] accounts;

    public Z5SimpleBank(long[] balance) {
        accounts = new long[balance.length + 1];
        System.arraycopy(balance, 0, accounts, 1, balance.length);
    }

    public boolean transfer(int account1, int account2, long money) {
        if (!accountExist(account1) || !accountExist(account2) || accounts[account1] < money) {
            return false;
        }
        accounts[account1] -= money;
        accounts[account2] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (!accountExist(account)) {
            return false;
        }
        accounts[account] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (!accountExist(account) || accounts[account] < money) {
            return false;
        }
        accounts[account] -= money;
        return true;
    }

    public boolean accountExist(int account) {
        return account < accounts.length && account > 0;
    }
}
