package com.great.service;

import com.great.dao.*;
import com.great.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class MyService {
    @Resource
    private DeptSqlMap deptSqlMap;
    @Resource
    private MenuSqlMap menuSqlMap;
    @Resource
    private RoleSqlMap roleSqlMap;
    @Resource
    private TreeSqlMap treeSqlMap;
    @Resource
    private LogSqlMap logSqlMap;
    @Resource
    private DocumentSqlMap documentSqlMap;
    @Resource
    private DocumentTypeSqlMap documentTypeSqlMap;

    //登录
    @Transactional//声明事务
    public User findById(String account, String pwd){
        Map<String,String> loginMap = new LinkedHashMap<>();
        loginMap.put("account",account);
        loginMap.put("pwd",pwd);
        return deptSqlMap.findById(loginMap);
    }




    @Transactional//声明事务
    //查询菜单
    public  Map<String,List<Menu>>FindMenuByRoleId(Integer rid){
        Map<String,List<Menu>> menuMap = new LinkedHashMap<>();
        List<Menu> menuList= menuSqlMap.findMenuByRid(rid);
        Map<String,Integer> map = new LinkedHashMap<>();
        for (int i=0;i<menuList.size();i++){
            Menu Menu = menuList.get(i);//通过遍历获取所有的菜单项
            map.put("mid",Menu.getMid());
            map.put("roleid",rid);
            List<Menu> menuList2=menuSqlMap.findMenuByMid(map);//根据主菜单的ID去找子菜单
            menuMap.put(Menu.getMenuname(),menuList2);
        }
        return menuMap;
    }


    //查询用户信息并分页
    public List<User> findAllUserByPage(Map map){

        return deptSqlMap.findAllUserByPage(map) ;
    }
    //获取用户信息总条数
    public Integer findAllUserCount(Map map){
        return deptSqlMap.findAllUserCount(map);
    }
    //增加用户
    @Transactional//声明事务
    public Integer addUser(User user){
        return deptSqlMap.addUser(user);
    }

    //判断是否被注册
    public Integer cUser(String account){
        return deptSqlMap.cUser(account);
    }

    //删除用户
    @Transactional//声明事务
    public Integer deleteUserInf(Integer uid){
        return deptSqlMap.deleteUserInf(uid);
    }

    //查询角色信息并分页
    public List<Role> findAllRoleByPage(Map map){
        return  roleSqlMap.findAllRoleByPage(map);

    }

    //更新用户信息
    @Transactional//声明事务
    public Integer updateUserInf(User user){
        return deptSqlMap.updateUserInf(user);
    }

    //改变用户状态
    @Transactional//声明事务
    public Integer changeUserState(Map map){
        return  deptSqlMap.changeUserState(map);
    }

    //查询所有角色的页数
    public Integer findAllRoleCount(){
        return roleSqlMap.findAllRoleCount();
    }

    //获取全部权限
    public List<Tree>allMenuByRid(){
        return treeSqlMap.allMenuByRid();
    }

    //获取角色权限
    public List<Tree>allMidByRid(Integer rid){
        return treeSqlMap.allMidByRid(rid);
    }

    //删除权限
    @Transactional//声明事务
    public Integer deleteMenuRelation(Integer rid){
        return menuSqlMap.deleteMenuRelation(rid);
    }

    //添加权限
    @Transactional//声明事务
    public Integer insertMenuRelation(List<Map<String, Integer>> list){
        return menuSqlMap.insertMenuRelation(list);
    }

    //添加操作日志
    @Transactional//声明事务
    public Integer addLog(SystemLog systemLog){
        return logSqlMap.addLog(systemLog);
    }

    //插入文档信息
    @Transactional//声明事务
    public Integer insertInfByUid (Document document){
        return documentSqlMap.insertInfByUid(document);
    }

    //查询文档信息并分页
    public List<Document>  findDocumentByUid(Map map){
        return documentSqlMap.findDocumentByUid(map);
    }

    //查询文档信息总条数
    public Integer  findDocumentCount(Map map){

        return documentSqlMap.findDocumentCount(map);
    }

    //查询全部文档类型
    public List<DocumentType>findDocumentType(){
        return documentTypeSqlMap.findDocumentType();
    }

    //查询个人上传记录并分页
    public List<Document>  findDocumentRecord(Map map){
        return documentSqlMap.findDocumentRecord(map);
    }

    //查询个人上传记录总条数
    public Integer  findDocumentRecordCount(Map map){

        return documentSqlMap.findDocumentRecordCount(map);
    }

    //用户删除自己上文的文档
    @Transactional//声明事务
    public Integer deleteDocumentInf(Integer did){
        return documentSqlMap.deleteDocumentInf(did);
    }

    //查询自己的分数情况
    public List<MyScore>findMyScore(Map map){
        return documentTypeSqlMap.findMyScore(map);
    }

    //查询我的分数总页数
    public Integer findMyScoreCount(Integer uid){

        return documentTypeSqlMap.findMyScoreCount(uid);
    }

    //改变文档状态
    @Transactional//声明事务
    public Integer changeDocumentState(Map map){
        return documentSqlMap.changeDocumentState(map);
    }

    //设置注册奖励
    public Integer registIncentives(Integer score){
        return deptSqlMap.registIncentives(score);
    }

    //查询注册奖励分
    public Integer findRegistIncentives(){
        return deptSqlMap.findRegistIncentives();
    }

    //查询所有文档类型总页
    public Integer findTypeCount(Map map){

        return  documentTypeSqlMap.findTypeCount(map);
    }
    //查询所有文档类型并分页
    public List<DocumentType> findType(Map map){
        return  documentTypeSqlMap.findType(map);
    }

    //删除文档格式
    @Transactional//声明事务
    public Integer deleteType(Integer uid){
        return documentTypeSqlMap.deleteType(uid);
    }

    //更新文档格式
    @Transactional//声明事务
    public Integer updateType(DocumentType d){
        return documentTypeSqlMap.updateType(d);
    }

    //添加文档格式
    @Transactional//声明事务
    public Integer addType(DocumentType documentType){
        return documentTypeSqlMap.addType(documentType);
    }

    //管理员确定上传后用户增加分值的操作
    @Transactional//声明事务
    public Integer addScoreRecord(Map map){
        Integer score=  documentTypeSqlMap.typeScore((String) map.get("typename"));//查询文档类型对应的奖励分
        Integer oldScore =documentTypeSqlMap.findUserScore((Integer) map.get("userid"));//查到用户当前分数
        Map<String,Object> map1 = new LinkedHashMap<>();
        map1.put("score",(score+oldScore));
        map1.put("userid",map.get("userid"));
        Integer demo= documentTypeSqlMap.changeUserScore(map1);
        if (1==demo){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");//设置时间格式
            String time = sdf.format(new Date());//操作时间
            MyScore myScore = new MyScore();
            myScore.setEvent("增加");
            myScore.setScore(score);
            myScore.setTime(time);
            myScore.setUserid((Integer) map.get("userid"));
            Integer demo2=documentTypeSqlMap.insertScoreRecord(myScore);
            if (1==demo2){
                return demo2;
            }
        }
        return null;
    }

    //文件下载
    public Document findDocument(Integer did){

        return documentSqlMap.findDocument(did);
    }

    //文件下载次数更新
    public void DownCount(Integer did,Integer downCount){
       Map<String,Integer> map = new HashMap();
       map.put("did",did);
       map.put("downcount",(downCount+1));
        documentSqlMap.newDownCount(map);
    }

    //下载文件积分判断
    @Transactional//声明事务
    public Integer updateUserScore(Integer userid,Integer downSocre){
        Integer oldScore =documentTypeSqlMap.findUserScore(userid);
        if ((oldScore-downSocre)>0){
            Map<String,Object> map1 = new LinkedHashMap<>();
            map1.put("score",((oldScore-downSocre)));
            map1.put("userid",userid);
            Integer demo= documentTypeSqlMap.changeUserScore(map1);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm ");//设置时间格式
            String time = sdf.format(new Date());//操作时间
            MyScore myScore = new MyScore();
            myScore.setEvent("减少");
            myScore.setScore(downSocre);
            myScore.setTime(time);
            myScore.setUserid(userid);
            Integer demo2=documentTypeSqlMap.insertScoreRecord(myScore);
            return demo;
        }
        return 0;
    }
}
