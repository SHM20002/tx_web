package cn.tedu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 用户实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class User implements Serializable {
    private String username;
    private String password;
    private String chrName;
    private String role;
}
