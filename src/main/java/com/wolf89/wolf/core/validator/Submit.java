/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wolf89.wolf.core.validator;

/**
 * 提交场景.
 * <pre>
 * 用于BeanValidator绑定groups.
 * 例如:
 * &nbsp;@NotNull(groups = {Submit.class})
 * &nbsp;private Type var
 * </pre>
 *
 * @author tangfeifei
 */
public interface Submit {
    // 不需要编写任何内容.
}
