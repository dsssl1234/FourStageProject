package com.great.controller;


import com.google.gson.Gson;
import com.great.aoplog.Log;
import com.great.entity.*;
import com.great.entity.Menu;
import com.great.service.MyService;
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
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

@Controller
@RequestMapping("/user")//@RequestMapping：可以为控制器指定处理可以请求哪些URL请求。
public class UserController {
    Gson g = new Gson();
    private Random random = new Random();
    @Autowired
    private MyService myService;
    @Resource
    private DateTable dateTable;
    @Resource
    private Document document;


    @RequestMapping("/path/{url}")
    public String getUrl(@PathVariable(value = "url") String path){
        System.out.println("path="+path);
        return "/front/jsp/" +path;
    }

    @RequestMapping("/Login")
//    @Log(operationType = "登录操作", operationName = "用户登录")
    public void Login(User user1 , HttpServletRequest request, HttpServletResponse response) throws IOException {
        String YZM = (String)request.getSession().getAttribute("vcode");//拿到验证码
        Boolean confirm = user1.getRePass().equalsIgnoreCase(YZM);//不区分大小写
        if (confirm) {
            User user =myService.findById(user1.getAccount(),user1.getPwd());
            if (null!=user){
                request.getSession().setAttribute("user",user);
                response.getWriter().print("success");
            }else{
                response.getWriter().print("error");
            }
        }else{
            response.getWriter().print("yzm");
        }

    }
    @RequestMapping("/PersonalInformation")
    public String PersonalInformation(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        System.out.println("user=="+user.toString());
        request.setAttribute("UserInf",user);
        return "front/jsp/userInf";
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

    @RequestMapping("/menu")
    public String menu(HttpServletRequest request, HttpSession hs){
        User user = (User) request.getSession().getAttribute("user");
        hs.setAttribute("name",user.getName());
        hs.setAttribute("roleType",user.getRole().getType());
        Map<String,List<Menu>> menuMap =myService.FindMenuByRoleId(user.getRole().getRoleid());//拿到菜单
        request.setAttribute("menuMap",menuMap);
        request.getSession().setAttribute("user",user);
        return "front/jsp/HomePage";
    }

    //注销登录
    @RequestMapping("/deleteUser")
    public String deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取sesson对象
        HttpSession hs = request.getSession();
        //注销
        hs.invalidate();
        //返回页面
        return "front/jsp/login";
    }
    //注册
    @RequestMapping("/Register")
    public void testLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
        Integer a =myService.addUser(user);
        if (0<a){
            response.getWriter().print("success");
        }else{
            response.getWriter().print("error");
        }
    }

    //文件上传
    @RequestMapping("/upload")
    @ResponseBody//ajax返回值json格式转换
    @Log(operationType = "文件上传", operationName = "文件上传")
    public String upload(MultipartFile file, String downScore, String bookName, String intro, HttpServletRequest request) throws IOException {
        if (!StringUtils.isEmpty(file) && file.getSize()>0&&null!=downScore&&!"".equals(downScore)&&null!=bookName&&!"".equals(bookName)){
            String name= file.getOriginalFilename();//是得到上传时的文件名。
            String suffix = name.substring(name.lastIndexOf(".") + 1);
            User user = (User) request.getSession().getAttribute("user");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");//设置时间格式
            String rtime = sdf.format(new Date());//操作时间
            document.setDownscore(Integer.valueOf(downScore));
            document.setTitle(bookName);
            document.setIntro(intro);
            document.setTypename(suffix);
            document.setUptime(rtime);
            document.setDstate("待审核");
            document.setDowncount(0);
            document.setUserid( user.getUserid());
            document.setUrl("D:\\test\\" + name);
            List<DocumentType> documentTypes=myService.findDocumentType();
            List typeName = new ArrayList();//存类型名
         for (int i= 0;i<documentTypes.size();i++){
             typeName.add(documentTypes.get(i).getTypename());
         }
            if (typeName.contains(suffix)){//集合是否包含要上传的文档类型
                Integer a= myService.insertInfByUid(document);
                file.transferTo(new File("D:\\test\\" + name));
                return "{\"code\":0, \"msg\":\"\", \"data\":{}}";
            }
            return "{\"code\":2, \"msg\":\"\", \"data\":{}}";
        }
        return "{\"code\":3, \"msg\":\"\", \"data\":{}}";
    }

    //查询用户积分是否能够下载
    @ResponseBody
    @RequestMapping("/judgeScore")
    public String judgeScore(Document document ,HttpServletRequest request, HttpServletResponse response){
        User user = (User) request.getSession().getAttribute("user");
       Integer num= myService.updateUserScore(user.getUserid(),document.getDownscore());
        if (1==num){
            return "success";
        }
        return "error";
    }


    //文件下载
    @RequestMapping("/downDocumentInf")
    @ResponseBody//ajax返回值json格式转换
    @Log(operationType = "下载操作", operationName = "下载文件")
    public ResponseEntity<byte[]> downDocumentInf(String did) throws IOException {
        Document document1= myService.findDocument(Integer.valueOf(did));
        File file=new File(document1.getUrl());
        //设置HttpHeaders,使得浏览器响应下载
        HttpHeaders headers = new HttpHeaders();
        //为了解决中文名称乱码问题
        String fileName=new String(document1.getTitle().getBytes("UTF-8"),"iso-8859-1");
        //设置响应文件 attachment附件的意思
        headers.setContentDispositionFormData("attachment", fileName);
        //设置响应方式  APPLICATION_OCTET_STREAM 二进制流数据（如常见的文件下载）
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        myService.DownCount(document1.getDid(),document1.getDowncount());//更新下载次数
        //把文件以二进制形式写回
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }

    @RequestMapping("/DocumentTableInf")
    @ResponseBody//ajax返回值json格式转换
    @Log(operationType = "查询操作", operationName = "查询文件信息")
    public DateTable DocumentTableInf( HttpServletRequest request){
        int page= Integer.parseInt(request.getParameter("page"));
        int limit= Integer.parseInt(request.getParameter("limit"));
        String demoReload= request.getParameter("key");
        Map<String,Object>InfMap = new LinkedHashMap<>();
        int minLimit = (page-1)*limit;
        int maxLimit = limit;
        InfMap.put("title",demoReload);
        InfMap.put("minLimit",minLimit);
        InfMap.put("maxLimit",maxLimit);
        List<Document> list=myService.findDocumentByUid(InfMap);
        Integer a =myService.findDocumentCount(InfMap);
        for (int i =0;i<list.size();i++){
            if ("待审核".equals(list.get(i).getDstate())){
                list.remove(i);
                i--;
            }
        }
        if (null!=list.get(0)){
            dateTable.setData(list);
            dateTable.setCode(0);
            dateTable.setCount(a);//总条数
            return dateTable;
        }
        return null;
    }

    //查询文档类型
    @RequestMapping("/uploadRecord")
    public String uploadRecord(HttpServletRequest request, HttpSession hs){
        List<DocumentType> documentTypes=myService.findDocumentType();
        request.setAttribute("documentTypes",documentTypes);
        return "front/jsp/uploadRecord";
    }


    //当前用户的文件上传记录表
    @RequestMapping("/uploadRecordTable")
    @ResponseBody//ajax返回值json格式转换
    public DateTable uploadRecordTable(HttpServletRequest request){
        int page= Integer.parseInt(request.getParameter("page"));
        int limit= Integer.parseInt(request.getParameter("limit"));
        String dstate= request.getParameter("state");
        String type =request.getParameter("type");
        String rtime2 =request.getParameter("time2");
        String rtime1 =request.getParameter("time1");
        User user = (User) request.getSession().getAttribute("user");
        Map<String,Object>InfMap = new LinkedHashMap<>();
        int minLimit = (page-1)*limit;
        int maxLimit = limit;
        InfMap.put("userid",user.getUserid());
        InfMap.put("rtime1",rtime1);
        InfMap.put("rtime2",rtime2);
        InfMap.put("type",type);
        InfMap.put("dstate",dstate);
        InfMap.put("minLimit",minLimit);
        InfMap.put("maxLimit",maxLimit);
        List<Document> list=myService.findDocumentRecord(InfMap);
        Integer a =myService.findDocumentRecordCount(InfMap);
        if (null!=list){
            dateTable.setData(list);
            dateTable.setCode(0);
            dateTable.setCount(a);//总条数
            return dateTable;
        }
    return null;
    }


    //删除用户
    @RequestMapping("/deleteDocumentInf")
    @Log(operationType = "删除操作", operationName = "删除上传文档")
    public void deleteDocumentInf(Document document1,  HttpServletResponse response) throws IOException {
        Integer a = myService.deleteDocumentInf(document1.getDid());
        if (1==a){
            response.getWriter().print("success");
        }else{
            response.getWriter().print("error");
        }
    }

    //获取分数
    @RequestMapping("/myScore")
    @ResponseBody//ajax返回值json格式转换
    public DateTable myScore( HttpServletRequest request) throws IOException {
        int page= Integer.parseInt(request.getParameter("page"));
        int limit= Integer.parseInt(request.getParameter("limit"));
        User user = (User) request.getSession().getAttribute("user");
        Map<String,Object>InfMap = new LinkedHashMap<>();
        int minLimit = (page-1)*limit;
        int maxLimit = limit;
        InfMap.put("userid",user.getUserid());
        InfMap.put("minLimit",minLimit);
        InfMap.put("maxLimit",maxLimit);
        List<MyScore> list=myService.findMyScore(InfMap);
        Integer a =myService.findMyScoreCount(user.getUserid());
        if (null!=list){
            dateTable.setData(list);
            dateTable.setCode(0);
            dateTable.setCount(a);//总条数
            return dateTable;
        }
        return null;
    }

}
