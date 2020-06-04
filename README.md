# teaching-affair-management 
教务管理系统 
搭配环境 ：  
使用maven环境更好地搭建和管理项目，服务器使用Tomcat7.0
技术要求：  
（后台）spring + spring MVC + Mybatis + mysql （SSM框架） 
（前端）layui  
  
需求分析：  
1、需求简介  
教务管理系统面向教务处、院、系教师和全校学生，实现学籍管理、课表管理、成绩管理、教学质量监控等功能。  
2、需求功能详细介绍  
教务管理系统的使用用户是管理员、教师和学生，要求用户界面间接整齐，美观，用户体验好。  
在使用教务管理系统时，有频繁的大量的数据查询，因此要求服务器能积极及时的响应大批量的用户请求。  
软件方面要求系统整体使用起来流畅度高。    
在安全方面，要求能完整保存用户数据而不容易被泄露，还在登录界面使用了登录拦截器来保证安全。    
3、项目分析   
开发教务管理系统旨在改变原有人工进行教务管理的工作方式，实现学籍管理、课表管理、成绩管理、教学质量监控等功能  
