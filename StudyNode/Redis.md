# Redis
1. 概念: redis是一款高性能的NOSQL系列的非关系型数据库

2. rides文件夹说明
    1. redis.windows.conf : 配置文件
    2. redis-cli.exe : redis的客户端
    3. redis-server.exe : redis服务器端
    
3. 命令操作
    1. redis的数据结构 : 
        * redis 存储的是: key,value格式的数据,其中key都是字符串,value有五种不同的数据结构
            1. 字符串类型 string
            2. 哈希类型 hash : map格式
            3. 列表类型 list : linkedList(链表)格式
            4. 集合类型 set : 
            5. 有序集合类型 sortedSet 
    2. 字符串类型 string
        1. 存储 : set key value
        2. 获取 : get key
        3. 删除 : del key
    3. 哈希类型 : hash
        1. 存储 : hset key field value
        2. 获取 :
            * hget key field
            * hgetall key : 获取所有的
        3. 删除 : hdel key field
    4. 列表类型 list : 可以添加一个元数到列表的头部(左边)或者尾部(右边)
        1. 添加 : 
            * lpush key value : 将元素加入到列表左边
            * rpush key value : 将元数加入到列表右边
        2. 获取: 
            * lrange key start end : 范围获取
            * 
        3. 删除: 
            * lpop key : 从列表的最左边删除一个元数,并且返回
            * rpop key : 从列表的最右边删除一个元数,并且返回
    5. 集合类型 set : 不允许重复元数
        1. 添加 : sadd key value
        2. 获取 : smembers key : 获取set集合中所有元素
        3. 删除 : srem key value : 删除集合中的某个元数
    6. 有序集合类型 sortedset : 不允许重复元数,且元数有序
        1. 存储 : zadd key score value
        2. 获取 : zrange key start end 
        3. 删除: zren key value
    7. 通用命令
        1. key * : 查询所有的键
        2. type key : 获取键对应的value类型
        3. del key : 删除制定的key value
4. 持久化
    1. redis是一个内存数据库 , 当redis服务器重启,或者电脑重启,数据会丢失,我们可以将redis内存中的数据持久化保存到硬盘的文件夹中
    2. redis持久化机制:
        1. RDB : 默认方式,不需要进行配置,默认就使用这种机制
            * 在一定的间隔时间中,检测key的变化情况,然后持久化数据
        2. ADF : 日子记录的方式,以及记录每一条命令的操作,可以每次一命令操作后,持久化数据
            