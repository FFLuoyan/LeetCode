package org.zongjieli.leetcode.question.daily.year2021.month4.week5;

import org.zongjieli.leetcode.base.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 给定一个保存员工信息的数据结构,它包含了员工唯一的 id,重要度和直系下属的 id
 *
 * 比如:员工 1 是员工 2 的领导,员工 2 是员工 3 的领导,他们相应的重要度为 15,10,5
 * 那么员工 1 的数据结构是 [1, 15, [2]]
 * 员工 2 的数据结构是 [2, 10, [3]]
 * 员工 3 的数据结构是 [3, 5, []]
 * 注意虽然员工 3 也是员工 1 的一个下属,但是由于并不是直系下属,因此没有体现在员工 1 的数据结构中
 *
 * 现在输入一个公司的所有员工信息,以及单个员工 id,返回这个员工和他所有下属的重要度之和
 *
 * PS: 一个员工最多有一个直系领导,但是可以有多个直系下属
 * 员工数量不超过 2000
 *
 * @author   Zongjie.Li
 * @date     2021/5/1
 * @version  1.0
 */
public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer,Employee> map = employees.stream().collect(Collectors.toMap(k -> k.id,v -> v));
        return importanceCount(map,id);
    }

    public int importanceCount(Map<Integer,Employee> map,int id){
        Employee employee = map.get(id);
        if (employee == null){
            return 0;
        }
        int[] count = new int[]{employee.importance};
        if (employee.subordinates == null || employee.subordinates.isEmpty()){
            return count[0];
        }
        employee.subordinates.forEach(subId -> count[0] += importanceCount(map,subId));
        return count[0];
    }
}
