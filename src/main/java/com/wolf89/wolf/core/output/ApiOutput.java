package com.wolf89.wolf.core.output;

import com.wolf89.wolf.core.annotation.EntityInfo;

import java.io.Serializable;

/**
 * 定义返回类型.
 *
 * @author gaoweibing
 */
public class ApiOutput<T> implements Serializable {

    /**
     * <pre>
     * 目前两个值:成功,200，失败,801.
     * </pre>
     */
    @EntityInfo(name = "编码", value = "code")
    private int code;

    @EntityInfo(name = "返回信息", value = "msg")
    private String msg;

    @EntityInfo(name = "成功标志", value = "success")
    private boolean success;

    @EntityInfo(name = "返回数据", value = "data")
    private T data;

    /**
     * 默认构造器.
     */
    public ApiOutput() {

        this.code = 200;
        this.success = true;
        this.msg = "操作成功";

    }

    /**
     * 默认
     *
     * @param data 数据.
     * @param <S>  泛型.
     * @return 泛型.
     */
    public static <S> ApiOutput of(S data) {

        ApiOutput<S> apiOutput = new ApiOutput();

        apiOutput.setData(data);

        return apiOutput;
    }

    /**
     * 不设置数据.
     *
     * @return 对象.
     */
    public static ApiOutput of() {

        ApiOutput apiOutput = new ApiOutput();

        return apiOutput;
    }

    /**
     * 设置失败.
     *
     * @param msg 信息.
     * @return 当前对象.
     */
    public ApiOutput fail(String msg) {

        this.code = 801;
        this.success = false;
        this.msg = msg;

        return this;
    }

    /**
     * 设置成功.
     *
     * @param msg 信息.
     * @return 当前对象.
     */
    public ApiOutput msg(String msg) {

        this.code = 200;
        this.success = true;
        this.msg = msg;

        return this;
    }

    /**
     * Gets the value of code.
     *
     * @return the value of code.
     */
    public int getCode() {
        return code;
    }

    /**
     * Sets the code.
     * <p>You can use getCode() to get the value of code.</p>
     *
     * @param code code.
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Gets the value of msg.
     *
     * @return the value of msg.
     */
    public String getMsg() {
        return msg;
    }

    /**
     * Sets the msg.
     * <p>You can use getMsg() to get the value of msg.</p>
     *
     * @param msg msg.
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * Gets the value of success.
     *
     * @return the value of success.
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Sets the success.
     * <p>You can use getSuccess() to get the value of success.</p>
     *
     * @param success success.
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * Gets the value of data.
     *
     * @return the value of data.
     */
    public T getData() {
        return data;
    }

    /**
     * Sets the data.
     * <p>You can use getData() to get the value of data.</p>
     *
     * @param data data.
     */
    public void setData(T data) {
        this.data = data;
    }
}
