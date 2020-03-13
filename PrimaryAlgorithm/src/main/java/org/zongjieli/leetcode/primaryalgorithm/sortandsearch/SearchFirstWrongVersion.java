package org.zongjieli.leetcode.primaryalgorithm.sortandsearch;

/**
 * @ClassName: SearchFirstWrongVersion
 * @Description: Search First Wrong Version
 * @Author: Zongjie.Li
 * @Date: 2020/3/13
 * @Version: 1.0
 **/
public class SearchFirstWrongVersion {
    public static void main(String[] args) {
        SearchFirstWrongVersion searchFirstWrongVersion = new SearchFirstWrongVersion();
        System.out.println(searchFirstWrongVersion.firstBadVersion(15));
    }

    public int firstBadVersion(int n){
        return badVersionBySection(1,n);
    }

    public int badVersionBySection(int start,int end){
        if (start >= end){
            return start;
        }
        int middle = (end - start)/2 + start;
        if (isBadVersion(middle)){
            return badVersionBySection(start,middle);
        } else {
            return badVersionBySection(middle + 1,end);
        }
    }

    public boolean isBadVersion(int version){
        if (version > 14){
            return true;
        }
        return false;
    }
}
