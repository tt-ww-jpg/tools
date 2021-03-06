![](https://img.shields.io/badge/version-1.6.5-green.svg) &nbsp; ![](https://img.shields.io/badge/builder-success-green.svg) &nbsp;
![](https://img.shields.io/badge/Author-Gjing-green.svg) &nbsp;

Java开发基础工具包
## 一、引入依赖
```xml
<dependency>
  <groupId>cn.gjing</groupId>
  <artifactId>tools-common</artifactId>
  <version>1.6.5</version>
</dependency>
```
## 二、允许跨域: 
开启全局允许跨域, 在启动类或者任意类使用``@EnableCors``注解即可，会走默认配置，也可以自定义配置，配置示例如下：
 * **yml方式**
```yaml
tools:
  common:
    cors:
      # 支持的方法类型
      allowed-methods: POST,GET,DELETE,PUT,OPTIONS
      # 支持的请求头
      allowed-headers:
      # 支持的域名
      allowed-origins:
      # 方法路径
      path: /**
      max-age: 1800
```
* **javaBean方式**
```java
/**
 * @author Gjing
 **/
@Configuration
public class CorsConfiguration {
    @Bean
    public CorsBean corsBean() {
        CorsBean corsBean = new CorsBean();
        corsBean.setAllowedMethods(new String[]{"POST"});
        return corsBean;
    }
}
```

## 三、结果bean:   
### 1、ResultVO
通用返回结果模板     

|参数|描述|
|---|---|
|code|状态码|
|message|提示信息|
|data|数据|
### 2、PageResult
分页查询返回结果集    

|参数|描述|
|---|---|
|totalPages|总页数|
|CurrentPage|当前页数|
|totalRows|总条数|
|pageRows|每页的条数|
|data|数据|
### 3、ErrorResult
错误返回模板      

|参数|描述|
|---|---|
|code|状态码|
|message|提示信息|
## 四、参数校验工具类： 
**主要提供参数校验、处理,匹配等等， 使用时通过``ParamUtils.xxx()``使用，以下为该工具的所有方法介绍 :**  
### 1、isEmpty
判断给定参数是否为空，可以是字符串、包装类型、数组、集合等    

|参数|描述|
|---|---|
|param|参数|
### 2、isNotEmpty
判断给定是否不为空，可以是字符串、包装类型、数组、集合等     

|参数|描述|
|---|---|
|param|参数|
### 3、requireNotNull
该参数不能为空，为空抛出NPE，否则返回原值     

|参数|描述|
|---|---|
|param|参数|
### 4、ListHasEmpty
判断集合里是否含有空值   

|参数|描述|
|---|---|
|list|集合|
### 5、multiEmpty
检查多个参数里面是否有空值     

|参数|描述|
|---|---|
|params|多个参数|
### 6、equals
判断两个参数是否相等    

|参数|描述|
|---|---|
|param1|参数1|
|param2|参数2|
### 7、trim
去除字符串的空格     

|参数|描述|
|---|---|
|str|字符串|
### 8、trim
去除集合中的空元素     

|参数|描述|
|---|---|
|list|集合|
### 9、removeSymbol
移除字符串两边的指定符号      

|参数|描述|
|---|---|
|str|字符串|
|symbol|符号|
### 10、removeStartSymbol
移除字符串开始的指定符号     

|参数|描述|
|---|---|
|str|字符串|
|symbol|符号|
### 11、removeEndSymbol
移除字符串末尾的指定符号    

|参数|描述|
|---|---|
|str|字符串|
|symbol|符号|
### 12、split
根据符号截取    

|参数|描述|
|---|---|
|str|字符串|
|symbol|符号|
### 13、removeAllSymbol
移除字符串里的所有指定符号    

|参数|描述|
|---|---|
|str|字符串|
|symbol|符号|
### 14、contains
判断数组里是否包含指定的值     

|参数|描述|
|---|---|
|arr|数组|
|val|值|
### 15、isEmail
判断是否为email       

|参数|描述|
|---|---|
|email|字符串|
### 16、isMobileNumber
判断是否是手机号码    

|参数|描述|
|---|---|
|phone|字符串|
### 17、isTelPhone
判断是不是电话号码     

|参数|描述|
|---|---|
|tel|字符串|
### 18、isPostCode
判断是否为邮编    

|参数|描述|
|---|---|
|postCode|字符串|
## 五、时间工具类： 
**对时间进行操作，使用时通过``TimeUtils.xxx()``调用，该工具的所有方法介绍如下 :**
## 六、加密工具类
### 1、EncryptionUtils：
  * **EncryptionUtils.encodeMd5()**：MD5加密
  * **EncryptionUtils.encodeBase64()**：Base64加密
  * **EncryptionUtils.decodeBase64()**：Base64解密
### 2、ShaUtils:
  * **ShaUtils.encodeSha256Hmac()**：Sha356Hmac加密
  * **ShaUtils.sha1Hmac()**：sha1Hmac加密
### 3、AesUtils:
  * **AesUtils.encode()**：AES加密
  * **AesUtils.decode()**：AES解密
## 七、随机数工具类
**用于随机生成数字或字符串，使用时通过``RandomUtils.xxx()``调用，该工具包含的所有方法如下 :**
  * **RandomUtils.randomInt()**：获取随机整数，可设置最大值和最小值
  * **RandomUtils.getRandom()**：获取一个Random实例
  * **RandomUtils.generateMixString()**：生成混合指定长度字符串（数字、字母大小写）
  * **RandomUtils.generateString()**：获取指定长度纯字符串（字母大小写）
  * **RandomUtils.generateNumber()**：获取指定长度数字字符串
## 八、Bean工具类
**使用时通过``BeanUtils.xxx()``调用**
### 1、copyProperties
属性复制，用于将一个对象的属性赋值到另一个对象，两个对象间的``参数名和数据类型必须相同``      
**参数说明**     

|参数|描述|
|-----|-----|
|source|源对象|
|target|目标对象|
|ignores|忽略的字段，设置后不会进行复制|     

### 2、toBean
将map转为bean对象     
**参数说明**      

|参数|描述|
|-----|-----|
|map|需要转为Bean的map|
|beanClass|目标Bean的class|
### 3、findMethod
查找类中的方法       
**参数说明**     

|参数|描述|
|-----|-----|
|clazz|目标类class|
|methodName|方法名|
|paramTypes|方法参数类型|
### 4、findDeclaredMethod
查找类中声明的方法       
**参数说明**     

|参数|描述|
|---|---|
|clazz|目标类class|
|methodName|方法名|
|paramTypes|方法参数类型|
### 5、setFieldValue
给类中的某个字段设置值     
**参数说明**     

|参数|描述|
|-----|-----|
|o|字段所在的对象|
|field|字段|
|value|值|
### 6、getFieldValue
获取某个字段的值    
**参数说明**    

|参数|描述|
|-----|-----|
|o|字段所在的对象|
|field|字段|
### 7、toMap
将bean对象转为map         
**参数说明**     

|参数|描述|
|-----|-----|
|bean|需要转为map的bean对象|
### 8、getInterfaceType
获取泛型接口中某个泛型的真实对象class     
**参数说明**     

|参数|描述|
|---|---|
|source|实现泛型接口的类|
|typeInterface|泛型接口|
|paramIndex|泛型参数下标，0开始|
### 9、getGenericType
获取某个泛型字段的真实对象class
**参数说明**     

|参数|描述|
|---|---|
|type|字段的泛型类型|
|paramIndex|泛型参数下标，0开始|
## 九、唯一ID生成工具类
**项目中使用可以将``IdUtils``注册为一个bean以在其他地方进行依赖注入, 或者将其设置为``静态的``, 不要出现重复的``IdUtils``对象, 否则并发情况下会出现重复,
如果要调用``snowId``, 必须通过带参数的构造方法进行创建实例**
### 1、uuid 
获取去除``-``符号的uuid
```java
public class Test{
    public static void main(String[] args){
      IdUtils idUtils = new IdUtils();
      System.out.println(idUtils.uuid());
    }
}
```
### 2、snowId
得到一个唯一的ID，在多服务需要操作同一个数据表的情况下, 需要保证每个服务的``centerId``和``machineId``唯一   
```java
public class Test{
    public static void main(String[] args){
      IdUtils idUtils = new IdUtils(1,2);
      for(int i = 0; i < 100; i++) {
        System.out.println(idUtils.snowId());
      }
    }
}
```
## 十、邮件工具类 
**用于发送邮件，支持普通邮件和带附件邮件,支持html格式文本,支持群发和抄送,返回true为发送成功，使用时通过``EmailUtils.of()``生成实例之后在进行其中的方法，``of()``方法参数如下 :**     

|参数|描述|
|-----|-----|
|host|smtp服务器地址,比如qq邮箱:smtp.qq.com|
|password|发送者邮箱密码,有些邮箱需要用授权码代替密码|
|from|发送人邮箱|    

**该工具包含的所有方法如下 :**
### 1、sendEmail
发送邮件，参数如下：   

|参数|描述|
|-----|-----|
|subject|主题|
|body|邮件内容，支持HTML|
|files|要发送的附件物理地址,不要可以传null或者空数组|
|tos|收件人邮箱账号，多个使用逗号隔开|
|copyTo|抄送人地址，多个用逗号隔开，不抄送可以传null或者空字符串|    

**完整示例如下 :**
```java
public class Test{
    public static void main(String[] args) {
        boolean b = EmailUtil.of("smtp.qq.com", "发送人密码或者授权码", "发送人邮箱")
                .sendEmail("主题", "内容",new String[]{"附件物理地址"},"收件人邮箱地址", "抄送人邮箱地址");
        if (b) {
            System.out.println("发送成功");
        }
    }
}
```
## 十一、二维码工具类
**二维码工具类, 包含的所有方法如下 :**
### 1、create()
根据文本内容，自定义宽度高度，自定义图片格式，自定义配置信息，生成所需要的二维码图片，所有参数如下         

|参数|描述|
|---|---|
|text|文本内容|
|filePath|生成图片路径|
|width|宽|
|height|高|
|format|图片格式 ,png,img|
|hintTypes|自定义配置信息|    
### 2、createWithLogo()
自定义生成带logo的二维码图片，所有参数如下：     

|参数|描述|
|---|---|
|text|文本内容|
|filePath|生成图片路径|
|logoPath|logo文件路径|
|qrCodeWidth|二维码宽度|
|qrCodeHeight|二维码高度|
|logoWidth|logo宽度|
|logoHeight|logo高度|
|format|图片格式|       

### 3、read(String filePath)
解析二维码,获取其中文本信息

**参数说明**
  
|参数|描述|
|---|---|
|filePath|图片路径|

### 4、read(InputStream inputStream)
解析二维码,获取其中的文本信息

**参数说明**
  
|参数|描述|
|---|---|
|inputStream|输入流|

### 5、read(String filePath, Map<DecodeHintType, Object> decodeHints)
自定义配置解析二维码,获取其中的文本信息

**参数说明**
  
|参数|描述|
|---|---|
|filePath|图片路径|
|decodeHints|解析配置信息|

### 6、read(InputStream inputStream, Map<DecodeHintType, Object> decodeHints)
自定义配置解析二维码,获取其中的文本信息

**参数说明**
  
|参数|描述|
|---|---|
|inputStream|输入流|
|decodeHints|解析配置信息|
## 十二、验证码工具类
**用于生成英文和数字混合的验证码，使用时通过构造``AuthCodeUtils``在进行调用其中的方法，构造时参数如下 :**    

|参数|描述|
|----|----|
|width|验证码图片宽度|
|height|验证码图片高度|
|codeCount|验证码字符个数|
|lineCount|验证码干扰线数|     

**该工具下的所有方法如下:**
### 1、writeToLocal
生成验证码到本地，案例如下
```java
public class Test{
    public static void main(String[] args) {
        AuthCodeUtil authCodeUtil = new AuthCodeUtil(160,40,5,150);
        try {
            String path="/文件夹路径/code.png";
            //写入到本地时可以通过getCode()方法获取生成的验证码
            String code = authCodeUtil.writeToLocal(path).getCode();
            System.out.println(code);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
### 2、getCode
获取生成的验证码字符
```java
public class Test{
    public static void main(String[] args){
      String code = authCodeUtil.writeToLocal(xxx).getCode;
      System.out.println(code);
    }
}
```
### 3、write
以流的方式返回给前端，案例如下
```java
public class Test{
    @GetMapping("/code")
    public void getCode(HttpServletResponse response, HttpServletRequest request) throws IOException {
        AuthCodeUtil authCodeUtil = new AuthCodeUtil(100, 50, 4, 50);
        response.setContentType("image/jpeg");
        //禁止图像缓存
        response.setHeader("param", "no-cache");
        response.setDateHeader("Expires", 0);
        authCodeUtil.write(response.getOutputStream());
    }
}
```
## 十三、Spring Bean工具类
**获取Spring Bean和ApplicationContext**
### 1、获取Bean
```java
public class Test{
    @GetMapping("/test")
    public void test(){
        //通过class获取
        Test test = SpringBeanUtils.getBean(Test.class);
        //通过bean name获取
        Object o = SpringBeanUtils.getBean("test");
    }
}
```
### 2、获取ApplicationContext
```java
public class Test{
    private ApplicationContext applicationContext;
    
    public Test(){
        this.applicationContext = SpringBeanUtils.getApplicationContext();
    }
}
```
---
