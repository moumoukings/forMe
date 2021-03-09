package demo;

import com.baomidou.mybatisplus.core.mapper.Mapper;

/**
 * 测试mybatis
 *
 * @author zhangzichen
 * @date 2020/10/16 16:13
 */
public class test1 {
    public interface MyMapper<T> extends Mapper<T> {
    }
}
