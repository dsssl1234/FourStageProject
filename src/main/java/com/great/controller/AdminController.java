package com.great.controller;


import com.google.gson.Gson;
import com.great.entity.*;
import com.great.entity.Menu;
import com.great.service.MyService;
import com.great.util.ResponseUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

@Controller
@RequestMapping("/admin")//@RequestMapping：可以为控制器指定处理可以请求哪些URL请求。
public class AdminController {
    Gson g = new Gson();
    private Random random = new Random();
    @Autowired
    private MyService myService;
    @Autowired
    private DateTable dateTable;

    @RequestMapping("/index2")
    public String index2(){
        return "back/jsp/A";
    }
    //地址映射,path是个方法名,可以随便改动,{url}是参数
    @RequestMapping("/path/{url}")
    public String getUrl(@PathVariable(value = "url") String path){
        return "/back/jsp/" +path;
    }

    @RequestMapping("/CheckCodeServlet")
    public void CheckCodeServlet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //内存图片对象(TYPE_INT_BGR 选择图片模式RGB模式)
        BufferedImage image = new BufferedImage(100, 35, BufferedImage.TYPE_INT_BGR);
        //得到画笔
        Graphics graphics = image.getGraphics();
        //画之前要设置颜色，设置画笔颜色
        graphics.setColor(new Color(236,255,253,255));
        //设置字体类型、字体大小、字体样式　
        graphics.setFont(new Font("黑体", Font.BOLD, 23));
        //填充矩形区域（指定要画的区域设置区）
        graphics.fillRect(0, 0, 100, 35);
        //为了防止黑客软件通过扫描软件识别验证码。要在验证码图片上加干扰线
        //给两个点连一条线graphics.drawLine();
        for (int i = 0; i < 5; i++)
        {
            //颜色也要随机（设置每条线随机颜色）
            graphics.setColor(getRandomColor());
            int x1 = random.nextInt(100);
            int y1 = random.nextInt(35);
            int x2 = random.nextInt(100);
            int y2 = random.nextInt(35);
            graphics.drawLine(x1, y1, x2, y2);
        }

