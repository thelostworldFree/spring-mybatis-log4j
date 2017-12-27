package com.java.test;
 
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fuwei.mapper.CategoryMapper;
import com.fuwei.pojo.Category;
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {
	
    @Autowired
    private CategoryMapper categoryMapper;
 
   /* @Test//插入数据
    public void testAdd() {
    	
    	for(int i=0;i<=10000;i++) {
        Category category = new Category();
        category.setUsername("老大"+i);
        category.setClasses("pool");
        category.setBirthday("1926-0-3");
        category.setCity("北京");
        category.setQq(15652584);
        category.setWords("pool可以的");
        category.setPhone(1955148);
        categoryMapper.add(category);
    	}
    }*/
  /*  @Test//删除信息
    public void testDelete() {
        Category category = new Category();
        category.setSid(33);
        //categoryMapper.delete(32);
    }
    
    @Test//修改信息
    public void testUpdate() {
        Category category = new Category();
        category.setSid(28);
        category.setUsername("true---西海66");
        categoryMapper.update(category);
    }*/
 
    @Test//查询全部的信息
    public void testList() {
    	
    	for(int i=0;i<=1000;i++) {
    		System.out.println(i);
        System.out.println(categoryMapper);
        List<Category> cs=categoryMapper.list();
        for (Category c : cs) {
            System.out.println(c.toString());
            
           }
    	}
    }
    
   
}