package cn.tedu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Download {
	private int id;
	private String name;
	private String path;
	private String description;
	private long size;
	private int star;
	private String image;
	
}
