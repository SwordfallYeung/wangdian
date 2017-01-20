package cn.wangdian.utils.alipay.config;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.4
 *修改日期：2016-03-08
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 合作身份者ID，签约账号，以2088开头由16位纯数字组成的字符串，查看地址：https://b.alipay.com/order/pidAndKey.htm
	public static String partner = "2088521046622606";

	// 收款支付宝账号，以2088开头由16位纯数字组成的字符串，一般情况下收款账号就是签约账号
	public static String seller_id = partner;

	//商户的私钥,需要PKCS8格式，RSA公私钥生成：https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.nBDxfy&treeId=58&articleId=103242&docType=1
	public static String private_key = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAMK4tYAw0+cbMHU/6yjuKC+IGdIViUVKr5ZO2Gne1VkLb2s0cSffsndfUnqK/R9U5l/VQpkwghuwSnTIMeSMcVwvqRq4q7HnGi7rzUpvAqIRoLX2O1sH/fzp/WQEB4lZupN8WjxXzz5cQX9WXJaypy2eO3DHAcBdg5SxI2jISLbnAgMBAAECgYA/triMzW1IvXjJpLSJnAPCKcJpH2rfJWT2xa3CVotwq3E1nt83sNZwgNw4BKp2Sg1nZhx4i4rHDJQQSkEpC1s7wIQZoyjdwbghC1DX59nPkx/uuPVdydFzvuZtuDU8G+/KHs8HqJLIDCXtDsk8aYdEB0dh4W3/FhCLwlA9MovJ4QJBAOpe79dOp8saqZf0wgtapXPGASSbZFv+k+XJXvOK7Mv9Yz6VjPpNKv/1wXIlm9sU82k9XP+ygqhbJ4K/zxBtaFMCQQDUsQxHqqx76PLgvYOnTPpQNwmFUM4j0TcQNfhg6gIb2dzuJslY5Q8HIUaMzPq2rHj4i42uMXw28/kDdbRUqdSdAkBBmPbaNWqjX0AOhvP0x5c9czMIsvGBCh0NGLKZyc2DPtWTQ7pkqEqbv4Y4U6xuwktqrkEkVCtbwb+qSdNDzst/AkEAxwdSVXIJ6/3F4baWDyVCi3OlLiK6c9vgagQHBDGWfZd2XUjgW5YlZOenjDR4XB6zKOn2T84wzX+qQqmPcTZnJQJBAKEmLo0s63zMscRn7pOCnQLlVs2Vz7iEC44MFRyr7bQhSqyFTP2DBUkQyAagkerOAVbPKR5fqc1jBVcPC9jXQkg=";

	//这个与商户公钥不同，请注意!!!
	// 支付宝的公钥,查看地址：https://b.alipay.com/order/pidAndKey.htm
	public static String alipay_public_key  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";

	// 服务器异步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	// {example}写自己的域名，
	// {project_name}写自己的项目名
	// 如此配置是为了支付成功后可以成功回调到自己的服务器
	public static String notify_url = "http://www.91sps.com/notify_url";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	// {example}写自己的域名，
	// {project_name}写自己的项目名
	// 如此配置是为了支付成功后可以成功回调到自己的服务器
	public static String return_url = "http://www.91sps.com/return_url";

	// 签名方式
	public static String sign_type = "RSA";

	// 调试用，创建TXT日志文件夹路径，见AlipayCore.java类中的logResult(String sWord)打印方法。
	public static String log_path = "C:\\";

	// 字符编码格式 目前支持utf-8
	public static String input_charset = "utf-8";

	// 支付类型 ，无需修改
	public static String payment_type = "1";

	// 调用的接口名，无需修改
	public static String service = "alipay.wap.create.direct.pay.by.user";





//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

}

