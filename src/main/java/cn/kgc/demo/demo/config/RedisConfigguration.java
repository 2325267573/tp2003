package cn.kgc.demo.demo.config;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfigguration {
    @Bean("myRedisTemplate")//将当前的方法返回的对象注入到ioc容器中
    public RedisTemplate createRedisTemplate(RedisConnectionFactory factory){
        RedisTemplate template=null;

     //创建temlate对象
        template.setConnectionFactory(factory);
    //对象和hash序列化对象
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer=new Jackson2JsonRedisSerializer(Object.class);
    ObjectMapper om=new ObjectMapper();
    om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
    om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
    jackson2JsonRedisSerializer.setObjectMapper(om);

    StringRedisSerializer stringRedisSerializer=new StringRedisSerializer();
//string序列化
    template.setKeySerializer(stringRedisSerializer);
    template.setHashKeySerializer(stringRedisSerializer);
//valuez序列号
    template.setValueSerializer(jackson2JsonRedisSerializer);

template.setHashKeySerializer(jackson2JsonRedisSerializer);





        return  template;



    }

}

