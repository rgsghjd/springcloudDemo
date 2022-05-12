package com.atguigu.springcloud.error;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 自定义的错误处理类,方法必须为静态的，参数多一个Throwable 类型
 * 自定义的blockHandler,方法也是静态的，参数多一个BlockException 类型
 * 方法返回值，参数列表相同
 * 默认的fallback处理方法，不要写参数,或者只写一个Throwable 类型参数
 */
public class ErrorHandler {
    public static CommonResult<Payment> globalErrorHandler(@PathVariable Long id, Throwable throwable){
        return new CommonResult<>(555,"===服务器代码出现异常===");
    }
}
