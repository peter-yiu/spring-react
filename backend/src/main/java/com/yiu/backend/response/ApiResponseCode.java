package com.yiu.backend.response;



import java.util.ArrayList;
import java.util.List;

public enum ApiResponseCode {
    /* 成功状态码 */
    SUCCESS(1, "success"),
    FAILED(0, "failed"),


    /* 用户错误：1001-1999 */
    USER_NOT_LOGGED_IN(1001, "The account do not login"),
    USER_LOGIN_ERROR(1002, "The email address and/or password you have entered does not match what is in our system. Please enter a valid email address and password combination or select \"Forgot your password?"),
    USER_ACCOUNT_FORBIDDEN(1003, "The account have been forbidden!"),
    USER_NOT_EXIST(1004, "Account do not existed or expired"),
    USER_EMAIL_HAS_EXISTED(1005, "register.email.existed"),
    USER_HAS_EXISTED(1006, "register.userName.existed"),
    USER_EXCESSIVE_ATTEMPTS(1007, "Login failure more than 5 times,please try again after 5 minute!"),
    USER_AUTH_CODE_EXPIRED(1011, "Auth code timeout expired, please get it again!"),
    USER_AUTH_CODE_INCORRECT(1012, "Auth code is incorrect, please refill!"),

    /* 参数错误： 2001-2999*/
    PARAM_IS_INVALID(2001, "Parameters is invalid"),
    PARAM_IS_BLANK(2002, "Parameters is blank"),
    PARAM_TYPE_BIND_ERROR(2003, "Parameters type error"),
    PARAM_NOT_COMPLETE(2004, "Parameters not complete"),

    

    /* 业务错误：3001-3999 */
    SPECIFIED_QUESTIONED_USER_NOT_EXIST(3001, "Business Error!"),

    CHECKOUT_ERROR(3100, "Checkout Error Now!"),

    /* 系统错误：4001-4999 */
    SYSTEM_INNER_ERROR(4001, "系统繁忙，请稍后重试"),
    SYSTEM_UPLOAD_ERROR(4005, "Unexpected error when handling uploaded file"),

    /* 数据错误：5001-59999 */
    RESULE_DATA_NONE(5001, "数据未找到"),
    DATA_IS_WRONG(5002, "数据有误"),
    DATA_ALREADY_EXISTED(5003, "数据已存在"),

    /* 接口错误：6001-6999 */
    INTERFACE_INNER_INVOKE_ERROR(6001, "内部系统接口调用异常"),
    INTERFACE_OUTTER_INVOKE_ERROR(6002, "外部系统接口调用异常"),
    INTERFACE_FORBID_VISIT(6003, "该接口禁止访问"),
    INTERFACE_ADDRESS_INVALID(6004, "接口地址无效"),
    INTERFACE_REQUEST_TIMEOUT(6005, "接口请求超时"),
    INTERFACE_EXCEED_LOAD(6006, "接口负载过高"),



    /* 权限错误：7001-7999 */
    API_KEY_ERROR(7000, "api secret error "),
    PERMISSION_NO_ACCESS(7001, "无访问权限");



    private Integer code;

    private String message;

    ApiResponseCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public static String getMessageByName(String name) {
        for (ApiResponseCode item : ApiResponseCode.values()) {
            if (item.name().equals(name)) {
                return item.message;
            }
        }
        return name;
    }

    public static Integer getCodeByName(String name) {
        for (ApiResponseCode item : ApiResponseCode.values()) {
            if (item.name().equals(name)) {
                return item.code;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name();
    }

    //校验重复的code值
    public static void main(String[] args) {
        ApiResponseCode[] apiResponseCodes = ApiResponseCode.values();
        List<Integer> codeList = new ArrayList<Integer>();

        for (ApiResponseCode ApiResponseCode : apiResponseCodes) {
            if (codeList.contains(ApiResponseCode.code)) {
                System.out.println("重复的状态 = " + ApiResponseCode.code);
            } else {
                codeList.add(ApiResponseCode.getCode());
            }
        }
        System.out.println("状态 = ");
        for (ApiResponseCode ApiResponseCode : apiResponseCodes) {
            System.out.println(ApiResponseCode +":"+ ApiResponseCode.code +":"+ ApiResponseCode.message);
        }

        System.out.println("ApiResultCode.INTERFACE_ADDRESS_INVALID.code = " + ApiResponseCode.INTERFACE_ADDRESS_INVALID.code);
    }
}