        //拼接4个验证码，画到图片上
        char[] arrays = {'A','B','C','D','E','F','G','H','J','K','L','M','N','P','Q','R','S','T','W','X','Y','Z','1','2','3','4','5','6','7','8','9'};
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 4; i++)
        {
            //设置字符的颜色

            int index = random.nextInt(arrays.length);
            builder.append(arrays[index]);
        }
        //创建session对象将生成的验证码字符串以名字为checkCode保存在session中request.getSession().setAttribute("checkCode",builder.toString());
        //将4个字符画到图片上graphics.drawString(str ,x,y);一个字符一个字符画
        request.getSession().setAttribute("vcode",builder.toString());
        for (int i = 0; i < builder.toString().length(); i++)
        {
            graphics.setColor(getRandomColor());
            char item = builder.toString().charAt(i);
            graphics.drawString(item + "", 10 + (i * 20), 25);
        }

        //输出内存图片到输出流
        ImageIO.write(image, "jpg", response.getOutputStream());
    }
    private Color getRandomColor()
    {
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return new Color(r, g, b);

    }


    @RequestMapping("/Login")
    public void Login(User user1 , HttpServletRequest request, HttpServletResponse response) throws IOException {
        String YZM = (String)request.getSession().getAttribute("vcode");//拿到验证码
        Boolean confirm = user1.getRePass().equalsIgnoreCase(YZM);//不区分大小写
        if (confirm) {
            User user =myService.findById(user1.getAccount(),user1.getPwd());
            if (null!=user){
                request.getSession().setAttribute("admin",user);
                response.getWriter().print("success");
            }else{
                response.getWriter().print("error");
            }
        }else{
            response.getWriter().print("yzm");
        }

    }

    @RequestMapping("/menu")
    public String menu(HttpServletRequest request, HttpSession hs){
        User user = (User) request.getSession().getAttribute("admin");
        hs.setAttribute("name",user.getName());
        hs.setAttribute("roleType",user.getRole().getType());
        Map<String,List<Menu>> menuMap =myService.FindMenuByRoleId(user.getRole().getRoleid());//拿到菜单
        request.setAttribute("menuMap",menuMap);
        return "back/jsp/sss";
    }

    //注销登录
    @RequestMapping("/deleteAdmin")
    public String deleteAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println("注销方法");
        //获取sesson对象
        HttpSession hs = request.getSession();
        //注销
        hs.invalidate();
        //返回页面
        return "back/jsp/login";
    }


    //判断用户名是否被注册
    @RequestMapping("/cAccount")
    public void cAccount(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String account = request.getParameter("name");
        if (null!=account||!"".equals(account)){
            Integer a = myService.cUser(account);
            if (1>a){
                response.getWriter().print("1111");
            }else{
                response.getWriter().print("2222");
            }
        }

    }
    //新增用户
    @RequestMapping("/addUser")
    public void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String a1 = request.getParameter("a");
        User user =  g.fromJson(a1,User.class);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");//设置时间格式
        String rtime = sdf.format(new Date());//操作时间
        user.setRtime(rtime);
        user.setState("启用");
        user.setScore(100);
        user.setUpcount(0);
        user.setDowncount(0);
        user.setRoleid(2);
        Integer a  =myService.addUser(user);
        if (0<a){
            Integer score = myService.findRegistIncentives();//拿到奖励分
            user.setScore(score);
            response.getWriter().print("success");

        }else{
            response.getWriter().print("error");
        }

    }

    //查询用户信息表
    @RequestMapping("/UserTableInf")
    @ResponseBody//ajax返回值json格式转换
    public DateTable UserTableInf(HttpServletRequest request, HttpServletResponse response){
        int page= Integer.parseInt(request.getParameter("page"));
        int limit= Integer.parseInt(request.getParameter("limit"));

        String userid= request.getParameter("userid");
        String rtime1 =request.getParameter("time1");
        String rtime2 =request.getParameter("time2");
        Map<String,Object>InfMap = new LinkedHashMap<>();
        int minLimit = (page-1)*limit;
        int maxLimit = limit;
        InfMap.put("userid",userid);
        InfMap.put("minLimit",minLimit);
        InfMap.put("maxLimit",maxLimit);
        InfMap.put("rtime1",rtime1);
        InfMap.put("rtime2",rtime2);
        List<User> list=myService.findAllUserByPage(InfMap);
        Integer a =myService.findAllUserCount(InfMap);
        if (null!=list){
            dateTable.setData(list);
            dateTable.setCode(0);
            dateTable.setCount(a);//总条数
            return dateTable;

        }
        return null;
    }

    //删除用户
    @RequestMapping("/deleteUserInf")
    public void deleteUserInf(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer uid= Integer.valueOf(request.getParameter("uid"));
        Integer a = myService.deleteUserInf(uid);
        if (1==a){
            response.getWriter().print("success");
        }else{
            response.getWriter().print("error");
        }

    }

    //更新用户信息
    @RequestMapping("/userInfUpdate")
    public void userInfUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String updateUserInf = request.getParameter("updateUserInf");
        User user =  g.fromJson(updateUserInf,User.class);
        Integer uid = Integer.valueOf(request.getParameter("uid"));
        user.setUserid(uid);
        Integer a= myService.updateUserInf(user);
        if (1==a){
            response.getWriter().print("1111");
        }else{
            response.getWriter().print("2222");
        }
    }
    //修改用户状态
    @RequestMapping("/changeUserState")
    public void changeUserState(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Integer uid= Integer.valueOf(request.getParameter("uid"));
        String state = request.getParameter("butName");
        Map<String,Object>InfMap = new LinkedHashMap<>();
        InfMap.put("userid",uid);
        if ("启用".equals(state.trim())){
            InfMap.put("state","启用");
            Integer a = myService.changeUserState(InfMap);
            if (1==a){
                response.getWriter().print("success");
            }else{
                response.getWriter().print("error");
            }

        }else if ("禁用".equals(state.trim())){
            InfMap.put("state","禁用");
            Integer a = myService.changeUserState(InfMap);
            if (1==a){
                response.getWriter().print("success");
            }else{
                response.getWriter().print("error");
            }
        }

    }


    //文件上传
    @RequestMapping("/upload")
    @ResponseBody//ajax返回值json格式转换
    public String upload(MultipartFile file, String bookName) throws IOException {

        if (!StringUtils.isEmpty(file) && file.getSize()>0){
            String name= file.getOriginalFilename();//是得到上传时的文件名。
            String suffix = name.substring(name.lastIndexOf(".") + 1);
            System.out.println("文件类型="+suffix);
            if (name.endsWith("tet")||name.endsWith("png")){
                try {
                    file.transferTo(new File("D:\\test\\" + name));
                    return "{\"code\":0, \"msg\":\"\", \"data\":{}}";
                } catch (IOException e) {
                    e.printStackTrace();
                      return "{\"code\":1, \"msg\":\"\", \"data\":{}}";
                }
            }else {
                return "{\"code\":2, \"msg\":\"\", \"data\":{}}";
            }
        }else {
            return "{\"code\":3, \"msg\":\"\", \"data\":{}}";
        }

    }

    //文件下载
    @RequestMapping("/downDocumentInf")
    @ResponseBody//ajax返回值json格式转换
    public ResponseEntity<byte[]> downDocumentInf(String did) throws IOException {
        System.out.println("did=="+did);
          Document document1= myService.findDocument(Integer.valueOf(did));
        File file=new File(document1.getUrl());
        HttpHeaders headers = new HttpHeaders();
        String fileName=new String(document1.getTitle().getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题
        headers.setContentDispositionFormData("attachment", fileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        myService.DownCount(document1.getDid(),document1.getDowncount());//更新下载次数
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }

    //文档审核页码跳转
    @RequestMapping("/uploadRecord")
    public String uploadRecord(HttpServletRequest request, HttpServletResponse response){
        List<DocumentType> documentTypes=myService.findDocumentType();
        request.setAttribute("documentTypes",documentTypes);
        return "back/jsp/documentReview";
    }


    //文档审核
    @RequestMapping("/documentReview")
    @ResponseBody//ajax返回值json格式转换
    public DateTable documentReview(HttpServletRequest request, HttpServletResponse response){
        int page= Integer.parseInt(request.getParameter("page"));
        int limit= Integer.parseInt(request.getParameter("limit"));

        String title= request.getParameter("title");//标题
        String type= request.getParameter("type");//类型
        String who= request.getParameter("who");//上传人
        String rtime1 =request.getParameter("time1");//时间1
        String rtime2 =request.getParameter("time2");//时间2
        Map<String,Object>InfMap = new LinkedHashMap<>();
        int minLimit = (page-1)*limit;
        int maxLimit = limit;
        InfMap.put("title",title);
        InfMap.put("type",type);
        InfMap.put("who",who);
        InfMap.put("minLimit",minLimit);
        InfMap.put("maxLimit",maxLimit);
        InfMap.put("rtime1",rtime1);
        InfMap.put("rtime2",rtime2);
        List<Document> list=myService.findDocumentByUid(InfMap);
        Integer a =myService.findDocumentCount(InfMap);
        if (null!=list){
            dateTable.setData(list);
            dateTable.setCode(0);
            dateTable.setCount(a);//总条数
            return dateTable;
        }
        return null;
    }


    //修改文档状态
    @RequestMapping("/changeDocumentState")
    public void changeDocumentState(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Integer did= Integer.valueOf(request.getParameter("did"));
        String state = request.getParameter("butName");
        System.out.println("butName="+state);
        String typename = request.getParameter("typename");
        Integer userid = Integer.valueOf(request.getParameter("userid"));
        Map<String,Object>addScoreRecord = new LinkedHashMap<>();
        addScoreRecord.put("userid",userid);
        addScoreRecord.put("typename",typename);
        Map<String,Object>InfMap = new LinkedHashMap<>();
        InfMap.put("did" ,did);
        if ("审核通过".equals(state.trim())){
            InfMap.put("dstate","已通过");
            Integer a = myService.changeDocumentState(InfMap);
            if (1==a){
                myService.addScoreRecord(addScoreRecord);
                response.getWriter().print("success");
            }else{
                response.getWriter().print("error");
            }
        }else if ("审核不通过".equals(state.trim())){
            InfMap.put("dstate","未通过");
            Integer a = myService.changeDocumentState(InfMap);
            if (1==a){
                response.getWriter().print("success");
            }else{
                response.getWriter().print("error");
            }
        }

    }


    //设置用户注册奖励
    @RequestMapping("/registIncentives")
    public void registIncentives(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Integer score= Integer.valueOf(request.getParameter("score"));
        Integer a = myService.registIncentives(score);
        if (1==a){
            response.getWriter().print("success");
        }else{
            response.getWriter().print("error");
        }

    }

    //设置文档上传奖励
    @RequestMapping("/uploadReward")
    @ResponseBody//ajax返回值json格式转换
    public DateTable uploadReward(HttpServletRequest request, HttpServletResponse response){
        int page= Integer.parseInt(request.getParameter("page"));
        int limit= Integer.parseInt(request.getParameter("limit"));
        String typename= request.getParameter("typename");
        Map<String,Object>InfMap = new LinkedHashMap<>();
        int minLimit = (page-1)*limit;
        int maxLimit = limit;
        InfMap.put("typename",typename);
        InfMap.put("minLimit",minLimit);
        InfMap.put("maxLimit",maxLimit);
        List<DocumentType> list=myService.findType(InfMap);
        Integer a =myService.findTypeCount(InfMap);
        if (null!=list){
            dateTable.setData(list);
            dateTable.setCode(0);
            dateTable.setCount(a);//总条数
            return dateTable;

        }
        return null;
    }


    //删除文档格式
    @RequestMapping("/deleteType")
    public void deleteType(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer typeid= Integer.valueOf(request.getParameter("typeid"));
        Integer a = myService.deleteType(typeid);
        if (1==a){
            response.getWriter().print("success");
        }else{
            response.getWriter().print("error");
        }

    }

    //更新文档格式
    @RequestMapping("/updateType")
    public void updateType(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String updateUserInf = request.getParameter("updateUserInf");
        DocumentType documentType =  g.fromJson(updateUserInf,DocumentType.class);
        Integer typeid = Integer.valueOf(request.getParameter("typeid"));
        documentType.setTypeid(typeid);
        Integer a = myService.updateType(documentType);
        if (1==a){
            response.getWriter().print("1111");
        }else{
            response.getWriter().print("2222");
        }
    }

    //添加文档格式
    @RequestMapping("/addType")
    public void addType(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String addTypeInf = request.getParameter("addTypeInf");
        DocumentType documentType =  g.fromJson(addTypeInf,DocumentType.class);
        Integer a = myService.addType(documentType);
        if (1==a){
            response.getWriter().print("success");
        }else{
            response.getWriter().print("error");
        }
    }



    //获取管理员的权限
    @RequestMapping("/adminAuthority")
    public void adminAuthority(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        Integer mid=Integer.valueOf(request.getParameter("mid")) ;
        List<Tree> tree1 =myService.allMenuByRid();
        List<Tree> tree2 =myService.allMidByRid(mid);
        for (int i=1;i<tree2.size();i++){
            tree2.get(i).getId();
        }
        Map map = new HashMap();
        map.put("menu",tree1);
        map.put("mid",tree2);
        ResponseUtils.outJson(response,map);
    }

    //获取新的管理员的权限
    @RequestMapping("/sureAuthority")
    public void sureAuthority(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String msg = request.getParameter("MenuTable");
        Integer rid = Integer.valueOf(request.getParameter("mid"));
        Menu menu = g.fromJson(msg, Menu.class);

        ArrayList fatherNodeId = (ArrayList) menu.getFatherNodeId();//父菜单id
        ArrayList sonNodeId = (ArrayList) menu.getSonNodeId();//子菜单id

        ArrayList roleMenuTableList = new ArrayList<>();
        roleMenuTableList.addAll(fatherNodeId);
        roleMenuTableList.addAll(sonNodeId);

        List<Map<String, Integer>> list = new ArrayList();
        for (int i = 0; i < roleMenuTableList.size(); i++) {
            Map<String, Integer> menuMap = new LinkedHashMap();
            Integer mid = Double.valueOf(roleMenuTableList.get(i).toString()).intValue();
            menuMap.put("rid", rid);//角色id
            menuMap.put("mid", mid);//菜单id
            list.add(menuMap);
        }

        myService.deleteMenuRelation(rid);
        Integer a1 = myService.insertMenuRelation(list);
        if (a1>0){
            response.getWriter().print("success");
        }else{
            response.getWriter().print("error");
        }



//        List<Relation> list = new ArrayList<>();
//        Gson g = new Gson();
//        Tree[] tree = g.fromJson(a, Tree[].class);//把字符串转换成对象
//        for (int i = 0; i < tree.length; i++) {
//            Relation relation = new Relation();
//            relation.setMid(tree[i].getId());
//            relation.setRoleid(rid);
//            list.add(relation);
//            for (int j = 0; j < tree[i].getChildren().size(); j++) {
//                Relation relation1 = new Relation();
//                relation1.setMid(tree[i].getChildren().get(j).getId());
//                relation1.setRoleid(rid);
//                list.add(relation1);
//            }
//        }
//
//        myService.deleteMenuRelation(rid);
//        Integer a1 = myService.insertMenuRelation(list);
//        System.out.println("更新后的菜单=="+list.toString());
//        if (a1>0){
//            response.getWriter().print("success");
//        }else{
//            response.getWriter().print("error");
//        }
    }

    //获取角色表
    @RequestMapping("/role")
    @ResponseBody//ajax返回值json格式转换
    public DateTable role(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        int page= Integer.parseInt(request.getParameter("page"));
        int limit= Integer.parseInt(request.getParameter("limit"));

        Map<String,Object>InfMap = new LinkedHashMap<>();
        int minLimit = (page-1)*limit;
        int maxLimit = limit;
        InfMap.put("minLimit",minLimit);
        InfMap.put("maxLimit",maxLimit);
        List<Role> list=myService.findAllRoleByPage(InfMap);
        System.out.println();
        Integer a =myService.findAllRoleCount();
        if (null!=list){
            dateTable.setData(list);
            dateTable.setCode(0);
            dateTable.setCount(a);//总条数
           return dateTable ;

        }
        return null;
    }

}
