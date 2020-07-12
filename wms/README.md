#数据库初始化
```sql
mysql -uroot -p

create database wms;
use wms;
source /Users/jonas/project/wms/src/main/resources/wms.sql # 系统下的绝对路径

```
# 项目demo

1. 访问 http://localhost:8080/login?name=sxz&password=12345 登录普通用户,http://localhost:8080/login?name=chunji&password=123456 管理员
2. http://localhost:8080/index 访问加过权限的接口

