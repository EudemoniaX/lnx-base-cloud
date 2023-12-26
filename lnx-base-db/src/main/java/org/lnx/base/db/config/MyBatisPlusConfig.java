package org.lnx.base.db.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
@ConditionalOnClass({MetaObjectHandler.class})
public class MyBatisPlusConfig {

    @Bean
    public MetaObjectHandler metaObjectHandler() {
        return new MetaObjectHandler() {
            /**
             * 插入时的填充策略
             *
             * @param metaObject Clinton Begin
             */
            @Override
            public void insertFill(MetaObject metaObject) {
                //根据名称设置属性值
                this.setFieldValByName("createTime",new Date(),metaObject);
                this.setFieldValByName("updateTime",new Date(),metaObject);

            }

            /**
             * 更新时的填充策略
             *
             * @param metaObject Clinton Begin
             */
            @Override
            public void updateFill(MetaObject metaObject) {
                this.setFieldValByName("updateTime",new Date(),metaObject);


            }
        };
    }

}

