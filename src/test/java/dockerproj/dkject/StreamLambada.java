package dockerproj.dkject;/**
 * @Author:sqg
 * @Description
 * @Date:${Time} ${Date}
 * @Modified By:
 **/

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @description: java8 String操作
 * @author: module
 * @create: 2020-08-13 20:05
 */
public class StreamLambada {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("aSAKJDnsad");
        list.add("azncsadDnsad");
        list.add("aSAKsad");
        list.add("zzDnsad");
       // List list2=list.stream().map(e->e.toUpperCase()).peek(e->System.out.print(e+",")).collect(Collectors.toList());
       // list.stream().forEach(e->{ int i=1; System.out.print(e) ;});
       // System.out.print(list);
       // System.out.print(list2);

        Optional.ofNullable(list).ifPresent(System.out::println);
    }
}
