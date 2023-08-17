
## mysql版本 8.0.33

## 一、踩过的坑
  resources下的目录mybatisplus/mapper一定要检查目录层级，一旦出现目录名为mybatisplus.mapper的失误， 
  产生报错：Invalid bound statement (not found): com.wjf.demo.mybatisplus.mapper.UserMapper.selectAll