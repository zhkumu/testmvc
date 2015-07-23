package other;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 如果有ExceptionHandler之类的异常处理方法能处理相关的异常，那么这个异常处理会失效
 * @author mu
 *
 */
@ResponseStatus(value=HttpStatus.BAD_GATEWAY,reason="test_bad_gateway")
public class MuException extends Exception {
	public MuException(String msg){
		super(msg);
	}
}
